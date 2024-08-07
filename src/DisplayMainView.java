import java.util.List;
import java.util.Scanner;

public class DisplayMainView {

    private static Scanner sc = new Scanner(System.in);

    static void displayIntroView() {
        System.out.println("                             ___   ___                                          \n" +
                "                           /'___\\ /\\_ \\                                         \n" +
                "  ____   __  __    ___    /\\ \\__/ \\//\\ \\      ___    __  __  __     __    _ __  \n" +
                " /',__\\ /\\ \\/\\ \\ /' _ `\\  \\ \\ ,__\\  \\ \\ \\    / __`\\ /\\ \\/\\ \\/\\ \\  /'__`\\ /\\`'__\\\n" +
                "/\\__, `\\\\ \\ \\_\\ \\/\\ \\/\\ \\  \\ \\ \\_/   \\_\\ \\_ /\\ \\L\\ \\\\ \\ \\_/ \\_/ \\/\\  __/ \\ \\ \\/ \n" +
                "\\/\\____/ \\ \\____/\\ \\_\\ \\_\\  \\ \\_\\    /\\____\\\\ \\____/ \\ \\___x___/'\\ \\____\\ \\ \\_\\ \n" +
                " \\/___/   \\/___/  \\/_/\\/_/   \\/_/    \\/____/ \\/___/   \\/__//__/   \\/____/  \\/_/ \n" +
                "                                                                                \n" +
                "                                                                                \n");
    }

    static void displayMainView() {
        boolean flag = true;
        while (flag) { // 1. 수강생 관리    2. 점수 관리   3. exit 입력 시 종료
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요 : ");
            int menuInput = sc.nextInt();

            switch (menuInput) {
                case 1 -> DisplayStudentView.displayStudentView();
                case 2 -> DisplayScoreView.displayScoreView();
                case 3 -> flag = false;
                default -> {
                    System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
                }
            }
        }
    }
}