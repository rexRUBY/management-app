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

        System.out.println("\n====== 수강생 정보 등록 ======");

        Scanner scan = new Scanner(System.in);
        System.out.print("수강생 이름: ");
        String name = scan.nextLine().trim();

        System.out.println("수강 과목 입력");
        System.out.println("- 필수과목: 최소 3개, 최대 5개");
        System.out.println("- 선택과목: 최소 2개, 최대 4개");
        System.out.println();

        while (re) {
            System.out.print("수강할 과목명을 입력하세요 (종료하려면 'exit' 입력): ");
            String subjectName = scan.nextLine().trim();

            if (subjectName.equalsIgnoreCase("exit")) {
                if (essentialCount >= 3 && selectCount >= 2) {
                    break;
                } else {
                    System.out.println("필수과목은 최소 3개, 선택과목은 최소 2개를 입력해야 합니다.");
                    continue;
                }
            }

            Subject subject = null;
            try {
                subject = SubjectRepository.getSubjectName(subjectName);
                if (subject == null) {
                    throw new IllegalArgumentException("존재하지 않는 과목입니다. 올바른 과목명을 입력해주세요.");
                }

                boolean isEssential = subject.getIsEssential();
                if (studentMap.containsKey(subject)) {
                    System.out.println("이미 입력된 과목입니다. 다른 과목을 입력해주세요.");
                    continue;
                }

                if (isEssential) {
                    if (essentialCount < 5) {
                        studentMap.put(subject, new ArrayList<Integer>());
                        essentialCount++;
                        System.out.println("[필수과목]을 추가했습니다. 현재 필수과목 개수: " + essentialCount+"\n");
                    } else {
                        System.out.println("필수과목의 최대 개수(5개)를 초과했습니다.");
                    }
                } else {
                    if (selectCount < 4) {
                        studentMap.put(subject, new ArrayList<Integer>());
                        selectCount++;
                        System.out.println("[선택과목]을 추가했습니다. 현재 선택과목 개수: " + selectCount +"\n");
                    } else {
                        System.out.println("선택과목의 최대 개수(4개)를 초과했습니다.");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            if (essentialCount >= 3 && selectCount >= 2) {
                System.out.println("필수과목과 선택과목의 최소 개수를 충족했습니다.");
                System.out.print("계속 과목을 입력하시겠습니까? (yes/no): ");
                String continueInput = scan.nextLine().trim();
                if (continueInput.equalsIgnoreCase("no")) {
                    break;
                }
            }
        }

        System.out.print("수강생 상태(Green / Yellow / Red 중 하나를 입력): ");
        while (true) {
            status = scan.nextLine().trim();
            if (status.equalsIgnoreCase("Green") || status.equalsIgnoreCase("Red") || status.equalsIgnoreCase("Yellow")) {
                break;
            } else {
                System.out.print("잘못된 입력입니다. 수강생 상태(Green / Red / Yellow 중 하나를 입력): ");
            }
        }

        System.out.println();
        StudentRepository.students.add(new Student(id++, name, studentMap, status));
        System.out.println("수강생 정보가 성공적으로 등록되었습니다.");
        System.out.println();

        System.out.print("이전으로 돌아가겠습니까? (back 입력 시 초기화면으로 되돌아감): ");
        String back = scan.nextLine().trim();
        if (back.equalsIgnoreCase("back")) {
            return;
        }
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
