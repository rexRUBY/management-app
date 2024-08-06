import java.util.List;
import java.util.Scanner;

public class DisplayStudentView {
    private static Scanner sc = new Scanner(System.in);

    static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n====== 수강생 관리 ======");
            System.out.println("1. 수강생 정보 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 이전으로 돌아가기");
            System.out.println("관리 항복을 선택하세요 : ");
            int menuInput = sc.nextInt();

            switch (menuInput) {
                case 1 -> System.out.println("수강생 정보등록");
                case 2 -> System.out.println("수강생 목록조회");
                case 3 -> flag = false;
                default -> {
                    System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
                }
            }
        }
    }
}