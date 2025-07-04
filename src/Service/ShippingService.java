package Service;

import Interface.ShipableItems;
import Models.Tuple;

import java.util.ArrayList;
import java.util.List;

public class ShippingService {
    public static List<String> process(List<ShipableItems> items) {
        List<String> output = new ArrayList<>();
        System.out.println("** Shipment Notice **");
        for (ShipableItems item : items) {
            output.add (item.getName() + "   " );
        }
        return output;
    }
//    public static void processV2(List<Tuple> shipping){
//        System.out.println("** Shipment Notice **");
//        for (int i=0;i<shipping.size();i++){
//            System.out.println(shipping.get(i).getQuantity()+"X "+shipping.get(i).getName()+"   "+calculateProductWeight(shipping.get(i),shipping.get(i).getQuantity()));
//    }
//    }

}
