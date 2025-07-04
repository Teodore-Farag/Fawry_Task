package Models;

import java.util.List;

public class ShippingService {
//    public static void process(List<ShipableItems> items) {
//        System.out.println("** Shipment Notice **");
//        for (ShipableItems item : items) {
//            System.out.println(item.getName() + "   " + item.getWeight());
//        }
//    }
    public static void processV2(List<Tuple> shipping){
        System.out.println("** Shipment Notice **");
        for (int i=0;i<shipping.size();i++){
            System.out.println(shipping.get(i).getQuantity()+"X "+shipping.get(i).getName()+"   "+calculateProductWeight(shipping.get(i),shipping.get(i).getQuantity()));
    }
    }
    public static String  calculateProductWeight(Tuple product,int quantity) {
        double weight=product.getWeight()*quantity;
        String weightUnit=product.getWeightUnit();
        if(weight>=1000 && weightUnit.equals("g")){
            weight/=1000;
            weightUnit="Kg";
        }
        if(weight>=1000 && weightUnit.equals("Kg")){
            weight/=1000;
            weightUnit="Ton";
        }

        return (weight+""+weightUnit);
    }
}
