package workshop.estimator.factory;

import workshop.estimator.model.*;


import java.util.Optional;

public class ServiceJobFactory {

    // 1. Factory method using Optional and Null Safety
    public static Optional<ServiceJob> createServiceJob(String jobType) {
        if (jobType == null) {
            return Optional.empty();
        }

        switch (jobType.trim().toLowerCase()) {
            case "oil change job":
                return Optional.of(new OilChangeJob());
            case "transmission job":
                return Optional.of(new TransmissionJob());
            case "brake job":
                return Optional.of(new BrakeServiceJob());
            default:
                return Optional.empty();
        }
    }

    // 2. Custom labor hours override
    public static Optional<ServiceJob> createCustomServiceJob(String jobType, double customHours) {
        if (customHours <= 0) {
            return Optional.empty(); // Simple validation check
        }

        Optional<ServiceJob> jobOpt = createServiceJob(jobType);

        if (jobOpt.isPresent()) {
            ServiceJob baseJob = jobOpt.get();
            // Wrap the base job to override labor hours
            ServiceJob customJob = new ServiceJob() {
                @Override
                public String getDescription() {
                    return baseJob.getDescription() + " (Custom Duration)";
                }

                @Override
                public double getLabourHours() {
                    return customHours;
                }
            };
            return Optional.of(customJob);
        }

        return Optional.empty();
    }
}