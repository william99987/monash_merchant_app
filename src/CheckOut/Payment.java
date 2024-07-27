package CheckOut;

public class Payment {
    private String method;
    private double amount;
    private Account account; // Assuming there is an Account class

    public Payment(String method, double amount, Account account) {
        this.method = method;
        this.amount = amount;
        this.account = account;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean authorizePayment() {
        return account.deductBalance(amount); // Assuming Account class has a deductBalance method
    }
}
