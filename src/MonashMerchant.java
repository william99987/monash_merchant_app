//import CheckOut.*;
import LoginFunction.*;
import BrowseAndShop.*;
import ProductManager.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MonashMerchant {
    private static final Scanner scanner = new Scanner(System.in);

    public void monashMerchantMain() {
        ProductManagerMain productManagerMain = new ProductManagerMain();
        while (true) {
            Method.menu("=========================================================");
            Method.menu("|                                                       |");
            Method.menu("|                    Monash Merchant                    |");
            Method.menu("|                                                       |");
            Method.menu("=========================================================");
            Method.menu("");
            System.out.println("                      1. Register");
            System.out.println("                      2. Login");
            System.out.println("                      3. Exit");
            Method.menu("");
            System.out.print("Please select your operation：");
            String next = scanner.next();
            switch (next) {
                case "1":
                    //register function
                    //Method.register();
                    Method.menu("Register function is still optimizing and not available now, please select other operations：");
                    break;
                case "2":
                    if(Method.login())
                    {
                        //admin activity
                        productManagerMain.main();
                        break;
                    }
                    else
                    {   
                        // Browsing products and adding to cart
                        ArrayList<Product> products = new ArrayList<>();
                        ArrayList<CartItem> items = new ArrayList<>();
                        BrowseAndShop.FileIO fileIO = new FileIO();
                        products = fileIO.readProductsFromFile();
                
                        DisplayAndAddInterface displayAndAdd = new DisplayAndAddInterface(products, items);
                        displayAndAdd.chooseMenuOptions();
                        break;
                        //checkout
                    }
                    //return;
                case "3":
                    System.out.println("exit system, please wait......");
                    System.out.println("exit successfully!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("your selection is not available, please re-enter：");
                    break;
            }
        }
    }

    public static void main(String[] args)
    {
        MonashMerchant monashMerchant = new MonashMerchant();
        monashMerchant.monashMerchantMain();
    }
}