import java.util.List;
import java.util.Scanner;

public class DisplayScoreView {
    private static Scanner sc = new Scanner(System.in);

    static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n====== 점수 관리 ======");
            System.out.println("1. 점수 등록");
            System.out.println("2. 점수 수정");
            System.out.println("3. 점수 조회");
            System.out.println("4. 이전으로 돌아가기");
            System.out.print("관리 항목을 선택하세요 : ");
            int menuInput = sc.nextInt();

            switch (menuInput) {
                case 1 -> Score.scoreResister(); // 점수 등록
                case 2 -> ScoreChange.scoreChange();
                case 3 -> SpecificStudentAverage.gradeRegisterView();
                case 4 -> flag = false;
                default -> {
                    System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
                }
            }
        }
    }
}