// Inventory.java
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products = new HashMap<>();

    // Add product
    public boolean addProduct(Product product) {
        if(products.containsKey(product.getProductId())) {
            return false; // Product already exists
        }
        products.put(product.getProductId(), product);
        return true;
    }

    // Update product
    public boolean updateProduct(Product product) {
        if(!products.containsKey(product.getProductId())) {
            return false; // Product does not exist
        }
        products.put(product.getProductId(), product);
        return true;
    }

    // Delete product
    public boolean deleteProduct(String productId) {
        if(!products.containsKey(productId)) {
            return false; // Product does not exist
        }
        products.remove(productId);
        return true;
    }

    // Get product by ID
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    // Display all products
    public void displayProducts() {
        for(Product product : products.values()) {
            System.out.println(product);
        }
    }
}
