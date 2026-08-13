package workshop.estimator.strategy;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private final double discountPercentage; // e.g., 0.10 for 10%

    public PercentageDiscountStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * (1.0 - discountPercentage);
    }
}