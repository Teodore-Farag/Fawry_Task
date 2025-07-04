package Models;

import Interface.ShipableItems;

public class Tuple<Product, Quantity> implements ShipableItems {
    public Products product;
    public int quantity;

    public Tuple(Products product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getWeight() {
        return product.getWeight();
    }
    public String getWeightUnit(){
        return product.getWeightUnit();
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}
