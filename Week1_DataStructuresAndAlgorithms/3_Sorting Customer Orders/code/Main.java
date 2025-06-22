// Main.java
public class Main {
    public static void main(String[] args) {
        Order[] orders = {
                new Order("O101", "Alice", 450.50),
                new Order("O102", "Bob", 1200.00),
                new Order("O103", "Charlie", 250.75),
                new Order("O104", "Diana", 850.30)
        };

        System.out.println("Original Orders:");
        OrderSorter.printOrders(orders);

        System.out.println("\nSorted with Bubble Sort:");
        OrderSorter.bubbleSort(orders);
        OrderSorter.printOrders(orders);

        Order[] quickSortOrders = {
                new Order("O101", "Alice", 450.50),
                new Order("O102", "Bob", 1200.00),
                new Order("O103", "Charlie", 250.75),
                new Order("O104", "Diana", 850.30)
        };

        System.out.println("\nSorted with Quick Sort:");
        OrderSorter.quickSort(quickSortOrders, 0, quickSortOrders.length - 1);
        OrderSorter.printOrders(quickSortOrders);
    }
}
