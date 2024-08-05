public class SpecificStudentAverage {
    public static void averageCalculate() {
        int sum = 0;
        int average = 0;

        for (int i : ScoreRegist.yj) {
            sum += i;
        }
        average = sum / ScoreRegist.yj.size();
        System.out.println("평균 : " +average);
    }
}
