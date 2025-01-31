package Builder;

// Step 1: Define the Product
class Laptop {
    private String processor;
    private String ram;
    private String storage;
    private String graphicsCard;

    // Setter methods for each component
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public String toString() {
        return "Laptop [Processor=" + processor + ", RAM=" + ram + ", Storage=" + storage + 
               ", Graphics Card=" + graphicsCard + "]";
    }
}

// Step 2: Define the Builder Interface
interface LaptopBuilder {
    void buildProcessor();
    void buildRam();
    void buildStorage();
    void buildGraphicsCard();
    Laptop getLaptop();
}

// Step 3: Create Concrete Builders
class GamingLaptopBuilder implements LaptopBuilder {
    private Laptop laptop = new Laptop();

    @Override
    public void buildProcessor() {
        laptop.setProcessor("Intel Core i9");
    }

    @Override
    public void buildRam() {
        laptop.setRam("32GB DDR4");
    }

    @Override
    public void buildStorage() {
        laptop.setStorage("1TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        laptop.setGraphicsCard("NVIDIA GeForce RTX 3080");
    }

    @Override
    public Laptop getLaptop() {
        return laptop;
    }
}

class OfficeLaptopBuilder implements LaptopBuilder {
    private Laptop laptop = new Laptop();

    @Override
    public void buildProcessor() {
        laptop.setProcessor("Intel Core i5");
    }

    @Override
    public void buildRam() {
        laptop.setRam("16GB DDR4");
    }

    @Override
    public void buildStorage() {
        laptop.setStorage("512GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        laptop.setGraphicsCard("Integrated Graphics");
    }

    @Override
    public Laptop getLaptop() {
        return laptop;
    }
}

// Step 4: Define the Director
class LaptopDirector {
    private LaptopBuilder builder;

    public LaptopDirector(LaptopBuilder builder) {
        this.builder = builder;
    }

    public Laptop constructLaptop() {
        builder.buildProcessor();
        builder.buildRam();
        builder.buildStorage();
        builder.buildGraphicsCard();
        return builder.getLaptop();
    }
}

// Step 5: Test the Builder Pattern
public class laptop {
    public static void main(String[] args) {
        // Build a Gaming Laptop
        LaptopBuilder gamingLaptopBuilder = new GamingLaptopBuilder();
        LaptopDirector director1 = new LaptopDirector(gamingLaptopBuilder);
        Laptop gamingLaptop = director1.constructLaptop();
        System.out.println("Gaming Laptop: " + gamingLaptop);

        // Build an Office Laptop
        LaptopBuilder officeLaptopBuilder = new OfficeLaptopBuilder();
        LaptopDirector director2 = new LaptopDirector(officeLaptopBuilder);
        Laptop officeLaptop = director2.constructLaptop();
        System.out.println("Office Laptop: " + officeLaptop);
    }
}
