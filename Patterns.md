****Architectural Design Patterns****

        This repository implements three fundamental GoF (Gang of Four) design patterns to achieve clean,
        maintainable, and decoupled code for a vehicle service estimation platform.

1. Factory Pattern (workshop.estimator.factory)
   Purpose: Encapsulates entity instantiation logic for Vehicle and ServiceJob hierarchies.

        Why it was chosen: Rather than scattering direct new keywords throughout the codebase,
        the factory centralizes vehicle and service job creation.
        It decouples the calling code from concrete classes (Car, Truck, OilChangeJob),
        gracefully handles default parameters, and safely manages missing or invalid creation keys using Java’s Optional.

2. Strategy Pattern (workshop.estimator.strategy)
   Purpose: Defines a family of interchangeable pricing algorithms for labor rates, parts markups, and discounts.

        Why it was chosen: Workshop pricing rules frequently change based on job complexity,
        overtime thresholds, customer tiers, and promotional discounts. 
        By separating LaborPricingStrategy, PartsMarkupStrategy, and DiscountStrategy into distinct interfaces,
        new pricing models can be introduced without modifying the core EstimatorContext execution pipeline (adhering to the Open/Closed Principle).

3. Builder Pattern (workshop.estimator.builder)
   Purpose: Separates the construction of complex ServiceOrder objects from their representation.

        Why it was chosen: Constructing a ServiceOrder requires orchestrating multiple optional and mandatory components
        (customer data, vehicle instances, multiple service jobs, parts costs, and an active pricing context). 
        The Builder pattern provides a fluent, chainable interface for step-by-step assembly, 
        enforces strict runtime field validation prior to instantiation, and guarantees thread-safe immutability for completed orders.