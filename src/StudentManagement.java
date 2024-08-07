import java.util.*;

public class StudentManagement {
    private static int id = 1;
    private static String name;
    private static String status;

    public static void addStudent() {
        Map<Subject, ArrayList<Integer>> studentMap = new HashMap<>();
        int essentialCount = 0; // 필수과목 카운트
        int selectCount = 0; // 선택과목 카운트
        boolean re = true;
        List<Subject> SubjectStore = SubjectRepository.getSubjectStore();

        Scanner scan = new Scanner(System.in);
        System.out.print("수강생 이름 : ");
        String name = scan.nextLine();

        System.out.print("수강 과목 : ");
        while (re) {
            String subjectName = scan.nextLine(); // 수강할 과목을 입력
            Subject subject = null;

            try {
                subject = SubjectRepository.getSubjectName(subjectName); // 입력한 과목과 저장된 과목이 같은지 판별
                if (subject == null) {
                    throw new IllegalArgumentException("존재하지 않는 과목입니다. 올바른 과목명을 입력해주세요. : ");
                }

                Boolean type = subject.getIsEssential(); // 입력한 과목이 필수인지 선택인지 판별

                if (type) {
                    essentialCount++;
                } else if (!type) {
                    selectCount++;
                }

                if (!studentMap.containsKey(subject)) {
                    studentMap.put(subject, new ArrayList<Integer>()); // 과목저장
                } else {
                    System.out.println("이미 입력된 강의입니다. 다른 과목을 입력해주세요. : ");
                }

                if (essentialCount < 3) {
                    System.out.print("필수과목은 3개 이상 필강입니다. 필수과목을 더 입력해주세요. : ");
                } else if (selectCount < 2) {
                    System.out.print("선택과목은 2개 이상 필강입니다. 선택과목을 더 입력해주세요. : ");
                } else if (essentialCount >= 3 && selectCount >= 2) { // 필수과목이 3개, 선택과목이 2개 이상일 때만 exit문구 출력
                    System.out.println("과목 등록을 마치시겠습니까? (exit 입력 시 종료)");
                    String exit = scan.next();
                    if (exit.equals("exit")) { // exit을 입력 받으면 반복 종료
                        re = false;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } // 무한반복 종료
        System.out.print("수강생 상태 : Green / Red / Yellow 중 하나를 입력해주세요.");
        String status = scan.next();

        StudentRepository.students.add(new Student(id++, name, studentMap, status));  //수강생 객체 생성 및 수강생 리스트에 추가
    }

    public static int getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getStatus() {
        return status;
    }
}
