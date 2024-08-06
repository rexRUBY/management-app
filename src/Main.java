import java.io.IOException;
import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        DisplayMainView.displayIntroView();

        while(true) {
            System.out.println("1.수강생 관리\n2.점수 관리\n3.종료\n메뉴를 선택해주세요 : ");
            int option = new Scanner(System.in).nextInt();
            switch(option) {
                case 1 -> DisplayMainView.displayMainView();
                case 2 -> DisplayScoreView.displayScoreView();
                default -> System.out.println("올바를 값을 입력해주세요");
            }
        }
    }
}