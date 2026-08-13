package workshop.estimator.model;

public class Truck implements Vehicle {
    private String name;
    private String brand;
    private String model;
    private int cargoCapacity;
    boolean hasFrontAxle;

    public Truck(String name, String brand, String model, int cargoCapacity, boolean hasFrontAxle) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.cargoCapacity = cargoCapacity;
        this.hasFrontAxle = hasFrontAxle;
    }

    @Override
    public String getName() { return name; }
    @Override
    public String getBrand() { return brand; }
    @Override
    public String getModel() {return model;}
    @Override
    public String toString(){
        return "Truck [Name: "+name+", Brand: "+brand+", Model: "+model+", CargoCapacity: "+cargoCapacity+"kg, Has front Axle: "+hasFrontAxle+"]";
    }

}
