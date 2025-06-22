// RealImage.java
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + fileName);
        // Simulate time delay or remote call
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}
