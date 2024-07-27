package CheckOut;

import BrowseAndShop.FileIO;
import BrowseAndShop.Product;
import BrowseAndShop.ShoppingCartController;
import BrowseAndShop.CartItem;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();

        Customer customer = new Customer("John Doe", "123 Main St", "john@example.com");

        Order order = new Order();

        Account account = new Account(10000000.0);
        OrderProcess orderProcess = new OrderProcess(customer, order);


        userInterface.displayDeliveryOptions();


        String deliveryOption = userInterface.getUserDeliveryOption();
        orderProcess.selectDeliveryMethod(deliveryOption);


        userInterface.displayOrderSummary(orderProcess);


        userInterface.displayPaymentMethods();


        String paymentMethod = userInterface.getUserPaymentMethod();

        String[] paymentDetails = userInterface.getUserPaymentDetails();


    }
}