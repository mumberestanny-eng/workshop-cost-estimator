package workshop.estimator.model;

public class BrakeServiceJob implements ServiceJob {
    /*private double hours;
    public workshop.estimator.model.BrakeServiceJob(double hours) {
        if (hours <= 0 ) {
            System.out.println("Invalid hours");
            return;
        }
        this.hours = hours;
    }*/
    @Override
    public String getDescription() {
        return "Changing brake pads on both axle";
    }
    @Override
    public double getLabourHours() {
        return 0.76;
    }
}
