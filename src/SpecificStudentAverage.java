import java.util.*;

public class SpecificStudentAverage {
    public static ArrayList<Student> statusStudent = new ArrayList<Student>();

    public static void averageCalculate() {
        String[] subjectArr = {"java", "객체지향", "spring", "JPA", "MySQL", "디자인 패턴", "Spring Security", "Redis", "MongoDB"};
        int sum = 0;
        boolean flag = true;
        double average = 0;
        String status = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("조회할 학생들의 상태를 선택해주세요\n1.Green(Good)\n2.Yellow(Not bad)\n3.Red(Terrible)");
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

        while (flag) {
            System.out.println("조회할 과목의 이름을 써주세요");
            String subject = sc.next();
            for (String s : subjectArr) {
                if (subject.equals(s)) {
                    sum = sumRoundScore(subject);
                    flag = false;
                    break;
                } else {
                    System.out.println("잘못 입력하셨습니다.\n");
                }
            }
        } // 과목 필터링

        average = (double) sum / Score.targetStudentMap.size();

        System.out.printf("%s 상태의 학생들 과목 10회차 평균은 %f 입니다.",status,average);
    }

    public static void pickStatusUp(String status) {
        for (Student stu : StudentRepository.students) { // 학생들 리스트에서
            if (stu.getStatus().equalsIgnoreCase(status)) { // 학생의 상태를 갖고온게 파라미터 status와 같다면,
                statusStudent.add(stu); // 그 학생을 리스트에 넣는다
            }
        }
    }

    public static int sumRoundScore(String name) {
        ArrayList<Integer> subjectScore10Round = Score.targetStudentMap.get(SubjectRepository.getSubjectName(name));
        int sum = 0;

        if (SubjectRepository.getSubjectName(name).getSubjectName().equalsIgnoreCase(name)) {
            // 과목의 이름이 파라미터 name과 같다면,
            for (int roundScore : subjectScore10Round) {
                sum += roundScore;
            }
        }
        return sum;
    }
}