package LoginFunction;

public class Customer extends User{
    private int customerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String dob;
    private String gender;
    private  int found;

    public Customer(String emailAddress, String password, String role) {
        super(emailAddress, password, role);
    }

    public Customer()
    {
        this.found = 10000;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getFound()
    {
        return found;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFound(int found)
    {
        this.found = found;
    }
}
