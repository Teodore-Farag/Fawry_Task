package strategy;

public interface ShippingStrategy {
    boolean isShippable();
    double getWeight();
    String getWeightUnit();
}
