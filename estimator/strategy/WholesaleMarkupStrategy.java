package workshop.estimator.strategy;

public class WholesaleMarkupStrategy implements PartsMarkupStrategy {
    @Override
    public double calculatePartsCost(double rawPartsCost) {
        return rawPartsCost * 1.05;
    }
}
