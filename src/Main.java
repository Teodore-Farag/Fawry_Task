import Models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Customers customer=new Customers("Teodore",1,8370,"Teodoremaged@gmail.com");
        Products cheese= new Products("Cheese",100,10,new Expiry(LocalDate.of(2025, 7, 20)),new Shippable(500,"g"));
        Products biscuit= new Products("Biscuits",150,2,new Expiry(LocalDate.of(2026, 7, 1)),new Shippable(700,"g"));
        Products tv= new Products("TV",3000,7,new NoExpiry(),new Shippable(3,"Kg"));
        Products scratchCard= new Products("Scratch Card",10,100,new Expiry(LocalDate.of(2029, 1, 1)),new NotShippable());
        Cart cart=new Cart(1);
        cart.add(cheese,2);
        cart.add(tv,1);
        cart.add(tv,1);
        cart.add(cheese,1);
        checkout(customer,cart);
    }
    public static void checkout(Customers customer, Cart cart) throws Exception {
        System.out.println("Customer Balance Before: "+ customer.getBalance());
        if (cart.getProducts().isEmpty()){
            throw new Exception("Cart is Empty");
        }
        for (int i=0;i<cart.getProducts().size();i++){
            if(cart.getProducts().get(i).product.isExpired()){
                throw new Exception("The product "+ cart.getProducts().get(i).product.getName()+" is Expired");
            }
        }
        List<ShipableItems> shipping=new ArrayList<>();
        List<Tuple> shippingV2=new ArrayList<>();
        for (int i=0;i<cart.getProducts().size();i++){
            if(cart.getProducts().get(i).product.isShippable()){
                shipping.add(cart.getProducts().get(i));
                shippingV2.add(cart.getProducts().get(i));
            }
        }
        ShippingService.processV2(shippingV2);
        System.out.println("Total Package Weight "+ cart.getFullCartWeight());
        System.out.println();
        System.out.println("*** Checkout receipt ***");
        for (int i=0;i<cart.getProducts().size();i++){
            System.out.println(cart.getProducts().get(i).quantity+"X "+cart.getProducts().get(i).product.getName()+"     "+cart.getProducts().get(i).product.getPrice()* cart.getProducts().get(i).quantity);
        }
        System.out.println("--------------------");
        System.out.println("Subtotal            "+cart.getTotal());
        double shippingPrice=shipmentPrice(cart);
        System.out.println("Shipping            "+shippingPrice);
        System.out.println("Amount              "+(cart.getTotal()+shippingPrice));
        if (cart.getTotal()+shippingPrice>customer.getBalance()){
            throw new Exception("Customer Balance is insufficient");
        }
        customer.setBalance(customer.getBalance()-(shippingPrice+ cart.getTotal()));
        System.out.println("Customer Balance After: "+ customer.getBalance());
    }
    public static double shipmentPrice(Cart cart){
        if(cart.getWeightUnit().equals("g")){
            return 15;
        } else if (cart.getWeightUnit().equals("Kg")) {
            return 30*Math.round(cart.getWeight());
        }else {
            return 10000*Math.round(cart.getWeight());
        }

    }
}