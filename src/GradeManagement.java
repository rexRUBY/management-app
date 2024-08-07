import javax.xml.stream.events.StartDocument;
import java.util.*;

public class GradeManagement {

    private static List<Student> studentList = StudentRepository.getStudents();
    Scanner sc = new Scanner(System.in);

    public void subjectGradeView() {
        boolean flag = true;
        while(flag) {
            System.out.println("======= 특정 학생 과목별 등급 조회 ======= ");

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

            calculateSubjectGrade(targetStudent);

            System.out.println("뒤로가기 (exit)");
            String isExit = sc.next();

            if (isExit.equals("exit")) {
                flag = false;
            }
        }
    }

    public void studentRoundGradeView() {
        boolean flag = true;
        while(flag) {
            System.out.println("======= 특정 학생 회차별 등급 조회 ======= ");

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

            // 과목 선택
            List<String> checkNameList = new ArrayList<>(); // 존재하는 과목 체크 위한 리스트
            System.out.println("======== 과목을 선택하세요 ========");
            for (Subject subject : targetStudent.getStudentMap().keySet()) {
                String temp = subject.getSubjectName();
                System.out.println(temp);
                checkNameList.add(temp);
            }
            System.out.println("===============================");
            String targetSubject = sc.next();

            // 잘못입력 예외 처리
            if (!checkNameList.contains(targetSubject)) {
                System.out.println("없는 과목을 입력하였습니다.");
                break;
            }

            while (true) {
                calculateRoundGrade(targetStudent, targetSubject);
                System.out.println("다른 회차를 조회하시겠습니까? (yes or exit)");
                String input = sc.next();
                if (input.equals("exit")) {
                    break;
                }
            }

//            System.out.println("뒤로가기 (exit)");
//            String isExit = sc.next();
//
//            if (isExit.equals("exit")) {
//                flag = false;
//            }
        }
    }

    public void calculateSubjectGrade(Student student) {
        Map<Subject, ArrayList<Integer>> targetMap = student.getStudentMap();
        Set<Subject> set = targetMap.keySet();

        // 과목을 순차적으로 돌기
        for (Subject subject : set) {
            ArrayList<Integer> targetList = targetMap.get(subject);

            int roundNum = targetList.size();

            if (roundNum == 0) {
                continue;
            }

            int sum = 0;

            for (Integer score : targetList) {
                sum += score;
            }

            int result = sum / roundNum;  // roundNum이 0이 아님이 보장됨
            String grade = "";

            if (subject.getIsEssential()) {
                grade = essentialGrade(result);
            } else {
                grade = optianalGrade(result);
            }

            System.out.println(subject.getSubjectName() + " 평균 등급 : " + grade);
        }
    }

    public void calculateRoundGrade(Student student, String targetSubject) {
        Map<Subject, ArrayList<Integer>> targetMap = student.getStudentMap();
        Set<Subject> set = targetMap.keySet();


        // 과목을 순차적으로 돌면서
        for (Subject subject : set) {
            boolean isEssential = subject.getIsEssential(); // 필수인지 선택인지 저장
            if (subject.getSubjectName().equals(targetSubject)) {
                int i = 1; // 회차 인덱스// 특정 과목의 점수 순환
                for (Integer score : targetMap.get(subject)) {

                    if (isEssential) {
                        System.out.println(i++ + "회차 등급 : " + essentialGrade(score));
                    } else {
                        System.out.println(i++ + "회차 등급 : " + optianalGrade(score));
                    }
                }
            }
        }
    }



    // 필수 과목 등급 산출 메서드!
    public static String essentialGrade(int score) {
        if (score >= 95) {
            return "A";
        } else if (score >= 90) {
            return "B";
        } else if (score >= 80) {
            return "C";
        } else if (score >= 70) {
            return "D";
        } else if (score >= 60) {
            return "F";
        } else {
            return "N";
        }
    }

    // 선택 과목 등급 산출 메서드!
    public static String optianalGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else if (score >= 50) {
            return "F";
        } else {
            return "N";
        }
    }
}
