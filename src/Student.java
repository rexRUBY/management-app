import java.util.*;

public class Student {
    private int id = 1;
    private String name;
    private Map<Subject,ArrayList<Integer>> studentMap = new HashMap<Subject,ArrayList<Integer>>();
    private String status;

    public Student(int id){
        this.id = id;
    }

    public void addStudent(){
        List<Subject> SubjectStore = SubjectRepository.getSubjectStore();
        Scanner scan = new Scanner(System.in);
        System.out.print("추가할 학생이름 : ");
        String name = scan.next();
        System.out.print("학생이 듣고 있는 과목 목록 : ");
        while(true){
            String subjectName = scan.next();
            Subject subject = SubjectRepository.getSubjectName(subjectName);
            studentMap.put(subject, new ArrayList<Integer>());
            break;
        }
        System.out.print("학생의 현재 상태 : ");
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
}