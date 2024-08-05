import java.util.ArrayList;

public class Subject {
    private int subjectId;
    private String subjectName;
    private Boolean subjectType;
//    private ArrayList score;

    // score 리스트는 따로 score 클래스에서 map 으로 <Subject, scoreList> 로 관리하는게 어떨지
    // subjectId 값++ 로 하려면 int 형으로 바꿔야 됨.
    // subjectType true/false 헷갈릿 수도 있을 거 같음. 필수/선택 으로 바꾸는건 어떨까
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

//    public int getScore() {
//        return 0;
//    }
}










