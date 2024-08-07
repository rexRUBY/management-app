import java.util.*;

public class SpecificStudentAverage {
    public static ArrayList<Student> statusStudent = new ArrayList<Student>();

    public static void averageCalculate() {
        List<Subject> subjectList = SubjectRepository.getSubjectStore(); // 모든 과목 리스트

        double average = 0;
        String status = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("조회할 학생들의 상태를 선택해주세요\n1. Green(Good)\n2. Yellow(Not bad)\n3. Red(Terrible)");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    status = "Green";
                    pickStatusUp(status);
                }
                case 2 -> {
                    status = "Yellow";
                    pickStatusUp(status);
                }
                case 3 -> {
                    status = "Red";
                    pickStatusUp(status);
                }
                default -> System.out.println("잘못 입력하셨습니다.");
            }
            if (choice == 1 || choice == 2 || choice == 3) {
                break;
            }
        } // 상태 필터링

        /*
        특정 상태 학생들 리스트 : SpecificStudentAverage.statusStudent
        특정 상태 학생들 총인원 : SpecificStudentAverage.statusStudent.size()
        과목 전체 리스트 : SubjectRepository.getSubjectStore()
        필수 과목 리스트 : SubjectStore.Subject.getIsEssential() == true
        */

        for (Student stu : statusStudent) {
            Set<Subject> set = stu.getStudentMap().keySet(); // 과목 / 리스트
            int sum = 0;
            int roundCount = 0;
            for (Subject ssub : set) { // ssub는 과목 하나
                if (ssub.getIsEssential() == true) {
                    ArrayList<Integer> list = stu.getStudentMap().get(ssub); // 1~n회차까지 리스트
                    sum += sumRoundScore(list); // 1~n회차 리스트 총 합
                    roundCount += list.size(); // 회차의 총 합
                }
            }
            average = (double) sum / roundCount;
            String grade = GradeManagement.essentialGrade((int)average);
            System.out.println("%s\n=============");
            System.out.printf("'%s'의 필수과목 평균 등급 : %s", stu.getName(), grade);
            System.out.println("\n=============");
        }
    }

    public static void gradeRegisterView() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\n====== 점수 조회 ======");
            System.out.println("1. 특정 학생 과목별 등급 조회 ");
            System.out.println("2. 특정 학생 회차별 등급 조회 ");
            System.out.println("3. 이전으로 돌아가기");
            System.out.print("관리 항목을 선택하세요 : ");
            int menuInput = sc.nextInt();

            switch (menuInput) {
                case 1 -> new GradeManagement().subjectGradeView();
                case 2 -> new GradeManagement().studentRoundGradeView();
                case 3 -> flag = false;
                default -> {
                    System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
                }
            }
        }
    }

    public static void pickStatusUp(String status) {
        for (Student stu : StudentRepository.students) { // 학생들 리스트에서
            if (stu.getStatus().equalsIgnoreCase(status)) { // 학생의 상태를 갖고온게 파라미터 status와 같다면,
                statusStudent.add(stu); // 그 학생을 리스트에 넣는다
            }
        }
    }

    // subjectScore10Round = student.getStudentMap
    public static int sumRoundScore(ArrayList<Integer> subject10Round) { // 과목이름의 학생들 1~10회차 점수 총합
        int totalSum = 0;

        for (Integer roundScore : subject10Round) {
            totalSum += roundScore.intValue();
        }
        return totalSum;
    }
}
