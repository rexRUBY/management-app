import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        // 첫 화면 메뉴 선택
        displayMainView();

        // Subject 저장소 생성
        List<Subject> subjectStore = SubjectRepository.getSubjectStore();
    }

    // 첫 화면 메인 뷰
    private static void displayMainView() throws IOException{
        boolean flag = true;
        while(flag) { // 1. 수강생 관리    2. 점수 관리   3. exit 입력 시 종료
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요 : ");
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
        boolean flag = true;
        while(flag) { // 1. 수강생 관리    2. 점수 관리   3. exit 입력 시 종료
            System.out.println("\n==================================");
            System.out.println("수강생 관리 실행 중");
            System.out.println("1. 수강생 정보 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요 : ");
            int menuInput = sc.nextInt();

            switch (menuInput) {
                case 1 -> System.out.println("수강생 정보 등록 구현");
                case 2 -> System.out.println("수강생 목록 조회 구현");
                case 3 -> flag = false;
                default -> {
                    System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
                }
            }
        }
    }

    // 점수 관리 뷰
    private static void displayScoreView() throws IOException {
        boolean flag = true;
        while(flag) {
            System.out.println("\n==================================");
            System.out.println("점수 관리 실행 중");
            System.out.println("1. 수강생 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생 과목별 회차 점수 수정");
            System.out.println("3. 수강생 특정 과목 회차별 등급 조회");
            System.out.println("4. 전체 수강생 과목별 등급 조회");
            System.out.println("5. 특정 상태 수강생들의 과목 평균 등급 조회");
            System.out.println("6. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요 : ");
            int menuInput = sc.nextInt();

            switch (menuInput) {
                case 1 -> Score.scoreReister();
                case 2 -> System.out.println("과목별 회차 점수 수정 구현");
                case 3 -> System.out.println("특정 과목 회차별 등급 조회 구현");
                case 4 -> System.out.println("전체 수강생 과목별 등급 조회 구현");
                case 5 -> System.out.println("특정 상태 수강생 필수 과목 평균 등급 조회 구현");
                case 6 -> flag = false;
                default -> System.out.println("잘못된 입력입니다! \n처음으로 돌아갑니다.");
            }
        }
    }
}