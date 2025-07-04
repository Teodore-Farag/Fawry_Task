package Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int customer_id;
    private List<Tuple> products=new ArrayList<>();
    private double total;
    private double weight;
    private String weightUnit;

    public Cart(int customer_id) {
        this.customer_id = customer_id;
        this.weightUnit="g";
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public double getTotal() {
        double total=0;
        for (int i=0;i<products.size();i++){
            total+=products.get(i).product.getPrice()*products.get(i).quantity;
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Tuple> getProducts() {
        return products;
    }

    public void setProducts(List<Tuple> products) {
        this.products = products;
    }
    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }
    public void add(Products products,int quantity) throws Exception {
        if (products.getQuantity()<quantity){
            throw new Exception("Not enough quantity for the product "+ products.getName());
        }
        if(quantity<1){
            throw new Exception("Can not add negative or zero items");
        }
        else{
            boolean duplicate=false;
            for(int i=0;i<this.products.size();i++){
                if(this.products.get(i).getName()==products.getName()){
                    duplicate=true;
                    this.products.get(i).setQuantity(this.products.get(i).quantity+quantity);
                }
            }
            if (!duplicate){
                this.products.add(new Tuple(products,quantity));
            }
            products.setQuantity(products.getQuantity()-quantity);
            if(products.isShippable()) {
                if (products.getWeightUnit().equals("g")) {
                    this.weight += products.getWeight();
                } else if (products.getWeightUnit().equals("Kg")) {
                    this.weight += products.getWeight() * 1000;
                } else {
                    this.weight += products.getWeight() * 1000 * 1000;
                }
            }
        }
    }
    public void remove(Products products,int quantity) throws Exception {
        if(quantity<1){
            throw new Exception("can not remove nothing or negative");
        }
        boolean found=false;
        for(int i=0;i<this.products.size();i++){
            if(this.products.get(i).product.getName()==products.getName()){
                found=true;
                if (this.products.get(i).getQuantity()>quantity){
                    this.products.get(i).setQuantity(this.products.get(i).getQuantity()-quantity);
                    products.setQuantity(products.getQuantity()+quantity);
                }
                else if (this.products.get(i).getQuantity()==quantity){
                    products.setQuantity(products.getQuantity()+quantity);
                    this.products.remove(i);
                }
                else {
                    throw new Exception("Cannot remove quantity more than in the Cart");
                }
            }
       }
        if (!found){
            throw new Exception("Product you are trying to remove does not exist");
        }
    }
    public String getFullCartWeight() throws Exception {
        weight=0;
        weightUnit="g";
        for (int i=0;i<products.size();i++){
            switch (products.get(i).getWeightUnit()){
                case "g":weight+=products.get(i).getWeight()*products.get(i).quantity;break;
                case "Kg":weight+=products.get(i).getWeight()*products.get(i).quantity*1000;break;
                case "Ton":weight+=products.get(i).getWeight()*products.get(i).quantity*1000000;break;
                case "":break;
                default:
                    throw new Exception("Wrong Format of Unit");
            }
        }
        if(weight>=1000000){
            weight=weight/1000000;
            weightUnit="Ton";
        } else if (weight>=1000) {
            weight=weight/1000;
            weightUnit="Kg";
        }else{
            weight=weight;
            weightUnit="g";
        }
        return weight+""+weightUnit;
    }
}
