import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Score {

    /*
        0. 어떤 수강생 선택할 건지 입력 받고
        1. 수강생 객체에서 Map 불러오고
        2. Map에서 list 가 null 값인 경우 입력 받기
     */

    public static Map<Subject, ArrayList<Integer>> targetStudentMap = new HashMap<Subject, ArrayList<Integer>>();
    public static ArrayList<Student> studentList = new ArrayList<>(); // 학생레포지토리

    public static void studentTestSet() {
        Subject tempSubject = SubjectRepository.getSubjectName("java");
        Subject tempSubject2 = SubjectRepository.getSubjectName("spring");

        targetStudentMap.put(tempSubject, new ArrayList<Integer>()); // 학생 맵
        targetStudentMap.put(tempSubject2, new ArrayList<Integer>());
    }

    public static void scoreResister() throws IOException {

        studentTestSet(); // 테스트 케이스 생성

        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 등록할 학생을 선택하세요."); // 1번 학생 선택
//        int studentNum = sc.nextInt();
//        Student target = findStudent(studentNum);

//        Map<Subject, ArrayList<Integer>> targetStudentMap = target.getStudentMap();

        while (true) {
            // 우선 점수리스트의 크기가 0인 것 찾고 -> nullList 에 해당 과목 명 넣기
            ArrayList<String> nullList = findNullList(targetStudentMap.keySet());

            System.out.println("점수를 등록할 수 있는 과목은 아래와 같습니다.\n선택 하세요 (exit 종료)");

            // 입력 가능 과목 출력
            System.out.println("========");
            for (String str : nullList) {
                System.out.println("  " + str);
            }
            System.out.println("=========");

            // 해당 과목명 입력 받기
            String inputSubjectName = sc.next();

            // exit 입력시 종료
            if (inputSubjectName.equals("exit")) {
                break;
            }

            // 과목명 입력 받으면 해당 과목 list 가져와서 add
            // 단, 1 ~ 10개 까지만 입력 가능
            System.out.println(inputSubjectName + " 과목에 대한 점수 입력 (10회차 까지) : ");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 입력받은 과목에 대한 과목 객체 불러오기
            Subject inputSubject = SubjectRepository.getSubjectName(inputSubjectName);
            // 과목 객체에 대한 점수 리스트
            ArrayList<Integer> targetSubjectList = targetStudentMap.get(inputSubject);

            while (st.hasMoreTokens()) {
                if (st.countTokens() <= 10) {
                    targetSubjectList.add(Integer.valueOf(st.nextToken()));
                } else {
                    System.out.println("10회차 까지만 입력 가능합니다.");
                    break;
                }
            }
            // (test) 저장 되어 있는지 출력
            for (Integer temp : targetSubjectList) {
                System.out.print(temp + " ");
            }
            System.out.println();
        }


    }

    // 비어 있는 리스트 찾기 (점수 저장 되어 있지 않은 리스트)
    private static ArrayList<String> findNullList(Set list) {
        ArrayList<String> nullList = new ArrayList<>();
        for (Subject subject : targetStudentMap.keySet()) {
            if (targetStudentMap.get(subject).isEmpty()) { // 리스트가 비었다면 nullList 에 추가해 놓기!
                nullList.add(subject.getSubjectName());
            }
        }
        return nullList;
    }

    public static Student findStudent(int studentNum) {
        for (Student s : studentList) { // 입력값과 같은 id 가 있다면 Student 객체 반환
            if (s.getId() == studentNum) {
                return s;
            }
        }
        return null;
    }
}
