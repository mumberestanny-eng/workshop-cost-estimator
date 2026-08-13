package workshop.estimator.model;

public class Car implements Vehicle {

    private String color;
    private String name;
    private String brand;
    private String model;
    private int numberOfDoors;
    private final double engineSize;
    private final String carburationType;

    public Car(String name, String brand, String model, String color, int numberOfDoors, double engineSize, String carburationType) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.engineSize = engineSize;
        this.carburationType = carburationType;
    }
    @Override
    public String getBrand() {return brand;}
    @Override
    public String getModel() {return model;}
    @Override
    public String getName(){ return name;}
    @Override
    public String toString(){
        return "Name: " + name + ", Brand: " + brand + ", Model: "
                + model + ", Color: " + color + ", Number of doors: " + numberOfDoors + " " +
                ", Carburation Type: " + carburationType+", Engine Capacity: " + engineSize+" Liters";
    }

}
