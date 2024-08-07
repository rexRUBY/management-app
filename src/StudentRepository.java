import java.util.*;

public class StudentRepository {
    public static List<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static List<Student> getStudents() {
        return students;
    }

    public static void selectOption() {
        System.out.println("====== 수강생 목록 조회 ======");
        System.out.println("1. 수강생 이름 검색\n2. 수강생 삭제 및 조회\n00 : 이전으로 돌아가기");
        System.out.print("관리 항목을 선택하세요 : ");
        String option = sc.nextLine();

        switch(option) {
            case "1":
                searchStudent();
                break;
            case "2":
                deleteOrModifyStudent();
                break;
            case "3":
                DisplayStudentView.displayStudentView();
                break;
            default:
                System.out.println("잘못된 옵션입니다.");
        }
    }

    private static void searchStudent() {
        System.out.println("1. 고유 번호로 검색\n2. 이름으로 검색\n3. 상태로 검색");
        String searchType = sc.nextLine();
        String searchValue = getSearchValue(searchType);

        List<Student> result = searchStudents(Integer.parseInt(searchType), searchValue);
        printSearchResults(result);
    }

    private static String getSearchValue(String searchType) {
        String message = getInquiryMessage(Integer.parseInt(searchType));
        System.out.print(message);
        return sc.nextLine();
    }

    private static String getInquiryMessage(int type) {
        switch (type) {
            case 1: return "조회할 학생의 고유 번호를 입력하세요: ";
            case 2: return "조회할 학생의 이름을 입력하세요: ";
            case 3: return "조회할 학생의 상태를 입력하세요: ";
            default: return "잘못된 조회 유형입니다.";
        }
    }

    private static List<Student> searchStudents(int type, String input) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (isMatchingStudent(s, type, input)) {
                result.add(s);
            }
        }
        return result;
    }

    private static void printSearchResults(List<Student> result) {
        if (result.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            for (Student s : result) {
                printStudentInfo(s);
            }
        }
    }

    private static void deleteOrModifyStudent() {
        System.out.println("1. 학생 삭제\n2. 학생 정보 수정");
        String choice = sc.nextLine();

        switch(choice) {
            case "1":
                remove();
                break;
            case "2":
                modifyStudentInfo();
                break;
            default:
                System.out.println("잘못된 선택입니다.");
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

    public static void printStudentInfo(Student s) {
        System.out.println("고유 번호: " + s.getId() + " 이름: " + s.getName() + " 상태: " + s.getStatus());
    }

    public static void remove() {
        System.out.print("삭제할 수강생의 고유 번호를 입력하세요: ");
        int studentId = Integer.parseInt(sc.nextLine());
        Student studentToRemove = null;

        for (Student s : students) {
            if (s.getId() == studentId) {
                studentToRemove = s;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            studentToRemove = null;  // 객체를 null로 설정 가비지컬렉션이 알아서 버림
            System.out.println("정상적으로 삭제되었습니다.");
        } else {
            System.out.println("해당 고유 번호를 가진 학생을 찾을 수 없습니다.");
        }
    }

    public static void modifyStudentInfo() {
        System.out.println("수정할 학생의 ID를 입력해주세요.");
        String id = sc.nextLine();
        for (Student s : students) {
            if (isMatchingStudent(s, 1, id)) {
                System.out.println("학생의 이름을 입력해주세요.");
                s.setName(sc.nextLine());
                System.out.println("학생의 현재 상태 : Green / Red / Yellow 중 하나를 입력해주세요.");
                s.setStatus(sc.nextLine());
                System.out.println("학생 정보가 수정되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID를 가진 학생을 찾을 수 없습니다.");
    }

    public static Student findStudentById(int id) {
        for (Student temp : students) {
            if (temp.getId() == id) {
                return temp;
            }
        }
        return null;
    }

}