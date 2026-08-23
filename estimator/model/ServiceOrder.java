package workshop.estimator.model;

import workshop.estimator.service.EstimatorContext;

import java.util.*;
import java.lang.*;

public class ServiceOrder {

    private final String customerName;
    private final Vehicle vehicle;
    private final List<ServiceJob> serviceJobs;
    private final double partsCost;
    private final EstimatorContext pricingContext; // 1. Store the pricing context

    private ServiceOrder(Builder builder) {
        this.customerName = builder.customerName;
        this.vehicle = builder.vehicle;
        // Make a defensive copy of the list for safety
        this.serviceJobs = List.copyOf(builder.serviceJobs);
        this.partsCost = builder.partsCost;
        this.pricingContext = builder.pricingContext;
    }

    public String getCustomerName() { return customerName; }
    public Vehicle getVehicle() { return vehicle; }
    public List<ServiceJob> getServiceJobs() { return serviceJobs; }
    public double getPartsCost() { return partsCost; }

    // 2. Helper method to compute total bill using the strategy context
    public double calculateTotalBill() {
        if (pricingContext == null) {
            throw new IllegalStateException("Pricing context must be set to calculate the bill.");
        }

        // Sum up total labor hours from all jobs on this order
        double totalLaborHours = 0.0;
        for (ServiceJob job : serviceJobs) {
            totalLaborHours += job.getLabourHours();
        }

        // Pass total hours and raw parts cost to the strategy context
        return pricingContext.calculateTotalQuote(totalLaborHours, partsCost);
    }

    public static class Builder {
        private String customerName;
        private Vehicle vehicle;
        private List<ServiceJob> serviceJobs = new ArrayList<>();
        private double partsCost;
        private EstimatorContext pricingContext;

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder addJob(ServiceJob job) {
            if (job != null) {
                this.serviceJobs.add(job);
            }
            return this;
        }

        public Builder setPartsCost(double partsCost) {
            this.partsCost = partsCost;
            return this;
        }

        public Builder setPricingContext(EstimatorContext pricingContext) {
            this.pricingContext = pricingContext;
            return this;
        }

        public ServiceOrder build() {
            if (customerName == null || customerName.isBlank()) {
                throw new IllegalStateException("Customer name must be provided.");
            }
            if (vehicle == null) {
                throw new IllegalStateException("A vehicle must be assigned.");
            }
            if (serviceJobs.isEmpty()) {
                throw new IllegalStateException("At least one service job must be added.");
            }
            if (pricingContext == null) {
                throw new IllegalStateException("A pricing strategy context must be set.");
            }
            if (partsCost < 0) {
                throw new IllegalStateException("Parts cost must be non-negative.");
            }
            return new ServiceOrder(this);
            }
        }
    }
