package strategy;

public class NotShippable implements ShippingStrategy{
    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public String getWeightUnit() {
        return "";
    }
}
