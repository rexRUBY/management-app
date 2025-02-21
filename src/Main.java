import java.io.IOException;
import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        DisplayMainView.displayIntroView();

        boolean flag = true;
        while(flag) {
            System.out.println("\n=========== Main 화면 ===========");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중");
            System.out.print("1. 종료\n2. 수강생 관리\n3. 점수 관리\n메뉴를 선택해주세요 : ");
            String option = new Scanner(System.in).nextLine();
            switch(option) {
                case "1" -> flag = false;
                case "2" -> DisplayStudentView.displayStudentView();
                case "3" -> DisplayScoreView.displayScoreView();
                default -> System.out.println("올바른 메뉴를 입력해주세요");
            }
        }
    }
}