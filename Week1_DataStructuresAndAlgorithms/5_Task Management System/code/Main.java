// Main.java
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task("T001", "Write Report", "Pending"));
        manager.addTask(new Task("T002", "Fix Bugs", "In Progress"));
        manager.addTask(new Task("T003", "Deploy App", "Completed"));

        System.out.println("All Tasks:");
        manager.displayTasks();

        System.out.println("\nSearching for T002:");
        System.out.println(manager.searchTask("T002"));

        System.out.println("\nDeleting T001...");
        manager.deleteTask("T001");

        System.out.println("\nTasks after deletion:");
        manager.displayTasks();
    }
}
