mport java.util.List;
import java.util.Scanner;

public class DisplayStudentView {
    private static Scanner sc = new Scanner(System.in);

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n====== 수강생 관리 ======");
            System.out.println("1. 수강생 정보 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 이전으로 돌아가기");
            System.out.println("관리 항복을 선택하세요 : ");
            int menuInput = sc.nextInt();

            switch (menuInput) {
                case 1 -> a //수강생 정보등록
                case 2 -> b //수강생 목록조회
                case 3 -> displayMainView();
                default -> {
                    System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
                }

            }
        }
    }

    private static void a() {
        boolean flag = true;
        int menuInput = sc.nextInt();

        switch (menuInput) {
            case 1 -> //고유번호 등록
            case 2 -> //이름 등록
            case 3 -> //과목목록 등록
            case 4 -> //수강생상태 등록
            default -> {
                System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
            }
        }
    }
}

private static void b() {
    boolean flag = true;
    while (flag) {
        System.out.println("\n====== 수강생 목록 조회 ======");
        System.out.println("1. 고유번호를 조회하세요");
        System.out.println("2. 이름을 조회하세요");
        System.out.println("3. 수강생 상태를 조회하세요");
        System.out.println("관리 항복을 선택하세요 : ");
        int menuInput = sc.nextInt();

        switch (menuInput) {
            case 1 -> //고유번호 조회
            case 2 -> //이름 조회
            case 3 -> //수강생상태 조회
            default -> {
                System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
            }

        }
    }
}

}
