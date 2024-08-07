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
                if (!studentMap.containsKey(subject)) {
                    if (type && essentialCount < 5) {
                        studentMap.put(subject, new ArrayList<Integer>());
                        essentialCount++;
                        System.out.print("필수과목을 추가했습니다. 현재 필수과목 개수: " + essentialCount);
                    } else if (!type && selectCount < 4) {
                        studentMap.put(subject, new ArrayList<Integer>());
                        selectCount++;
                        System.out.print("선택과목을 추가했습니다. 현재 선택과목 개수: " + selectCount);
                    } else {
                        System.out.println("해당 과목 유형의 최대 선택 가능 개수를 초과했습니다.");
                    }
                } else {
                    System.out.println("이미 입력된 강의입니다. 다른 과목을 입력해주세요.");
                }

                // 필수과목 조건 확인
                if (type && essentialCount < 3) {
                    System.out.println();
                    System.out.print("필수과목은 최소 3개에서 최대 5개까지 입력가능합니다. 현재 등록된 필수과목은 " + essentialCount + "개입니다. 계속 입력 : ");
                }

                // 선택과목 조건 확인
                if (!type && selectCount < 2) {
                    System.out.println();
                    System.out.print("선택과목은 최소 2개에서 최대 4개까지 입력가능합니다. 현재 등록된 선택과목은 " + selectCount + "개입니다. 계속 입력 : ");
                }

                // 등록 완료 조건 확인
                if (essentialCount >= 3 && selectCount >= 2) {
                    if (essentialCount == 5 && selectCount == 4) {
                        System.out.println("필수 과목과 선택 과목의 최대 개수를 모두 선택했습니다. 과목 등록을 종료합니다.");
                        re = false;
                    } else {
                        System.out.print("과목 선택은 충족 되었습니다. 수강을 원하시면 입력하세요 (exit 입력 시 종료) : ");
                        String exit = scan.next();
                        if (exit.equals("exit")) {
                            re = false;
                        }
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 무한반복 종료
        System.out.print("수강생 상태 : Green / Red / Yellow 중 하나를 입력해주세요 : ");
        String status = scan.next();

        StudentRepository.students.add(new Student(id++, name, studentMap, status));  //수강생 객체 생성 및 수강생 리스트에 추가

        System.out.println("이전으로 돌아가겠습니까? (back 입력시 초기화면으로 되돌아감) : ");
        String back = scan.next();
        if (back.equals("back")) {
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
