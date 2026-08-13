package workshop.estimator.strategy;

public class StandardLaborStrategy implements LaborPricingStrategy {
    @Override
    public double calculateLabourCost(double hours) {
        return hours * 50.00;
    }
}
