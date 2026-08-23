# Vehicle Service & Cost Estimator Platform

A modular, clean-architecture Java application designed to calculate detailed 
repair estimates and manage service orders for automotive workshop operations.

Built with **Java 25**, this project highlights core software engineering principles including SOLID design,
immutability, defensive validation, and Gang of Four (GoF) design patterns.

---

## 🛠️ Features

* **Dynamic Service Order Builder**: Fluent, step-by-step assembly of complex service orders with strict runtime validation.
* **Flexible Pricing Strategy Pipeline**: Interchangeable billing logic for labor rates, parts markups, and promotional discounts.
* **Decoupled Entity Instantiation**: Centralized object creation for vehicles and flat-rate service jobs using factories.
* **Safe Null/Missing Value Management**: Leverages Java's `Optional<T>` to handle missing job or vehicle types gracefully.

---

## 📁 Package Architecture

The project is structured under the `workshop.estimator` package hierarchy to maintain strict separation of concerns:

```text
src/
└── workshop/
    └── estimator/
        ├── model/         # Core domain objects (Vehicle, Car, Truck, ServiceJob, ServiceOrder)
        ├── factory/       # VehicleFactory and ServiceJobFactory
        ├── strategy/      # LaborPricingStrategy, PartsMarkupStrategy, DiscountStrategy implementations
        ├── service/       # EstimatorContext || ServiceOrder.Builder
        └── Main.java      # Application pipeline entry point

🎨 Design Patterns Implemented
1. Factory Pattern (workshop.estimator.factory)

    ** Encapsulates instantiation logic for Vehicle and ServiceJob hierarchies.
    ** Decouples caller code from concrete implementations while returning Optional<T> for safe error handling.

2. Strategy Pattern (workshop.estimator.strategy)

    ** Isolates labor rates, parts markups, and discount calculations into interchangeable strategy interfaces.
    ** Enables seamless switching between standard retail rates, custom overtime rates, wholesale markups, and percentage discounts.

3. Service Pattern (workshop.estimator.builder)

    ** Enables fluent, step-by-step construction of immutable ServiceOrder instances.
    ** Performs mandatory validations (checking for customer name, vehicle assignment, and jobs list) before returning the built order.

(For a detailed architectural breakdown of design decisions, see PATTERNS.md.)

🚀 Getting Started
Prerequisites
    ** Java Development Kit (JDK): Version 17+ (JDK 25 recommended)
    ** IDE: IntelliJ IDEA, Eclipse, or VS Code

Building & Running
1. Clone the Repository:
    git clone [https://github.com/mumberestanny-eng/Vehicle-Service-Estimator.git]
          (https://github.com/mumberestanny-eng/Vehicle-Service-Estimator.git)
    cd Vehicle-Service-Estimator
    
2. Compile the Application:
    javac -d bin src/workshop/estimator/**/*.java src/Main.java

3. Run the Application:
    java -cp bin Main

📝 Example Output

        Customer Name -> ULPGL car
        Car info ->  Name: Rav4, Brand: Toyota, Model: SUV, Color: Black, Number of doors: 4 , Carburation Type: Gasoline, Engine Capacity: 1.5 Liters
        
            Service: Performing an engine oil change along with Oil  filter and several related seals : 7.0 hrs of works
        Total Quote: $446.0
        
        Customer Name -> Virunga Energies
        Car info -> Truck [Name: Hauler, Brand: Mercedes-Benz, Model: Actros, CargoCapacity: 23000kg, Has front Axle: true]
        
            Service: Changing brake pads on both axle : 0.76 hrs of works
        
            Service: Performing transmission overhauling Job : 17.0 hrs of works
        Total Quote: $396697.50000000006


👤 Author
       -> Stanislas Mumbere Kitatu
       -> GitHub: @mumberestanny-eng
