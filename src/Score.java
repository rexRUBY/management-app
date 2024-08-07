import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Score {

    /*
        0. 어떤 수강생 선택할 건지 입력 받고
        1. 수강생 객체에서 Map 불러오고
        2. Map에서 list 가 null 값인 경우 입력 받기
     */
    private static List<Student> students = StudentRepository.getStudents();
//    private static Student student;

    public static void scoreResister() {
        Scanner sc = new Scanner(System.in);

        // 학생 전체 리스트의 '고유번호 + 이름 + 상태' 출력
        for (Student temp : students) {
            StudentRepository.printStudentInfo(temp);
        }

        // 학생 고유번호 입력 받음
        System.out.println("점수를 등록할 학생의 고유번호를 선택하세요. : ");
        int inputId = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // 고유 번호에 대한 학생 객체 찾기
        Student student = StudentRepository.findStudentById(inputId);

        if (student == null) {
            System.out.println("해당 학생이 없습니다.");
            return; // 학생을 찾을 수 없으면 메서드 종료
        }

        System.out.println(student.getName());

        while (true) {
            ArrayList<String> nullList = new ArrayList<>();
            Set<Subject> set = student.getStudentMap().keySet();

            // 점수 리스트가 비어있는 과목 찾기
            for (Subject temp : set) {
                if (student.getStudentMap().get(temp).isEmpty()) {
                    nullList.add(temp.getSubjectName());
                }
            }

            System.out.println("점수를 등록할 수 있는 과목은 아래와 같습니다. 선택 하세요 (exit 종료)");
            System.out.println("===========");
            for (String str : nullList) {
                System.out.println("  " + str);
            }
            System.out.println("===========");

            // 해당 과목명 입력 받기
            String inputSubjectName = sc.nextLine();

            if (inputSubjectName.equals("exit")) {
                break;
            }

            Subject inputSubject = SubjectRepository.getSubjectName(inputSubjectName);
            if (inputSubject == null) {
                System.out.println("잘못된 과목명입니다. 다시 입력하세요.");
                continue;
            }

            ArrayList<Integer> targetSubjectList = student.getStudentMap().get(inputSubject);

            while (true) {
                System.out.print(inputSubjectName + " 과목에 대한 점수 입력 (10회차 까지) : ");
                String inputLine = sc.nextLine();
                String[] scores = inputLine.split(" ");

                // 점수 입력 가능 범위 내 맞는지 체크
                boolean isValid = true;
                for (String score : scores) {
                    int temp;
                    try {
                        temp = Integer.parseInt(score);
                    } catch (NumberFormatException e) {
                        System.out.println("점수는 숫자로 입력해야 합니다.");
                        isValid = false;
                        break;
                    }

                    if (temp > 100 || temp < 0) {
                        System.out.println("점수의 범위는 0 ~ 100까지 입니다.");
                        isValid = false;
                        break;
                    }
                }

                if (scores.length > 10) {
                    System.out.println("10회차까지만 입력 가능합니다.");
                    isValid = false;
                }

                if (!isValid) {
                    continue;
                }

                // 점수가 잘 입력되었다면
                for (String score : scores) {
                    targetSubjectList.add(Integer.parseInt(score));
                }

                // (test) 저장 되어 있는지 출력
                for (Integer temp : targetSubjectList) {
                    System.out.print(temp + " ");
                }
                System.out.println();
                break;
            }
        }
    }
}
