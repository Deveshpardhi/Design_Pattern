// Step 1: Define the Transport interface
interface Transport {
    void deliver();
}

// Step 2: Create concrete implementations of the Transport interface
class Car implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by land using a Car.");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea using a Ship.");
    }
}

class Plane implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by air using a Plane.");
    }
}

// Step 3: Create the Factory class
class TransportFactory {
    public static Transport getTransport(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "ship":
                return new Ship();
            case "plane":
                return new Plane();
            default:
                throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }
}

// Step 4: Test the Factory Design Pattern
public class Main {
    public static void main(String[] args) {
        // Create transport objects using the factory
        Transport car = TransportFactory.getTransport("car");
        Transport ship = TransportFactory.getTransport("ship");
        Transport plane = TransportFactory.getTransport("plane");

        // Call the deliver method
        car.deliver();  // Output: Delivering by land using a Car.
        ship.deliver(); // Output: Delivering by sea using a Ship.
        plane.deliver(); // Output: Delivering by air using a Plane.
    }
}
