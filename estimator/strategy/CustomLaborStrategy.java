package workshop.estimator.strategy;

public class CustomLaborStrategy implements LaborPricingStrategy {
    private final double hourlyRate;

    public CustomLaborStrategy(double hourlyRate){ this.hourlyRate = hourlyRate; }

    @Override
    public double calculateLabourCost(double hours) {
        if (hours > 8.0) {
            double standardHours = 8.0;
            double overtimeHours = hours - 8.0;

            double standardCost = standardHours * hourlyRate;
            double overtimeCost = overtimeHours * hourlyRate;

            return overtimeCost + standardCost;
        }
        return hours * hourlyRate;
    }
}
