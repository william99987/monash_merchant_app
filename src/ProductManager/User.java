package ProductManager;
public class User {
    private String emailAddress;
    private String password;
    private boolean customerOrNot;

    public User(String emailAddress, String password, boolean customerOrNot)
    {
        this.emailAddress = emailAddress;
        this.password = password;
        this.customerOrNot = customerOrNot;
    }

    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    public String getPassword()
    {
        return this.password;
    }

    public boolean getCustomerOrNot()
    {
        return  this.customerOrNot;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setCustomerOrNot(boolean customerOrNot)
    {
        this.customerOrNot = customerOrNot;
    }
}