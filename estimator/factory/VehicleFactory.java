package workshop.estimator.factory;

import workshop.estimator.model.*;


import java.util.Optional;

public class VehicleFactory {

    // Overloaded Method 1: Create a vehicle with dynamic custom specs
    public static Optional<Vehicle> createVehicle(String type, String name, String brand,
                                                  String model, String color, int doors, double engine, String carburation) {
        if (type == null) {
            return Optional.empty();
        }

        return switch (type.trim().toLowerCase()) {
            case "car" -> Optional.of(new Car(name, brand, model, color, doors, engine, carburation));
            // Extend workshop.estimator.model.Truck and workshop.estimator.model.Motorcycle constructors to accept their custom specs here as well
            default -> Optional.empty();
        };
    }

    // Overloaded Method 2: Create a vehicle with sensible default specifications
    public static Optional<Vehicle> createDefaultVehicle(String type) {
        if (type == null) {
            return Optional.empty();
        }

        return switch (type.trim().toLowerCase()) {
            case "car" -> createVehicle("car", "Sedan", "Generic", "Base", "Black", 4, 1.5, "FuelOil");
            case "truck" -> Optional.of(new Truck("Hauler", "Mercedes-Benz", "Actros", 23000, true));
            case "motorcycle" -> Optional.of(new Motorcycle("Speeding", "Ducati", "Panigale", 2));
            default -> Optional.empty();
        };
    }
}

    /*public static Optional<workshop.estimator.model.Vehicle> createCustomVehicle(String type, String name, String brand, String model){
        if (type == null){
            return Optional.empty();
        }

        Optional<workshop.estimator.model.Vehicle> vehicle = createVehicle(type);

        if (vehicle.isPresent()){
            workshop.estimator.model.Vehicle vl = vehicle.get();
            workshop.estimator.model.Vehicle customVehicle = new workshop.estimator.model.Vehicle() {
                @Override
                public String getName() {
                    return vl.getName() + ",  "+ name;
                }

                @Override
                public String getBrand() {
                    return vl.getBrand() + ",  "+ brand;
                }

                @Override
                public String getModel() {
                    return vl.getModel()+",  "+ model;
                }
            };
            return Optional.of(customVehicle);
        }
        return Optional.empty();
    }*/
