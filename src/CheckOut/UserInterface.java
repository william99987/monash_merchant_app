package CheckOut;

import BrowseAndShop.CartItem;
import BrowseAndShop.Product;
import CheckOut.Customer;

import java.util.Scanner;

public class UserInterface {
    public void displayDeliveryOptions() {
        System.out.println("Please select a delivery option:");
        System.out.println("1. Standard Delivery");
        System.out.println("2. Express Delivery");
    }

    public String getUserDeliveryOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice for delivery option:");
        String choice = scanner.nextLine();
        return choice;
    }

    public void displayPaymentMethods() {
        System.out.println("Please select a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. PayPal");
    }

    public String getUserPaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice for payment method:");
        String choice = scanner.nextLine();
        return choice;
    }

    public String[] getUserPaymentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your bank card number:");
        String cardNumber = scanner.nextLine();
        System.out.println("Enter your card expiry date:");
        String expiryDate = scanner.nextLine();
        System.out.println("Enter your 3-digit password:");
        String password = scanner.nextLine();
        // Assuming the payment details are separated by comma
        String[] paymentDetails = {cardNumber, expiryDate, password};
        return paymentDetails;
    }

    public void displayOrderSummary(CheckOut.OrderProcess orderProcess) {
        CheckOut.Order order = orderProcess.getOrder();
        Customer customer = orderProcess.getCustomer();
        System.out.println("Order Summary:");
        System.out.println(" ");
        for (CartItem item : order.getCartItems()) {
            System.out.println("Product Name: " + item.getProduct().getName());
            System.out.println("Product Price: " + item.getProduct().getPrice());
        }
        System.out.println("Customer: " + customer.getName());
        String deliveryType = order.getDeliveryType().equals("1") ? "Standard Delivery" : "Express Delivery";
        System.out.println("Delivery Type: " + deliveryType);
    }

    public void displayPaymentResult(CheckOut.OrderProcess orderProcess) {
        String status = orderProcess.getOrder().getStatus();
        if (status.equals("Paid")) {
            System.out.println("Payment Successful!");
        } else {
            System.out.println("Payment Failed. Please try again.");
        }
    }
}