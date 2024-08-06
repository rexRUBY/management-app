import java.util.*;

public class Student {
    private int id;
    private String name;
    private Map<Subject, ArrayList<Integer>> studentMap = new HashMap<Subject, ArrayList<Integer>>();
    private String status;

    public Student(int id) {
        this.id = id;
    }

    public void addStudent() {
        int essentialCount = 0;// 필수과목 카운트
        int selectCount = 0;// 선택과목 카운드
        boolean re = true;
        List<Subject> SubjectStore = SubjectRepository.getSubjectStore();
        Scanner scan = new Scanner(System.in);
        System.out.print("학생이름 : ");
        String name = scan.next();
        System.out.print("수강할 과목 : ");
        while (re) {
            String subjectName = scan.next(); //수강할 과목을 입력
            Subject subject = SubjectRepository.getSubjectName(subjectName);//입력한 과목과 저장된 과목이 같은지 판별
            Boolean type = subject.getIsEssential();//입력한 과목이 필수인지 선택인지 판별

            if (type) {
                essentialCount++;
            } else if (!type) {
                selectCount++;
            }

            if (!studentMap.containsKey(subjectName)) {
                studentMap.put(subject, new ArrayList<Integer>());//과목저장
            }
            else {
                System.out.print("이미 입력된 강의입니다. 다른 과목을 입력해주세요.");
            }

            if (essentialCount < 3) {
                System.out.print("필수과목은 3개 이상 필강입니다. 필수과목을 더 입력해주세요.");
            }
            else if (selectCount < 2) {
                System.out.print("선택과목은 2개 이상 필강입니다. 필수과목을 더 입력해주세요.");
            }
            else if (essentialCount >= 3 && selectCount >= 2) { //필수과목이 3개, 선택과목이 2개 이상일때만 exit문구 출력
                System.out.println("과목 등록을 마치시겠습니까? (exit 입력 시 종료)");
                String exit = scan.next();
                if (exit.equals("exit")) {/* exit을 입력 받으면 반복 종료 */
                    re = false;
                }
            }
        }//무한반복 종료
        System.out.print("학생의 현재 상태 : Green / Red / Yellow 중 하나를 입력해주세요.");
        String status = scan.next();
    }

    public void setId() {

    }

    public int getId() {
        return this.id;
    }

    public void setName() {

    }

    public String getName() {
        return this.name;
    }

    public void setSubject() {

    }

    public List<Subject> getSubject() {
        return List.of();
    }

    public void setStatus() {

    }

    public String getStatus() {
        return this.status;
    }

    public Map<Subject, ArrayList<Integer>> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<Subject, ArrayList<Integer>> studentMap) {
        this.studentMap = studentMap;
    }

}