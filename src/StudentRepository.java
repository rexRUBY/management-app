import java.util.*;

public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void inquiry(int type) {
        System.out.println("1. 고유번호로 검색\n2. 학생 이름으로 검색\n3. 학생 상태로 검색");
        System.out.println(getInquiryMessage(type));
        String input = sc.nextLine();
        boolean found = false;

        for (Student s : students) {
            if (isMatchingStudent(s, type, input)) {
                printStudentInfo(s);
                found = true;
                if (type == 1) break; // 고유 번호는 유일하므로 찾으면 종료
            }
        }

        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    private static String getInquiryMessage(int type) {
        switch (type) {
            case 1: return "조회할 학생의 고유 번호를 입력하세요: ";
            case 2: return "조회할 학생의 이름을 입력하세요: ";
            case 3: return "조회할 학생의 상태를 입력하세요: ";
            default: return "잘못된 조회 유형입니다.";
        }
    }

    private static boolean isMatchingStudent(Student s, int type, String input) {
        switch (type) {
            case 1: return s.getId() == Integer.parseInt(input);
            case 2: return s.getName().equals(input);
            case 3: return s.getStatus().equals(input);
            default: return false;
        }
    }

    private static void printStudentInfo(Student s) {
        System.out.println("고유 번호: " + s.getId() + " 이름: " + s.getName() + " 상태: " + s.getStatus());
    }

    public static void remove() {
        System.out.print("삭제할 수강생의 고유 번호를 입력하세요: ");
        int studentId = Integer.parseInt(sc.nextLine());
        Iterator<Student> iterator = students.iterator();
        boolean found = false;
        Student removedStudent = null;

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId() == studentId) {
                removedStudent = s;
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("정상적으로 삭제되었습니다.");
            removedStudent = null;  // 삭제된 학생 객체를 null로 설정
        } else {
            System.out.println("해당 고유 번호를 가진 학생을 찾을 수 없습니다.");
        }
    }

    public static void getSelectSubject() {
        System.out.print("선택과목을 조회할 학생의 Id를 입력하세요: ");
        String studentId = sc.next();
        Student stu = null;

        for(Student s : students) {
            if (isMatchingStudent(s, 1, studentId)) {
                stu = s;
                break;
            }
        }

        if (stu != null) {
            System.out.print(stu.getName()+ " 학생의 선택 과목 : ");
            for(Subject sub : stu.getStudentMap().keySet()){
                System.out.print(sub + " ");
            }
            System.out.println();
        } else {
            System.out.println("해당 ID를 가진 학생을 찾을 수 없습니다.");
        }
    }
}