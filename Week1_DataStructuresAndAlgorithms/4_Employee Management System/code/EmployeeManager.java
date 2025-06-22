// EmployeeManager.java
public class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee
    public boolean addEmployee(Employee emp) {
        if (size >= employees.length) {
            System.out.println("Employee array is full.");
            return false;
        }
        employees[size++] = emp;
        return true;
    }

    // Search by ID
    public Employee searchEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all
    public void displayAllEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete by ID
    public boolean deleteEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                // Shift remaining elements left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }
}
