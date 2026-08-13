package workshop.estimator.strategy;

public class StandardMarkupStrategy implements PartsMarkupStrategy {
    @Override
    public double calculatePartsCost(double rawPartsCost) {
        return rawPartsCost * 1.2;
    }
}
