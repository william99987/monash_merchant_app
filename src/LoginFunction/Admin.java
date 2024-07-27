package LoginFunction;

public class Admin extends User{
    private String adminName;

    public Admin(String emailAddress, String password, String role, String adminName) {
        super(emailAddress, password, role);
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
