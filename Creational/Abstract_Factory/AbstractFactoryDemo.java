package Abstract_Factory;

// Step 1: Define Abstract Product interfaces
interface Button {
    void render();
}

interface CheckBox {
    void toggle();
}

// Step 2: Create Concrete Product classes for each family
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button.");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac Button.");
    }
}

class WindowsCheckBox implements CheckBox {
    @Override
    public void toggle() {
        System.out.println("Toggling Windows CheckBox.");
    }
}

class MacCheckBox implements CheckBox {
    @Override
    public void toggle() {
        System.out.println("Toggling Mac CheckBox.");
    }
}

// Step 3: Define Abstract Factory
interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

// Step 4: Create Concrete Factories
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

// Step 5: Client Code
public class AbstractFactoryDemo {
    private Button button;
    private CheckBox checkBox;

    public AbstractFactoryDemo(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void render() {
        button.render();
        checkBox.toggle();
    }

    public static void main(String[] args) {
        // Using Windows GUI Factory
        GUIFactory windowsFactory = new WindowsFactory();
        AbstractFactoryDemo windowsGUI = new AbstractFactoryDemo(windowsFactory);
        windowsGUI.render();

        // Using Mac GUI Factory
        GUIFactory macFactory = new MacFactory();
        AbstractFactoryDemo macGUI = new AbstractFactoryDemo(macFactory);
        macGUI.render();
    }
}
