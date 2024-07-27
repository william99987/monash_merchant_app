package ProductManager;
import java.util.Scanner;

import BrowseAndShop.Product;
import ProductManager.*;
import ProductManager.ProductManagement;

public class AdminInterface
{
    private ProductManagement productManagement;
    private AdminIo adminIo;

    public AdminInterface()
    {
        this.productManagement = new ProductManagement();
        this.adminIo = new AdminIo();
    }

    public void addProductInterface()
    {
        int id = adminIo.getValidatedProductId();
        String name = adminIo.getValidatedName();
        String brand = adminIo.getValidatedBrand();
        String category = adminIo.getValidatedCategory();
        String subcategory = adminIo.getValidatedSubcategory();
        String description = adminIo.getValidatedDescription();
        double price = adminIo.getValidatedPrice();
        Product product = new Product(id, name, brand, category, subcategory, description, price);
        productManagement.addProduct(product);
    }

    public void updateProductInterface()
    {
        ProductManagement.printAllProducts();
        int id = adminIo.getNewProductId();
        String name = adminIo.getValidatedName();
        String brand = adminIo.getValidatedBrand();
        String category = adminIo.getValidatedCategory();
        String subcategory = adminIo.getValidatedSubcategory();
        String description = adminIo.getValidatedDescription();
        double price = adminIo.getValidatedPrice();
        Product product = new Product(id, name, brand, category, subcategory, description, price);
        productManagement.updateProduct(product.getProductId(), product.getName(), product.getBrand(),
                product.getCategory(), product.getSubcategory(), product.getDescription(), product.getPrice() );
    }

    public void removeProductInterface()
    {
        ProductManagement.printAllProducts();
        int id = adminIo.getNewProductId();
        productManagement.removeProduct(id);
    }

}