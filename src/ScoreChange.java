import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class  ScoreChange {
    private static List<Student> students = StudentRepository.getStudents();

    public static void sdgsagscoreChange() {
        Scanner sc = new Scanner(System.in);

        // 일단 수강생 리스트 출력
        for (Student temp : students) {
            StudentRepository.printStudentInfo(temp);
        }

        // 점수를 바꾸고 싶은 수강생 번호 입력 받고, 해당 수강생 객체 불러오기
        System.out.println("점수를 바꾸고 싶은 수강생의 고유 번호를 입력하세요 : ");
        int targetStudent = Integer.parseInt(sc.next());
        Student student = StudentRepository.findStudentById(targetStudent);

        if (student == null) {
            System.out.println("해당 학생을 찾을 수 없습니다.");
            return;
        }

        while (true) {
            // 해당 수강생의 과목들 출력
            System.out.println("=======================================");
            System.out.println(" * 수강중인 과목 리스트 * ");

            Set<Subject> subjectList = student.getStudentMap().keySet();
            for (Subject subject : subjectList) {
                System.out.print(subject.getSubjectName() + "  ");
            }
            System.out.println();
            System.out.println("=======================================");

            System.out.println("바꾸고 싶은 과목을 입력하세요 (exit 종료) : ");
            String inputSubjectName = sc.next();
            if (inputSubjectName.equals("exit")) {
                break;
            }

            Subject subject = SubjectRepository.getSubjectName(inputSubjectName);
            if (subject == null) {
                System.out.println("잘못된 과목명입니다. 다시 입력하세요.");
                continue;
            }

            ArrayList<Integer> targetList = student.getStudentMap().get(subject);
            if (targetList == null || targetList.isEmpty()) {
                System.out.println("해당 과목의 점수 리스트가 비어있습니다.");
                continue;
            }

            while (true) {
                sc.nextLine();
                // 회차 번호 출력
                System.out.println("현재 점수 리스트:");
                int i = 1;
                for (Integer score : targetList) {
                    System.out.println(i++ + "회차 점수:" + score + "  ");
                }
                System.out.println();

                System.out.println("바꾸고 싶은 회차와 점수를 입력하세요 (공백 구분하여) : ");
                String[] scoreArr = sc.nextLine().split(" ");

                if (scoreArr.length != 2) {
                    System.out.println("잘못된 입력 형식입니다. 회차와 점수를 정확히 입력하세요.");
                    continue;
                }

                int index; // 회차 정보
                int newScore; // 변경할 점수

                try {
                    index = Integer.parseInt(scoreArr[0]) - 1;
                    newScore = Integer.parseInt(scoreArr[1]);
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 정확히 입력하세요.");
                    continue;
                }

                // 인덱스 범위와 점수 범위 체크
                if (index < 0 || index >= targetList.size()) {
                    System.out.println("잘못된 회차 번호입니다. 다시 입력하세요.");
                    continue;
                }

                if (newScore < 0 || newScore > 100) {
                    System.out.println("점수는 0에서 100 사이여야 합니다. 다시 입력하세요.");
                    continue;
                }

                // 유효한 경우 점수 변경
                targetList.set(index, newScore);
                System.out.println("점수가 성공적으로 변경되었습니다.");
                System.out.println("=================================");

                // (test) 저장 되어 있는지 출력
                System.out.println("변경된 점수 리스트:");
                for (Integer temp : targetList) {
                    System.out.print(temp + " ");
                }
                System.out.println();

                System.out.println("더이상 변경을 원하는 회차가 없다면 exit 입력 : ");
                String isExit = sc.next();

                if (isExit.equals("exit")) {
                    break;
                }
            }
        }
    }
}
