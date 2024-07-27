package ProductManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.List;
import ProductManager.*;

public class AdminIo
{
    private Scanner scanner;

    private static final Set<String> VALID_CATEGORIES = new HashSet<>(Arrays.asList(
        "Fruits", "Bakery", "Meat", "Dairy", "Pasta", "Rice", "Vegetables", "Drinks",
        "Snacks", "Frozen", "Canned", "Household", "Personal Care", "Pet Supplies",
        "Baby Products", "Health & Beauty", "Electronics", "Home & Garden", "Fashion",
        "Sports & Outdoors", "Toys & Games", "Books & Media", "Automotive", "Gifts & Occasions", "Other"
    ));

    private static final Set<String> VALID_SUBCATEGORIES = new HashSet<>(Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"
    ));

    private static final String FILE_PATH = "ProductInfo.txt";

    public AdminIo()
    {
        this.scanner = new Scanner(System.in);
    }

    public int getValidatedProductId()
    {
        int id;
        ProductManagement productManagement = new ProductManagement();
        List<Integer> productIds = productManagement.extractProductIds(FILE_PATH);
        do {
            System.out.println("Enter Product ID (between 1000000000 and 2000000000):");
            while (!scanner.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a positive number between 1000000000 and 2000000000:");
                scanner.next();
            }
            id = scanner.nextInt();
        }while (id < 1000000000 || id > 2000000000 || productIds.contains(id));
        return id;
    }

    public int getNewProductId()
    {
        int id;
        ProductManagement productManagement = new ProductManagement();
        List<Integer> productIds = productManagement.extractProductIds(FILE_PATH);
        do {
            System.out.println("Enter Product ID (between 1000000000 and 2000000000) & (make sure the ID exists):");
            while (!scanner.hasNextInt())
            {
                System.out.println("Invalid input. Please enter a positive number between 1000000000 and 2000000000, and you cannot enter product id that does not exist:");
                scanner.next();
            }
            id = scanner.nextInt();
        }while (id < 1000000000 || id > 2000000000 || !productIds.contains(id));
        return id;
    }

    public String getValidatedName()
    {
        String name;
        do {
            System.out.println("Enter Product Name (letters and numbers only):");
            name = scanner.next();
        }while (! name.matches("[a-zA-Z0-9]+"));
        return name;
    }

    public String getValidatedBrand()
    {
        String brand;
        System.out.println("Enter Product brand:");
        brand = scanner.next();
        return brand;
    }

    public String getValidatedCategory()
    {
        String category;
        System.out.println("Enter Product Category:");
        System.out.println("enter one of the following:" + VALID_CATEGORIES);
        do {
            category = scanner.nextLine();
            if(!VALID_CATEGORIES.contains(category)){
                 System.out.println("Invalid category. Please enter one of the following: " + String.join(", ", VALID_CATEGORIES));
            }
            }while(!VALID_CATEGORIES.contains(category));
         return category;
    }

    public String getValidatedSubcategory()
    {
        String subcategory;
        System.out.println("Enter Product subcategory:");
        System.out.println("enter one of the following:" + VALID_SUBCATEGORIES);
        do {
            subcategory = scanner.next();
            if(!VALID_SUBCATEGORIES.contains(subcategory)){
                 System.out.println("Invalid category. Please enter one of the following: " + String.join(", ", VALID_SUBCATEGORIES));
            }
            }while(!VALID_SUBCATEGORIES.contains(subcategory));
         return subcategory;
    }

    public String getValidatedDescription()
    {
        String description;
        System.out.println("Enter Product description:");
        description = scanner.next();
        return description;
    }

    public double getValidatedPrice()
    {
        double price;
        do {
            System.out.println("Enter Product Price (positive number):");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a positive number:");
                scanner.next(); // consume invalid input
            }
            price = scanner.nextDouble();
        } while (price <= 0);
        return price;
    }

    public double getValidatedMemberPrice()
    {
        double memberPrice;
        do {
            System.out.println("Enter Member Price (positive number):");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a positive number:");
                scanner.next(); // consume invalid input
            }
            memberPrice = scanner.nextDouble();
        } while (memberPrice <= 0);
        return memberPrice;
    }
}