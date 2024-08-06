import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {

    private static final List<Subject> subjectStore = new ArrayList<>();
    private static int subjectId = 0;

    private static void setSubjectData() {
        subjectStore.add(new Subject(subjectId++,"java", true));
        subjectStore.add(new Subject(subjectId++,"객체지향", true));
        subjectStore.add(new Subject(subjectId++,"spring", true));
        subjectStore.add(new Subject(subjectId++,"JPA", true));
        subjectStore.add(new Subject(subjectId++,"MySQL", true));
        subjectStore.add(new Subject(subjectId++,"디자인 패턴", false));
        subjectStore.add(new Subject(subjectId++,"Spring Security", false));
        subjectStore.add(new Subject(subjectId++,"Redis", false));
        subjectStore.add(new Subject(subjectId++,"MongoDB", false));
    }

    public static List<Subject> getSubjectStore() {
        setSubjectData();
        return subjectStore;
    }

    public static Subject getSubjectName(String name) {
        for(Subject sub : subjectStore) {
            if(name.equals(sub.getSubjectName())){
                return sub;
            }
        }
        return null;
    }
}
