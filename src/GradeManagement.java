import javax.xml.stream.events.StartDocument;
import java.util.*;

public class GradeManagement {

    private static List<Student> studentList = StudentRepository.getStudents();
    Scanner sc = new Scanner(System.in);

    public void gradeView() {
        boolean flag = true;
        while(flag) {
            System.out.println("======= 등급 조회 ======= ");

            // 수강생 리스트 출력
            for (Student student : studentList) {
                StudentRepository.printStudentInfo(student);
            }
            System.out.print("등급 조회를 원하는 학생의 고유 번호를 입력하세요 : ");
            int studentNum = -1;

            try {
                studentNum = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 숫자입니다. ");
                sc.nextLine();
                continue;
            }

            // 입력 받은 학생
            Student targetStudent = StudentRepository.findStudentById(studentNum);

            if (targetStudent == null) {
                System.out.println("존재하지 않은 수강생이거나 입력이 잘못되었습니다.");
                continue;
            }

            calculateGrade(targetStudent);

            System.out.println("뒤로가기 (exit)");
            String isExit = sc.next();

            if (isExit.equals("exit")) {
                flag = false;
            }
        }
    }

    public void calculateGrade(Student student) {
        Map<Subject, ArrayList<Integer>> targetMap = student.getStudentMap();
        Set<Subject> set = targetMap.keySet();

        // 과목을 순차적으로 돌기
        for (Subject subject : set) {
            ArrayList<Integer> targetList = targetMap.get(subject);

            int roundNum = targetList.size();
            int sum = 0;

            for (Integer score : targetList) {
                sum += score;
            }

            System.out.println(subject.getSubjectName() + " 의 평균 등급 : " + sum / roundNum);
        }

    }
}
