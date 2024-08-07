import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {

    private static final List<Subject> subjectStore = new ArrayList<>();
    private static int subjectId = 0;

    private static void setSubjectData() {
        subjectStore.add(new Subject(subjectId++,"java", true));
        subjectStore.add(new Subject(subjectId++,"객체지향", true));
        subjectStore.add(new Subject(subjectId++,"spring", true));
        subjectStore.add(new Subject(subjectId++,"jpa", true));
        subjectStore.add(new Subject(subjectId++,"mysql", true));
        subjectStore.add(new Subject(subjectId++,"디자인패턴", false));
        subjectStore.add(new Subject(subjectId++,"springSecurity", false));
        subjectStore.add(new Subject(subjectId++,"redis", false));
        subjectStore.add(new Subject(subjectId++,"mongodb", false));
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
