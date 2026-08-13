package workshop.estimator.model;

public enum JobType implements ServiceJob {
    // Enum constants pass values into the internal constructor
    OIL_CHANGE("Engine Oil & Filter Replacement", 0.5),
    BRAKE_SERVICE("Brake Pad Replacement", 1.0),
    TRANSMISSION_OVERHAUL("Complete Transmission Overhaul", 24.0);

    private final String description;
    private final double labourHours;

    // Enum constructor (always private or package-private)
    JobType(String description, double labourHours) {
        this.description = description;
        this.labourHours = labourHours;
    }

    // Implementing interface methods directly inside the Enum
    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getLabourHours() {
        return this.labourHours;
    }
}