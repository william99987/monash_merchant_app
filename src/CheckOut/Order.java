package CheckOut;

import java.util.ArrayList;
import java.util.List;

import BrowseAndShop.CartItem;

public class Order {
    private List<CartItem> cartItems;
    private String deliveryType;
    private String status;

    public Order() {
        this.cartItems = new ArrayList<>();
        this.deliveryType = "";
        this.status = "";
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getProductNamesFromCart() {
        List<String> productNames = new ArrayList<>();
        for (CartItem item : cartItems) {
            productNames.add(item.getProduct().getName());
        }
        return productNames;
    }

    public List<Double> getProductPricesFromCart() {
        List<Double> productPrices = new ArrayList<>();
        for (CartItem item : cartItems) {
            productPrices.add(item.getProduct().getPrice());
        }
        return productPrices;
    }


}