package Decorator;

// Step 1: Define the Component interface
interface Coffee {
    double cost();
    String ingredients();
}

// Step 2: Implement the ConcreteComponent class (Basic Coffee)
class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 5.0;
    }

    @Override
    public String ingredients() {
        return "Coffee";
    }
}

// Step 3: Implement the Decorator class (Abstract decorator)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public double cost() {
        return decoratedCoffee.cost();
    }

    public String ingredients() {
        return decoratedCoffee.ingredients();
    }
}

// Step 4: Implement the ConcreteDecorator classes (Add-ons like Milk, Sugar)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 1.0;  // Add cost for milk
    }

    @Override
    public String ingredients() {
        return decoratedCoffee.ingredients() + ", Milk";  // Add milk to ingredients list
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.5;  // Add cost for sugar
    }

    @Override
    public String ingredients() {
        return decoratedCoffee.ingredients() + ", Sugar";  // Add sugar to ingredients list
    }
}

// Step 5: Demonstrate the Decorator Pattern
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();  // Basic coffee

        System.out.println("Ingredients: " + coffee.ingredients());
        System.out.println("Cost: " + coffee.cost());

        // Add Milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println("\nIngredients: " + coffee.ingredients());
        System.out.println("Cost: " + coffee.cost());

        // Add Sugar to the coffee with Milk
        coffee = new SugarDecorator(coffee);
        System.out.println("\nIngredients: " + coffee.ingredients());
        System.out.println("Cost: " + coffee.cost());
    }
}

