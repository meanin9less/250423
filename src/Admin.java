public class Admin extends Person{
    String id = "Admin";
    String pw = "Admin1234";

    public Admin(String name, String phone) {
        super(name, phone);
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}
