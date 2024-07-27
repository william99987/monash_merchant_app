package ProductManager;
public class Administrator
{
    private String adminName;

    public Administrator(String adminName)
    {
        this.adminName = adminName;
    }

    public String getAdminName() {
        return this.adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}