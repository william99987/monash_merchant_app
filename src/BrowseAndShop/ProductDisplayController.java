package BrowseAndShop;

import java.util.ArrayList;

public class ProductDisplayController 
{
    private ArrayList<Product> products;

    //default constructor
    public ProductDisplayController() 
    {
        this.products = new ArrayList<>();
    }

    //parameterized constructor
    public ProductDisplayController(ArrayList<Product> products) 
    {
        this.products = products;
    }

    //add product
    public void addProduct(Product product) 
    {
        this.products.add(product);
    }

    //getters
    public ArrayList<Product> getProducts() 
    {
        return this.products;
    }

    public Product getOneProduct(int index) 
    {
        return this.products.get(index);
    }

    //display products
    public void displayProducts() 
    {
        int n = 1;
        for (Product product : products) 
        {
            System.out.println("Product " + n);
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Name: " + product.getName());
            System.out.println("Brand: " + product.getBrand());
            System.out.println("Category: " + product.getCategory());
            System.out.println("Subcategory: " + product.getSubcategory());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("-------------------------");
            n++;
        }
    }
}
