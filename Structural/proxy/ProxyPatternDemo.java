package proxy;

// Step 1: Subject interface
interface Image {
    void display();
}

// Step 2: RealSubject (Heavy object)
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(); // Simulate time/resource-intensive loading
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName + " from disk...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Step 3: Proxy (Virtual Proxy)
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            // Lazily create and load the RealImage only when display is called
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// Step 4: Client
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image is loaded and displayed only when needed
        System.out.println("Displaying image1 first time:");
        image1.display(); // Loading happens here

        System.out.println("\nDisplaying image1 again:");
        image1.display(); // Loading is skipped, as the image is already loaded

        System.out.println("\nDisplaying image2 first time:");
        image2.display(); // Loading happens here
    }
}
