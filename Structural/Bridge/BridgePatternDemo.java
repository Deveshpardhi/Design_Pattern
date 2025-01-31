package Bridge;

// Step 1: Define the Implementor interface (Color)
interface Color {
    void fill();
}

// Step 2: Implement the Concrete Implementors (specific colors)
class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Filling with Red color.");
    }
}

class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Filling with Green color.");
    }
}

class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Filling with Blue color.");
    }
}

// Step 3: Define the Abstraction (Shape)
abstract class Shape {
    protected Color color;

    // Constructor to initialize color
    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();  // Abstract method for drawing shapes
}

// Step 4: Create the Refined Abstractions (specific shapes)
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing Circle. ");
        color.fill();  // Delegate the filling to the color implementation
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing Square. ");
        color.fill();  // Delegate the filling to the color implementation
    }
}

// Step 5: Demonstrate the Bridge Pattern
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red());
        Shape greenSquare = new Square(new Green());
        Shape blueCircle = new Circle(new Blue());

        redCircle.draw();  // Output: Drawing Circle. Filling with Red color.
        greenSquare.draw();  // Output: Drawing Square. Filling with Green color.
        blueCircle.draw();  // Output: Drawing Circle. Filling with Blue color.
    }
}
