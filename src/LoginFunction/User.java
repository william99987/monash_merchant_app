package LoginFunction;

public class User {
    private String emailAddress;
    private String password;
    private String role;

    public User() {
    }

    public User(String emailAddress, String password, String role) {
        this.emailAddress = emailAddress;
        this.password = password;
        if (role == null) {
            this.role = "U";
        } else {
            this.role = role;
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
