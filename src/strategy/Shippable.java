package strategy;

public class Shippable implements ShippingStrategy{
    private double weight;
    private String weightUnit;
    public Shippable(double weight,String weightUnit) throws Exception {
        if(weight<0){
            throw new Exception("Weight Cannot be less than 0");
        }
        this.weight=weight;
        if(weightUnit== "g" || weightUnit=="Kg" || weightUnit=="Ton"){
            this.weightUnit=weightUnit;
        }else {
            throw new Exception("Weight Unit Should be g or Kg or Ton");
        }

    }
    @Override
    public boolean isShippable() {
        return true;
    }
    @Override
    public double getWeight() {
        return weight;
    }


    @Override
    public String getWeightUnit() {
        return weightUnit;
    }

}

