package Models;

import strategy.ExpiryStrategy;
import strategy.ShippingStrategy;

import java.time.LocalDate;

public class Products {
    private String name;
    private double price;
    private int quantity;
    private ExpiryStrategy expiryStrategy;
    private ShippingStrategy shippingStrategy;

    public Products(String name, double price, int quantity, ExpiryStrategy expiryStrategy, ShippingStrategy shippingStrategy) throws Exception {
        if(price<0 || quantity<0){
            throw new Exception("Price or Quantity is less than 0");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryStrategy = expiryStrategy;
        this.shippingStrategy = shippingStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if(price<0){
            throw new Exception("Price can not be negative");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public boolean isExpired(){
        return expiryStrategy.isExpired();
    }
    public LocalDate getDate(){
        return expiryStrategy.getExpiryDate();
    }
    public double getWeight(){
        return shippingStrategy.getWeight();
    }
    public boolean isShippable(){
        return shippingStrategy.isShippable();
    }
    public String getWeightUnit(){
        return shippingStrategy.getWeightUnit();
    }

}
