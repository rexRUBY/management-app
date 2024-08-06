import java.util.*;

public class ScoreRegist {
    public static ArrayList<Integer> yj = new ArrayList<Integer>(List.of(50, 90, 70, 20, 40));

    public static void scoreRegist() {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요");
        int score = sc.nextInt();

        yj.add(score);

        for (int i : yj)
         System.out.println("점수 : " +i);
    }
}
