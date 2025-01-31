package Abstract_Factory;

// Step 1: Define Abstract Product Interfaces
interface LandVehicle {
    void start();
    void stop();
}

interface WaterVehicle {
    void start();
    void stop();
}

// Step 2: Create Concrete Products for Land Vehicles
class Car implements LandVehicle {
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping.");
    }
}

class Bike implements LandVehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping.");
    }
}

// Step 3: Create Concrete Products for Water Vehicles
class Boat implements WaterVehicle {
    @Override
    public void start() {
        System.out.println("Boat is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Boat is stopping.");
    }
}

class Ship implements WaterVehicle {
    @Override
    public void start() {
        System.out.println("Ship is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Ship is stopping.");
    }
}

// Step 4: Define the Abstract Factory
interface VehicleFactory {
    LandVehicle createLandVehicle();
    WaterVehicle createWaterVehicle();
}

// Step 5: Create Concrete Factories
class LandVehicleFactory implements VehicleFactory {
    @Override
    public LandVehicle createLandVehicle() {
        return new Car(); // Default Land Vehicle
    }

    @Override
    public WaterVehicle createWaterVehicle() {
        throw new UnsupportedOperationException("LandVehicleFactory cannot create Water Vehicles.");
    }
}

class WaterVehicleFactory implements VehicleFactory {
    @Override
    public LandVehicle createLandVehicle() {
        throw new UnsupportedOperationException("WaterVehicleFactory cannot create Land Vehicles.");
    }

    @Override
    public WaterVehicle createWaterVehicle() {
        return new Boat(); // Default Water Vehicle
    }
}

// Step 6: Test the Abstract Factory
public class Vehical {
    public static void main(String[] args) {
        // Create a Land Vehicle Factory
        VehicleFactory landFactory = new LandVehicleFactory();
        LandVehicle car = landFactory.createLandVehicle();
        car.start();  // Output: Car is starting.
        car.stop();   // Output: Car is stopping.

        // Create a Water Vehicle Factory
        VehicleFactory waterFactory = new WaterVehicleFactory();
        WaterVehicle boat = waterFactory.createWaterVehicle();
        boat.start();  // Output: Boat is starting.
        boat.stop();   // Output: Boat is stopping.

        // Testing unsupported operation
        try {
            landFactory.createWaterVehicle();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

        try {
            waterFactory.createLandVehicle();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
