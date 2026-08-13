package workshop.estimator.strategy;

public class FlatDiscountStrategy implements DiscountStrategy {
    private final double discountAmount;

    public FlatDiscountStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double amount) {
        return Math.max(0.0, amount - discountAmount);
    }
}
