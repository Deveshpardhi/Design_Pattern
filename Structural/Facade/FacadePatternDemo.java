package Facade;

// Step 1: Subsystem classes (complex components)

class TV {
    public void on() {
        System.out.println("TV is On");
    }

    public void off() {
        System.out.println("TV is Off");
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is On");
    }

    public void off() {
        System.out.println("DVD Player is Off");
    }

    public void play() {
        System.out.println("DVD is playing");
    }

    public void pause() {
        System.out.println("DVD is paused");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound system is On");
    }

    public void off() {
        System.out.println("Sound system is Off");
    }

    public void setVolume(int level) {
        System.out.println("Sound system volume is set to " + level);
    }
}

// Step 2: Facade class that simplifies the interface to the subsystems

class HomeTheaterFacade {
    private TV tv;
    private DVDPlayer dvdPlayer;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(TV tv, DVDPlayer dvdPlayer, SoundSystem soundSystem) {
        this.tv = tv;
        this.dvdPlayer = dvdPlayer;
        this.soundSystem = soundSystem;
    }

    // Unified method to start the home theater system
    public void watchMovie() {
        System.out.println("Get ready to watch a movie...");
        tv.on();
        soundSystem.on();
        soundSystem.setVolume(5); // Set volume level
        dvdPlayer.on();
        dvdPlayer.play();
    }

    // Unified method to turn off the home theater system
    public void endMovie() {
        System.out.println("Shutting down the home theater system...");
        dvdPlayer.pause();
        soundSystem.off();
        tv.off();
    }
}

// Step 3: Client using the Facade
public class FacadePatternDemo {
    public static void main(String[] args) {
        // Creating the subsystem objects
        TV tv = new TV();
        DVDPlayer dvdPlayer = new DVDPlayer();
        SoundSystem soundSystem = new SoundSystem();

        // Creating the facade object
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, dvdPlayer, soundSystem);

        // Using the simplified interface
        homeTheater.watchMovie();  // Client does not need to know the details of subsystems
        homeTheater.endMovie();
    }
}

