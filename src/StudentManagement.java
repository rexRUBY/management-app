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
                    studentMap.put(subject, new ArrayList<Integer>()); // 과목저장
                    if (type) {
                        essentialCount++;
                        System.out.println("현재 등록된 필수과목은" + essentialCount + "개입니다.");
                    } else if (!type) {
                        selectCount++;
                        System.out.println("현재 등록된 선택과목은" + selectCount + "개입니다.");
                    }
                } else {
                    System.out.println("이미 입력된 강의입니다. 다른 과목을 입력해주세요.");
                }

                if(type && essentialCount < 3){
                    System.out.print("현재 입력된 과목은 필수과목입니다. 필수과목은 최소 3개 ~ 최대 5개까지 입력가능합니다.");
                }

                if(!type && selectCount < 2){
                    System.out.print("현재 입력된 과목은 선택과목입니다. 선택과목은 최소 2개에서 최대 4개까지 입력가능합니다.");
                }

                if(essentialCount >= 3 && selectCount >= 2) {
                    if (essentialCount == 5 && selectCount == 4) {
                        System.out.print("필수 & 선택 과목의 최대 개수를 모두 선택하셨습니다. 과목 선택을 종료합니다.");
                        re = false;
                    } else {
                        System.out.print("과목 선택이 모두 충족되었습니다. 추가로 수강하고자 하면 입력해주세요. (exit 입력 시 종료) : ");
                        String exit = scan.next();
                        if (exit.equals("exit")) { // exit을 입력 받으면 반복 종료
                            re = false;
                        }
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } // 무한반복 종료
        System.out.print("수강생 상태 : Green / Red / Yellow 중 하나를 입력해주세요.");
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
