package workshop.estimator.model;

public class Motorcycle implements Vehicle {

    private String name;
    private String brand;
    private String model;
    private int numberOfWheels;

    public Motorcycle(String name, String brand, String model, int numberOfWheels) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getBrand() {
        return brand;
    }
    @Override
    public String getModel() {return model;}
    @Override
    public String toString(){
        return "Motorcycle [Name: "+name+", Brand:  "+brand+", Model: "+model+", Number of Wheels: "+numberOfWheels+"]";
    }
}
