import java.util.*;

public class StudentRepository {
    public static List<Student> students = new ArrayList<>();  //Student 클래스에서 입력 받음.
    public static Scanner sc = new Scanner(System.in);

    public static void inquiry(int type) {
        boolean found = false;
        if(type==1) {  // 고유 번호가 일치하면 출력
            System.out.println("조회할 학생의 고유 번호를 입력하세요 : ");
            int studentId = sc.nextInt();
            for(Student s : students) {
                if(s.getId() == studentId) {
                    System.out.println("고유 번호 : "+s.getId()+" 이름 : "+s.getName()+" 상태 : "+s.getStatus());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("검색 결과가 없습니다.");
            }
        }
        else if(type==2) { // 이름
            System.out.println("조회할 학생의 이름을 입력하세요 : ");
            sc.nextLine(); // 버퍼 비우기
            String studentName = sc.nextLine();
            for(Student s : students) {
                if(s.getName().equals(studentName)) {
                    System.out.println("고유 번호 : "+s.getId()+" 이름 : "+s.getName()+" 상태 : "+s.getStatus());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("검색 결과가 없습니다.");
            }
        }
        else if(type==3) {  // 상태별
            System.out.println("조회할 학생의 상태를 입력하세요 : ");
            sc.nextLine(); // 버퍼 비우기
            String studentStatus = sc.nextLine();
            for(Student s : students) {
                if(s.getStatus().equals(studentStatus)) {
                    System.out.println("고유 번호 : "+s.getId()+" 이름 : "+s.getName()+" 상태 : "+s.getStatus());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("검색 결과가 없습니다.");
            }
        }
    }

    public static void remove(Student student){

        System.out.println("정상적으로 삭제되었습니다.");
    }
}
