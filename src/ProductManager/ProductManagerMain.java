package ProductManager;
import java.util.Scanner;


public class ProductManagerMain
{
    private ProductManagement productManagement;
    private AdminInterface adminInterface;
    private Scanner scanner;
    private RandomProductGenerator randomProductGenerator;
    public ProductManagerMain()
    {
        this.productManagement = new ProductManagement();
        this.adminInterface = new AdminInterface();
    }

    public void main()
    {
        this.randomProductGenerator = new RandomProductGenerator();
        this.scanner = new Scanner(System.in);
        while (true){
            System.out.println("             Please select one of the option below: ");
            System.out.println("             1.add product");
            System.out.println("             2.update product");
            System.out.println("             3.remove product");
            System.out.println("             4.show the product information");
            System.out.println("             5.exit");
            String input = scanner.next();
            switch (input){
                case "1":
                    System.out.println("You have selected Selection 1");
                    adminInterface.addProductInterface();
                    break;
                case "2":
                    System.out.println("You have selected Selection 2");
                    adminInterface.updateProductInterface();
                    break;
                case "3":
                    System.out.println("You have selected Selection 3");
                    adminInterface.removeProductInterface();
                    break;
                case "4":
                    System.out.println("You have selected Selection 4");
                    productManagement.printAllProducts();
                    break;
                case "5":
                    System.out.println("Exit successful");
                    return;
                default:
                    System.out.println("Invalid selection, please re-enter");
                    break;
            }
        }
    }

    public static void main(String[] args)
    {
       ProductManagerMain productManagerTest = new ProductManagerMain();
        productManagerTest.main();
    }
}