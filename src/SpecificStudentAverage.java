import java.util.*;

public class SpecificStudentAverage {
    public static ArrayList<Student> statusStudent = new ArrayList<Student>();

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
}
//    public static void averageCalculate() {
//        List<Subject> subjectList = SubjectRepository.getSubjectStore(); // 모든 과목 리스트
//
//        int sum = 0;
//        boolean flag = true;
//        double average = 0;
//        String status = "";
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("조회할 학생들의 상태를 선택해주세요\n1. Green(Good)\n2. Yellow(Not bad)\n3. Red(Terrible)");
//            int choice = sc.nextInt();
//            switch (choice) {
//                case 1 -> {
//                    status = "Green";
//                    pickStatusUp(status);
//                }
//                case 2 -> {
//                    status = "Yellow";
//                    pickStatusUp(status);
//                }
//                case 3 -> {
//                    status = "Red";
//                    pickStatusUp(status);
//                }
//                default -> System.out.println("잘못 입력하셨습니다.");
//            }
//            if (choice == 1 || choice == 2 || choice == 3) {
//                break;
//            }
//        } // 상태 필터링
//
//        for (Subject sub : subjectList) { // 모든 과목들 하나하나 꺼내는데,
//            if (sub.getIsEssential() == true) { // 만약 필수 과목이라면
//
//            }
//        }
//
//
//    public static void pickStatusUp(String status) {
//        for (Student stu : StudentRepository.students) { // 학생들 리스트에서
//            if (stu.getStatus().equalsIgnoreCase(status)) { // 학생의 상태를 갖고온게 파라미터 status와 같다면,
//                statusStudent.add(stu); // 그 학생을 리스트에 넣는다
//            }
//        }
//    }
//
//    // subjectScore10Round = student.getStudentMap
//    public static int sumRoundScore(String subjectName) { // 과목이름의 학생들 1~10회차 점수 총합
//        int sum = 0, totalSum = 0;
//        for (Student stu : statusStudent) {
//            // 학생 한 명의 subjectName 과목 1~10회차 점수
//            ArrayList<Integer> subjectScore10Round = stu.getStudentMap().get(SubjectRepository.getSubjectName(subjectName));
//            if (subjectScore10Round != null) {
//                for (Integer roundScore : subjectScore10Round) {
//                    sum += roundScore; // 1~10회차 점수 합산
//                    totalSum += sum;
//                }
//            }
//        }
//        return totalSum;
//    }
//}