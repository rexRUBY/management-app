import java.util.ArrayList;

public class Subject {
    private int subjectId;
    private String subjectName;
    private Boolean subjectType;

    public Subject(int subjectId, String subjectName, Boolean subjectType) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Boolean getIsEssential() {
        return subjectType;
    }
}










