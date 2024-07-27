package BrowseAndShop;

public class CartItem 
{
    private Product product;
    private int quantity;

    //constructor
    public CartItem(Product product, int quantity) 
    {
        this.product = product;
        this.quantity = quantity;
    }

    //getters and setters
    public int getQuantity() 
    {
        return this.quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    public Product getProduct() 
    {
        return this.product;
    }

    //calculate subtotal
    public double calculateSubtotal() 
    {
        return this.product.getPrice() * this.quantity;
    }
}