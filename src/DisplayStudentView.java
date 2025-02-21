import java.util.List;
import java.util.Scanner;

public class DisplayStudentView {
    private static Scanner sc = new Scanner(System.in);

    static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n======== 수강생 관리 ========");
            System.out.println("1. 이전으로 돌아가기");
            System.out.println("2. 수강생 정보 등록");
            System.out.println("3. 수강생 목록 조회");
            System.out.print("메뉴를 선택해주세요 : ");
            int menuInput = sc.nextInt();

            switch (menuInput) {
                case 1 -> flag = false;
                case 2 -> StudentManagement.addStudent(); //수강생 정보 등록
                case 3 -> StudentRepository.selectOption(); //수강생 조회
                default -> {
                    System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
                }
            }
        }
    }
}