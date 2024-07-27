package BrowseAndShop;

public class Product 
{
    private int productId;
    private String name;
    private String brand;
    private String category;
    private String subcategory;
    private String description;
    private double price;

    //constructor
    public Product(int productId, String name, String brand, String category, String subcategory, String description, double price) 
    {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.subcategory = subcategory;
        this.description = description;
        this.price = price;
    }

    //getters and setters
    public int getProductId() 
    {
        return this.productId;
    }

    public String getName() 
    {
        return this.name;
    }

    public String getBrand() 
    {
        return this.brand;
    }

    public String getCategory() 
    {
        return this.category;
    }

    public String getSubcategory() 
    {
        return this.subcategory;
    }

    public String getDescription() 
    {
        return this.description;
    }

    public double getPrice() 
    {
        return this.price;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setSubcategory(String subcategory)
    {
        this.subcategory = subcategory;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}