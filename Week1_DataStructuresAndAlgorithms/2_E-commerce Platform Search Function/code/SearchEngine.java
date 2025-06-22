import java.util.Arrays;
import java.util.Comparator;
public class SearchEngine{
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null; 
    }
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null; 
    }
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Tablet", "Electronics"),
            new Product(4, "Chair", "Furniture"),
            new Product(5, "Desk", "Furniture")
        };

        System.out.println("Linear Search:");
        Product foundLinear = linearSearch(products, "Tablet");
        System.out.println(foundLinear != null ? foundLinear : "Not Found");

        
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("Binary Search:");
        Product foundBinary = binarySearch(products, "Desk");
        System.out.println(foundBinary != null ? foundBinary : "Not Found");
    }
}
