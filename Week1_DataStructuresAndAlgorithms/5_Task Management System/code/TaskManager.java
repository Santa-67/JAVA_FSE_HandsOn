// TaskManager.java
public class TaskManager {
    private Node head;

    // Inner Node class
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Add task at the end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    // Search task by ID
    public Task searchTask(String id) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(id)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Display all tasks
    public void displayTasks() {
        Node temp = head;
        if (temp == null) {
            System.out.println("No tasks to display.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Delete task by ID
    public boolean deleteTask(String id) {
        if (head == null) return false;

        if (head.task.getTaskId().equals(id)) {
            head = head.next;
            return true;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.task.getTaskId().equals(id)) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }
}
