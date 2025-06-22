// Main.java
public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature.jpg");

        // Image will be loaded from remote server
        System.out.println("First display call:");
        image1.display();

        // Image is already loaded; no remote fetch
        System.out.println("\nSecond display call:");
        image1.display();
    }
}
