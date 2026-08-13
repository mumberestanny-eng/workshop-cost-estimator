package workshop.estimator.service;

import workshop.estimator.strategy.*;

public class EstimatorContext {
    private LaborPricingStrategy laborStrategy;
    private PartsMarkupStrategy partsStrategy;
    private DiscountStrategy discountStrategy;

    // Pass strategies in through the constructor
    public EstimatorContext(LaborPricingStrategy laborStrategy,
                            PartsMarkupStrategy partsStrategy,
                            DiscountStrategy discountStrategy) {
        this.laborStrategy = laborStrategy;
        this.partsStrategy = partsStrategy;
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotalQuote(double laborHours, double rawPartsCost) {
        // 1. Calculate labor cost using the injected strategy
        double laborCost = laborStrategy.calculateLabourCost(laborHours);

        // 2. Calculate marked-up parts cost using the injected strategy
        double partsCost = partsStrategy.calculatePartsCost(rawPartsCost);

        // 3. Compute subtotal
        double subtotal = laborCost + partsCost;

        // 4. Apply discount strategy to subtotal and return final cost
        return discountStrategy.applyDiscount(subtotal);
    }
}
