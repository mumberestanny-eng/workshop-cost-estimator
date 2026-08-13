package workshop.estimator.strategy;

public class PremiumLaborStrategy implements LaborPricingStrategy {
    @Override
    public double calculateLabourCost(double hours) {
        return hours * 85.00;
    }
}
