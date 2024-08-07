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
            System.out.print("1.수강생 관리\n2.점수 관리\n3.종료\n메뉴를 선택해주세요 : ");
            String option = new Scanner(System.in).nextLine();
            switch(option) {
                case "1" -> DisplayStudentView.displayStudentView();
                case "2" -> DisplayScoreView.displayScoreView();
                case "3" -> flag = false;
                default -> System.out.println("올바른 값을 입력해주세요");
            }
        }
    }
}