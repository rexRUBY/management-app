import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // 첫 화면 메뉴 선택
        displayMainView();

        // Subject 저장소 생성
        List<Subject> subjectStore = SubjectRepository.getSubjectStore();

        // (test) Subject 저장소 확인
        for (Subject s : subjectStore) {
            System.out.println(s.getSubjectId() + " " + s.getSubjectName() + " " + s.getIsEssential());
        }
    }

    // 첫 화면 메인 뷰
    private static void displayMainView(){
        boolean flag = true;
        while(flag) { // 1. 수강생 관리    2. 점수 관리   3. exit 입력 시 종료
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            int menuInput = sc.nextInt();

            switch (menuInput) {
                case 1 -> displayStudentView();
                case 2 -> displayScoreView();
                case 3 -> flag = false;
                default -> {
                    System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
                }
            }
        }
    }

    // 수강생 관리 뷰
    private static void displayStudentView() {
        System.out.println("Main.displayStudentView");
        /*
            정보등록 / 목록 조회 ...
         */
    }

    // 점수 관리 뷰
    private static void displayScoreView() {
        System.out.println("Main.displayScoreView");
        /*
            점수 등록 / 점수 계산 ...
         */
    }
}