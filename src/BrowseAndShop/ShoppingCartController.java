package BrowseAndShop;

import LoginFunction.Customer;

import java.util.ArrayList;

public class ShoppingCartController 
{
    private ArrayList<CartItem> items;

    //default constructor
    public ShoppingCartController() 
    {
        this.items = new ArrayList<>();
    }

    //parameterized constructor
    public ShoppingCartController(ArrayList<CartItem> items) 
    {
        this.items = items;
    }

    //add item
    public void addItem(BrowseAndShop.Product product, int quantity) 
    {
        this.items.add(new CartItem(product, quantity));
    }

    //getters
    public ArrayList<CartItem> getItems() 
    {
        return this.items;
    }

    public double getTotalAmount() 
    {
        double total = 0;
        for (CartItem item : this.items) 
        {
            total += item.calculateSubtotal();
        }
        return total;
    }

    //checkout
    public boolean checkoutAvailibility(Customer customer)
    {
        if(this.getTotalAmount() > customer.getFound())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void removeItems()
    {
        this.items.clear();
    }
}