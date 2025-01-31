package Prototype;

import java.util.HashMap;
import java.util.Map;

// Step 1: Define the Prototype Interface
interface Shape extends Cloneable {
    Shape clone();
    void draw();
}

// Step 2: Create Concrete Prototypes
class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this.radius);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this.width, this.height);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width: " + width + " and height: " + height);
    }
}

// Step 3: Create a Prototype Registry
class ShapeRegistry {
    private Map<String, Shape> shapes = new HashMap<>();

    public void addShape(String key, Shape shape) {
        shapes.put(key, shape);
    }

    public Shape getShape(String key) {
        return shapes.get(key).clone();
    }
}

// Step 4: Test the Prototype Pattern
public class PrototypePatternDemo {
    public static void main(String[] args) {
        // Create a Shape Registry
        ShapeRegistry registry = new ShapeRegistry();

        // Add shapes to the registry
        registry.addShape("Circle", new Circle(5));
        registry.addShape("Rectangle", new Rectangle(10, 20));

        // Clone shapes from the registry
        Shape clonedCircle = registry.getShape("Circle");
        clonedCircle.draw();  // Output: Drawing a Circle with radius: 5

        Shape clonedRectangle = registry.getShape("Rectangle");
        clonedRectangle.draw();  // Output: Drawing a Rectangle with width: 10 and height: 20

        // Modify cloned shape
        Circle anotherCircle = (Circle) registry.getShape("Circle");
        anotherCircle.setRadius(10);
        anotherCircle.draw();  // Output: Drawing a Circle with radius: 10
    }
}
