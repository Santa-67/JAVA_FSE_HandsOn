
public class Main {
    public static void main(String[] args) {
        // Build a basic computer
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();

        // Build a gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setKeyboard("Mechanical")
                .setMouse("Gaming Mouse")
                .build();

        System.out.println("=== Basic Computer ===");
        basicComputer.showSpecs();

        System.out.println("\n=== Gaming Computer ===");
        gamingComputer.showSpecs();
    }
}
