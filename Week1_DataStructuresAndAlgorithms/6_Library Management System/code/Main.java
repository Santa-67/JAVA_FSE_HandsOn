// Main.java
public class Main {
    public static void main(String[] args) {
        Library library = new Library(5);

        library.addBook(new Book("B001", "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book("B002", "Atomic Habits", "James Clear"));
        library.addBook(new Book("B003", "1984", "George Orwell"));

        System.out.println("All Books:");
        library.displayBooks();

        // Linear Search
        System.out.println("\nLinear Search for '1984':");
        System.out.println(library.linearSearchByTitle("1984"));

        // Sort before Binary Search
        library.sortBooksByTitle();

        // Binary Search
        System.out.println("\nBinary Search for 'Atomic Habits':");
        System.out.println(library.binarySearchByTitle("Atomic Habits"));
    }
}
