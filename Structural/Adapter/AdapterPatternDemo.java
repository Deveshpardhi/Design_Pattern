package Adapter;

// Step 1: Define the Target Interface (MediaPlayer)
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Step 2: Create the Adaptee class (legacy code that can only play video)
class VideoPlayer {
    public void playVideo(String videoType, String fileName) {
        System.out.println("Playing video file. Name: " + fileName + ", Type: " + videoType);
    }
}

// Step 3: Create the Adapter class that adapts the VideoPlayer to the MediaPlayer interface
class MediaAdapter implements MediaPlayer {
    private VideoPlayer videoPlayer;

    // Constructor that adapts the media type to VideoPlayer
    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            videoPlayer = new VideoPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            videoPlayer.playVideo(audioType, fileName);
        }
    }
}

// Step 4: Concrete class that implements MediaPlayer (AudioPlayer)
class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // Play mp3 directly
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing audio file. Name: " + fileName);
        }
        // If audioType is vlc or mp4, use MediaAdapter
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        // If the media type is unsupported
        else {
            System.out.println("Invalid media. " + audioType + " format not supported.");
        }
    }
}

// Step 5: Client class demonstrating the use of AudioPlayer
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        // Playing mp3 audio file
        audioPlayer.play("mp3", "beyond the horizon.mp3");

        // Playing vlc video file using adapter
        audioPlayer.play("vlc", "far far away.vlc");

        // Playing mp4 video file using adapter
        audioPlayer.play("mp4", "alone.mp4");

        // Trying to play an unsupported file type
        audioPlayer.play("avi", "mind me.avi");
    }
}
