package workshop.estimator.model;

public class TransmissionJob implements ServiceJob {
    /*private double hours;
    public workshop.estimator.model.TransmissionJob(double hours) {
        if (hours <= 0 ) {
            System.out.println("Invalid hours");
            return;
        }
        this.hours = hours; }*/
    @Override
    public String getDescription() {
        return "Performing transmission overhauling Job";
    }

    @Override
    public double getLabourHours() {
        return 17;
    }

}
