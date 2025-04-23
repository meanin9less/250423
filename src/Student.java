public class Student extends Person{
    private String id;
    private Grade grade = null;
    public Student(String name, String phone, String id) {
        super(name, phone);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
