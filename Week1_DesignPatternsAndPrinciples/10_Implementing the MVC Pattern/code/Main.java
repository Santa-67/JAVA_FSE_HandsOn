// Main.java
public class Main {
    public static void main(String[] args) {
        // Step 1: Create the model
        Student student = new Student();
        student.setName("Alice");
        student.setId("S123");
        student.setGrade("A");

        // Step 2: Create the view
        StudentView view = new StudentView();

        // Step 3: Create the controller
        StudentController controller = new StudentController(student, view);

        // Step 4: Display initial details
        controller.updateView();

        // Step 5: Update student data
        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");

        // Step 6: Display updated details
        System.out.println("\nAfter update:");
        controller.updateView();
    }
}
