package Builder;

public // Step 1: Define the Product
class meal {
    private String mainItem;
    private String drink;
    private String sideItem;

    public void setMainItem(String mainItem) {
        this.mainItem = mainItem; 
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setSideItem(String sideItem) {
        this.sideItem = sideItem;
    }

    @Override
    public String toString() {
        return "Meal [Main Item=" + mainItem + ", Drink=" + drink + ", Side Item=" + sideItem + "]";
    }
}

// Step 2: Define the Builder Interface
interface MealBuilder {
    void buildMainItem();
    void buildDrink();
    void buildSideItem();
    meal getMeal();
}

// Step 3: Create Concrete Builders
class VegMealBuilder implements MealBuilder {
    private meal meal = new meal();

    @Override
    public void buildMainItem() {
        meal.setMainItem("Veg Burger");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Orange Juice");
    }

    @Override
    public void buildSideItem() {
        meal.setSideItem("Salad");
    }

    @Override
    public meal getMeal() {
        return meal;
    }
}

class NonVegMealBuilder implements MealBuilder {
    private meal meal = new meal();

    @Override
    public void buildMainItem() {
        meal.setMainItem("Chicken Burger");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Coke");
    }

    @Override
    public void buildSideItem() {
        meal.setSideItem("Fries");
    }

    @Override
    public meal getMeal() {
        return meal;
    }
}

// Step 4: Define the Director
class MealDirector {
    private MealBuilder builder;

    public MealDirector(MealBuilder builder) {
        this.builder = builder;
    }

    public meal constructMeal() {
        builder.buildMainItem();
        builder.buildDrink();
        builder.buildSideItem();
        return builder.getMeal();
    }
}

// Step 5: Test the Builder Pattern
public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Create a Veg Meal
        MealBuilder vegMealBuilder = new VegMealBuilder();
        MealDirector director1 = new MealDirector(vegMealBuilder);
        meal vegMeal = director1.constructMeal();
        System.out.println("Veg Meal: " + vegMeal);

        // Create a Non-Veg Meal
        MealBuilder nonVegMealBuilder = new NonVegMealBuilder();
        MealDirector director2 = new MealDirector(nonVegMealBuilder);
        meal nonVegMeal = director2.constructMeal();
        System.out.println("Non-Veg Meal: " + nonVegMeal);
    }
}
 
