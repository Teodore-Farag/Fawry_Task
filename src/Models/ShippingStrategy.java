package Models;

public interface ShippingStrategy {
    boolean isShippable();
    double getWeight();
    String getWeightUnit();
}
