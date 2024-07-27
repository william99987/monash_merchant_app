package CheckOut;

public class OrderProcess {
    private Customer customer;
    private CheckOut.Order order;

    public OrderProcess(Customer customer, CheckOut.Order order) {
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CheckOut.Order getOrder() {
        return order;
    }

    public void setOrder(CheckOut.Order order) {
        this.order = order;
    }

    public void selectDeliveryMethod(String deliveryType) {

        order.setDeliveryType(deliveryType);
    }

    public void confirmOrderSummary() {

        System.out.println("Order Summary:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Delivery Type: " + order.getDeliveryType());
    }

    public void selectPaymentMethod(String paymentMethod, Account account, String[] paymentDetails) {

        System.out.println("Payment Details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Delivery Type: " + order.getDeliveryType());
    }

    public boolean processPayment() {

        return order.getStatus().equals("Paid");
    }
}