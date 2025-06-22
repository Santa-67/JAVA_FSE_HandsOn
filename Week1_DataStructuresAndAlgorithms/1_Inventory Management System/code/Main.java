// Main.java
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Mouse", 50, 19.99);
        Product p3 = new Product("P003", "Keyboard", 30, 49.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        System.out.println("Inventory after adding products:");
        inventory.displayProducts();

        // Update product quantity
        p1.setQuantity(8);
        inventory.updateProduct(p1);

        System.out.println("\nInventory after updating Laptop quantity:");
        inventory.displayProducts();

        // Delete product
        inventory.deleteProduct("P002");

        System.out.println("\nInventory after deleting Mouse:");
        inventory.displayProducts();

        // Get a product
        System.out.println("\nGet product P003:");
        System.out.println(inventory.getProduct("P003"));
    }
}
