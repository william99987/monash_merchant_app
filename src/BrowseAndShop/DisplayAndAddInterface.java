package BrowseAndShop;

import java.util.ArrayList;
import java.util.Scanner;

import CheckOut.Order;
import CheckOut.UserInterface;
import LoginFunction.Customer;
import CheckOut.OrderProcess;
import CheckOut.Account;

public class DisplayAndAddInterface
{
    private ProductDisplayController displayController;
    private ShoppingCartController cartController;
    private UserInterface userInterface;
    private OrderProcess orderProcess; 
    private Account account;
    //default constructor
    public DisplayAndAddInterface()
    {
        this.displayController = new ProductDisplayController();
        this.cartController = new ShoppingCartController();
    }

    //parameterized constructor
    public DisplayAndAddInterface(ArrayList<BrowseAndShop.Product> products, ArrayList<BrowseAndShop.CartItem> items)
    {
        this.displayController = new ProductDisplayController(products);
        this.cartController = new ShoppingCartController(items);
    }

    //display logo
    public void displayLogo()
    {
        System.out.println("         Please select one of the option below: ");
    }

    //display main menu
    public void displayMainMenu()
    {
        System.out.println("         Input '1' to Browse Products");
        System.out.println("         Input '2' to View Your Shopping Cart");
        //System.out.println("         Input '3' to Checkout");
        System.out.println("         Input '0' to Exit");
    }

    public void displayBrowseProductsMenu()
    {
        System.out.println("         Input '3' to Add Selected Product to Your Cart");
        System.out.println("         Input '0' to Exit");
    }

    //display cart page menu
    public void displayCartMenu()
    {
        System.out.println("         Input '4' to Checkout");
        System.out.println("         Input '0' to Exit");
    }

    //display exit message
    public void displayExitMessage()
    {
        System.out.println("Thank you for shopping with us!");
    }

    //menu options
    public void chooseMenuOptions()
    {
        displayLogo();
        displayMainMenu();
        Customer customer = new LoginFunction.Customer();

        //create scanner object
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre your choice: ");
        int choice = scanner.nextInt();

        while(true)
        {
            switch (choice) 
            {
                case 1:
                    //display products
                    displayController.displayProducts();
                    System.out.println();
                    displayBrowseProductsMenu();
                    System.out.println("Entre your choice:");
                    choice = scanner.nextInt();
                    continue;

                case 2:
                    //display cart
                    ArrayList<BrowseAndShop.CartItem> items = cartController.getItems();
                    System.out.println();
                    System.out.println("Your cart: ");
                    for (int i = 0; i < items.size(); i++) 
                    {
                        System.out.println((i + 1) + ". " + items.get(i).getProduct().getName() + " x" + items.get(i).getQuantity());
                    }
                    System.out.println();
                    displayCartMenu();
                    System.out.println("Entre your choice:");
                    choice = scanner.nextInt();
                    continue;

                case 3:
                    //add product to cart
                    while (true)
                    {
                        System.out.println();
                        System.out.println("Entre the product serial number to add to cart: ");
                        int productNumber = scanner.nextInt();

                        if(productNumber < 1 || productNumber > displayController.getProducts().size())
                        {
                            System.out.println("Invalid product number. Please entre again.");
                            continue;
                        }

                        cartController.addItem(displayController.getOneProduct(productNumber - 1), 1);
                        System.out.println("Product added to cart successfully!");
                        System.out.println();
                        
                        System.out.println("         Input '1' to Browse Products");
                        System.out.println("         Input '2' to View Your Shopping Cart");
                        System.out.println("         Input '3' to Add Selected Product to Your Cart");
                        System.out.println("         Input '4' to Checkout");
                        System.out.println("         Input '0' to Exit");
                        System.out.println("Entre your choice:");
                        choice = scanner.nextInt();
                        break;
                    }
                    continue;

                case 4:
                    //checkout
                    if(cartController.checkoutAvailibility(customer))
                    {
                        System.out.println(cartController.getItems());
                        UserInterface userInterface = new UserInterface();

                        CheckOut.Customer customer2 = new CheckOut.Customer("John Doe", "123 Main St", "john@example.com");

                        Order order = new Order();

                        Account account = new Account(10000000.0);
                        OrderProcess orderProcess = new OrderProcess(customer2, order);

                        // Show shipping options
                        userInterface.displayDeliveryOptions();

                        // Get the user's shipping options
                        String deliveryOption = userInterface.getUserDeliveryOption();
                        orderProcess.selectDeliveryMethod(deliveryOption);
                        // Show order summary
                        userInterface.displayOrderSummary(orderProcess);

                        // Show payment method
                        userInterface.displayPaymentMethods();
                        // Get the user's payment method
                        String paymentMethod = userInterface.getUserPaymentMethod();
                        // Get user's payment details
                        String[] paymentDetails = userInterface.getUserPaymentDetails();
                        cartController.removeItems();
                        System.out.println("Pay successfully!");
                        System.out.println();

                        System.out.println("         Input '1' to Browse Products");
                        System.out.println("         Input '2' to View Your Shopping Cart");
                        System.out.println("         Input '3' to Add Selected Product to Your Cart");
                        System.out.println("         Input '4' to Checkout");
                        System.out.println("         Input '0' to Exit");
                        System.out.println("Entre your choice:");
                        choice = scanner.nextInt();
                        break;
                    }
                    else
                    {
                        System.out.println("Fund is not enough");
                        System.out.println("Pay unsuccessful!");
                        System.out.println();

                        System.out.println("         Input '1' to Browse Products");
                        System.out.println("         Input '2' to View Your Shopping Cart");
                        System.out.println("         Input '3' to Add Selected Product to Your Cart");
                        System.out.println("         Input '4' to Checkout");
                        System.out.println("         Input '0' to Exit");
                        System.out.println("Entre your choice:");
                        break;
                    }

                case 0:
                    displayExitMessage();
                    return;

                default:
                    System.out.println("Invalid choice. Please entre again.");
                    System.out.println("Entre your choice:");
                    choice = scanner.nextInt();
                    continue;
            }
        }
    }
}