package LoginFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Method {
    private static final Scanner sc = new Scanner(System.in);
    static Map<String, User> userMap = new HashMap<>();

    //menu
    public static void menu(String... menus) {
        userMap.put("admin@monash.merchant.edu", new User("admin@monash.merchant.edu", "12345678", "Y"));
        userMap.put("member@student.monash.edu", new User("member@student.monash.edu", "Monash1234", "U"));
        for (String menu : menus) {
            System.out.println(menu);
        }
    }


    //login function
    public static boolean login() {
        Method.menu("=========================================================");
        Method.menu("|                                                       |");
        Method.menu("|                 Monash Merchant System                |");
        Method.menu("|                      (Login Page)                     |");
        Method.menu("|                                                       |");
        Method.menu("=========================================================");
        System.out.println("      **** Please enter your user credentials ****");
        System.out.println("");
        while (true) {
            System.out.println("Please enter your email address:");
            String emailAddress = sc.next();
            System.out.println("Please enter your password:");
            String password = sc.next();
            if (userMap.containsKey(emailAddress) && userMap.get(emailAddress).getPassword().equals(password)) {
                //check if the user is an admin
                if (userMap.get(emailAddress).getRole().equals("Y")) {
                    System.out.println("");
                    System.out.println("Login successful, welcome " + emailAddress + "[Admin] to use the system");
                    Method.menu("=========================================================");
                    Method.menu("|                                                       |");
                    Method.menu("|                 Monash Merchant System                |");
                    Method.menu("|                                                       |");
                    Method.menu("=========================================================");
                    System.out.println("               **** Welcome administrator ****            ");
                    System.out.println("");
                    return true;
                }else {
                    System.out.println("");
                    System.out.println("Login successful, welcome " + emailAddress + "[General member] to use the system");
                    Method.menu("=========================================================");
                    Method.menu("|                                                       |");
                    Method.menu("|                 Monash Merchant System                |");
                    Method.menu("|                                                       |");
                    Method.menu("=========================================================");
                    System.out.println("       **** Welcome " + emailAddress+ " ****              ");
                    System.out.println("");
                    return false;
                }
            } else {
                System.out.println("Incorrect username or password! Please try again!");
            }
        }
    }

    //admin page
    public static void adminPage(){
        System.out.println("Welcome to the admin page");
    }

    //customer page
    public static void customerPage(){
        System.out.println("Welcome to the customer page");
    }

    //a template to make the system more complete
    public static void next(){
        System.out.println("=========Welcome to Monash Merchant System!" + "emailAddress" + "=========");
        while (true){
            System.out.println("Please select your operation to execute the system: ");
            System.out.println("1.Selection 1");
            System.out.println("2.Selection 2");
            System.out.println("3.Selection 3");
            System.out.println("4.Exit the system");
            String input = sc.next();
            switch (input){
                case "1":
                    System.out.println("You have selected Selection 1");
                    break;
                case "2":
                    System.out.println("You have selected Selection 2");
                    break;
                case "3":
                    System.out.println("You have selected Selection 3");
                    break;
                case "4":
                    System.out.println("Exiting the system, please wait......");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection, please re-enter");
                    break;
            }
        }
    }

    //register function
    public static void register() {
        System.out.println("=========Welcome to Monash Merchant System=========");
        while (true) {
            System.out.println("Please enter the email address you want to register:");
            String emailAddress = sc.next();
            boolean contains = userMap.containsKey(emailAddress);
            if (contains) {
                System.out.println("The user already exists, please re-enter!");
                continue;
            }
            //define the email address have to contain @student.monash.edu
            if (!emailAddress.contains("@student.monash.edu")) {
                System.out.println("The email address must contain @student.monash.edu, please re-enter!");
                continue;
            }
            System.out.println("Please enter the password:");
            String password = sc.next();
            userMap.put(emailAddress, new User(emailAddress, password, null));

            //at least 8 characters to set password
            if (password.length() < 8) {
                System.out.println("The password must be at least 8 characters, please re-enter!");
                continue;
            }

            System.out.println("Registration successful!");
            return;
        }
    }
}
