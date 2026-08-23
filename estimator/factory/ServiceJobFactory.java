package workshop.estimator.factory;

import workshop.estimator.model.*;


import java.util.Optional;

import workshop.estimator.model.JobType;
import workshop.estimator.model.ServiceJob;


public class ServiceJobFactory {

    public static Optional<ServiceJob> createServiceJob(String jobType) {
        if (jobType == null) {
            return Optional.empty();
        }

        switch (jobType.trim().toLowerCase()) {
            case "oil change job":
            case "oil_change":
                return Optional.of(JobType.OIL_CHANGE);
            case "transmission job":
            case "transmission":
                return Optional.of(JobType.TRANSMISSION_OVERHAUL);
            case "brake job":
            case "brake_service":
                return Optional.of(JobType.BRAKE_SERVICE);
            default:
                return Optional.empty();
        }
    }

    public static ServiceJob createServiceJob(JobType jobType) {
        return jobType;
    }

    public static Optional<ServiceJob> createCustomServiceJob(String jobType, double customHours) {
        if (customHours <= 0) {
            return Optional.empty();
        }

        return createServiceJob(jobType).map(baseJob -> new ServiceJob() {
            @Override
            public String getDescription() {
                return baseJob.getDescription() + " (Custom Duration)";
            }

            @Override
            public double getLabourHours() {
                return customHours;
            }
        });
    }
}
