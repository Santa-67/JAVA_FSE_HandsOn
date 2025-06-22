// Main.java
public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee("E101", "Alice", "Developer", 60000));
        manager.addEmployee(new Employee("E102", "Bob", "Manager", 80000));
        manager.addEmployee(new Employee("E103", "Charlie", "Tester", 50000));

        System.out.println("All Employees:");
        manager.displayAllEmployees();

        System.out.println("\nSearching for E102:");
        System.out.println(manager.searchEmployee("E102"));

        System.out.println("\nDeleting E101:");
        manager.deleteEmployee("E101");

        System.out.println("\nEmployees after deletion:");
        manager.displayAllEmployees();
    }
}
