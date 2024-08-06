import java.util.*;

public class Student {
    private int id;
    private String name;
    private Map<Subject, ArrayList<Integer>> studentMap = new HashMap<Subject, ArrayList<Integer>>();
    private String status;

    public Student(int id, String name, Map<Subject, ArrayList<Integer>> map, String status) {
        this.id = id;
        this.name = name;
        this.studentMap = map;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Subject> getSubject() {
        return List.of();
    }

    public void setStatus(String status) {
        this.status = status;
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