
import java.util.*;

public class SchoolRecordManager {

    HashMap<String, Student> stuGradeMap = new HashMap<>();
    Person currentUser = null;

    public SchoolRecordManager() {
        this.stuGradeMap.put(new Student("aa", "11", "aa").getId(), new Student("aa", "11", "aa"));
        this.stuGradeMap.put(new Student("bb", "22", "bb").getId(), new Student("bb", "22", "bb"));
        this.stuGradeMap.put(new Student("cc", "33", "cc").getId(), new Student("cc", "33", "cc"));
    }

    public void run() {
        while (this.intro()) {
            this.currentUser = this.adminLogin();
            while (this.currentUser != null) {
                Boolean endFlag = false;
                int select = this.menu();
                switch (select) {
                    case 1:
                        this.inputGrade();
                        break;
                    case 2:
                        this.searchGrade();
                        break;
                    case 3:
                        this.searchGradeAll();
                        break;
                    case 4:
                        endFlag = true;
                        this.currentUser = null;
                        break;
                }
                if (endFlag) {
                    break;
                }
            }
        }
    }

    public boolean intro() {
        while (true) {
            System.out.println("<< 성적처리 >>");
            System.out.println("1. 관리자 로그인");
            System.out.println("2. 종료");
            Scanner s = new Scanner(System.in);
            try {
                int select = s.nextInt();
                s.nextLine();
                if (select == 1) {
                    return true;
                } else if (select == 2) {
                    return false;
                } else {
                    System.out.println("잘못입력하였습니다.");
                }
            } catch (Exception e) {
                System.out.println("숫자를 입력하세요");
                s.next();
            }
        }
    }

    public Admin adminLogin() {
        Scanner s = new Scanner(System.in);
        System.out.print("Name : ");
        String inputName = s.nextLine();
        System.out.print("Phone : ");
        String inputPhone = s.nextLine();
        Admin admin = new Admin(inputName, inputPhone);
        System.out.print("ID : ");
        String inputId = s.nextLine();
        System.out.print("PW : ");
        String inputPw = s.nextLine();
        if (!admin.getId().trim().equals(inputId)) {
            System.out.println("아이디가 잘못되었습니다.");
            return null;
        }
        if (!admin.getPw().trim().equals(inputPw)) {
            System.out.println("비밀번호가 잘못되었습니다.");
            return null;
        }
        System.out.println(admin.getName()+"님 반갑습니다.");
        return admin;
    }

    public int menu() {
        System.out.println("<< 성적처리 >>");
        System.out.println("1. 성적 입력");
        System.out.println("2. 성적 검색");
        System.out.println("3. 전체 성적 출력");
        System.out.println("4. 로그아웃");
        Scanner s = new Scanner(System.in);
        int select = s.nextInt();
        s.nextLine();
        return select;
    }

    public void inputGrade() {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("ID : ");
                String inputId = s.next();
                if (this.stuGradeMap.containsKey(inputId)) {
                    System.out.print("NAME : ");
                    String inputName = s.nextLine();
                    if (this.stuGradeMap.get(inputId).getName().equals(inputName)) {
                        System.out.print("국어 : ");
                        int kor = s.nextInt();
                        s.nextLine();
                        System.out.print("영어 : ");
                        int eng = s.nextInt();
                        s.nextLine();
                        System.out.print("수학 : ");
                        int math = s.nextInt();
                        s.nextLine();
                        if((kor < 0 || kor > 100) || (eng < 0 || eng > 100) || (math < 0 || math > 100) ){
                            System.out.println("점수는 0점 이상 100점 이하로 입력하세요.");
                            continue;
                        }
                        this.stuGradeMap.get(inputId).setGrade(new Grade(kor, eng, math));
                        System.out.println("계속 입력하시겠습니까? Y | N");
                        String again = s.nextLine();
                        if (again.trim().toUpperCase().equals("Y")) {
                            continue;
                        }
                        return;
                    }
                    System.out.println("이름을 찾을 수 없습니다.");
                    return;
                }
                System.out.println("학번을 찾을 수 없습니다.");
                return;
            } catch (Exception e) {
                System.out.println("점수를 올바르게 입력하세요.");
                s.next();
            }
        }

    }

    public void searchGrade() {
        Scanner s = new Scanner(System.in);
        System.out.print("검색할 학생의 학번 : ");
        String inputId = s.nextLine();
        if (this.stuGradeMap.containsKey(inputId)) {
            this.printSearchList(this.stuGradeMap.get(inputId));
        } else {
            System.out.println("학번을 찾을 수 없습니다.");
        }
    }

    public void searchGradeAll() {
        Iterator<Map.Entry<String, Student>> entries = this.stuGradeMap.entrySet().iterator();
        while (entries.hasNext()) {
            Student stu = entries.next().getValue();
            this.printSearchList(stu);
        }
        System.out.println("==========================");
    }

    public void printSearchList(Student stu) {
        System.out.println("==========================");
        System.out.println("Name : " + stu.getName());
        if (stu.getGrade() == null) {
            System.out.println("성적이 입력되지 않은 학생입니다.");
        } else {
            System.out.println("국어 : " + stu.getGrade().getKor());
            System.out.println("영어 : " + stu.getGrade().getEng());
            System.out.println("수학 : " + stu.getGrade().getMath());
            System.out.println("총점 : " + stu.getGrade().getTotal());
            System.out.println("평균 : " + stu.getGrade().getAvr());
        }
    }
}
