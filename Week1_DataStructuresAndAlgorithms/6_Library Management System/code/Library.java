// Library.java
import java.util.Arrays;
import java.util.Comparator;

public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Library is full.");
        }
    }

    // Linear search by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Sort books by title
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, Comparator.comparing(Book::getTitle));
    }

    // Binary search by title
    public Book binarySearchByTitle(String title) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public void displayBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
}
