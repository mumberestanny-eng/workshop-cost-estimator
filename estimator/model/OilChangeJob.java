package workshop.estimator.model;

public class OilChangeJob implements ServiceJob {

    @Override
    public String getDescription() { return "Performing an engine oil change along with Oil  filter and several related seals"; }

    @Override
    public double getLabourHours() { return 7 ;}
}