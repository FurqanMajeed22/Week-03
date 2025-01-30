package doublylinkedlist.librarymanagementsystem;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        library.addBook("Book1", "Author1", "Genre1", 101, true);
        library.addBook("Book2", "Author2", "Genre2", 102, false);
        library.addBook("Book3", "Author3", "Genre3", 103, true);

        library.displayBooks();

        library.displayBooksReverse();

        library.searchBook("Book1", "");

        library.removeBook(102);
        library.displayBooks();

        library.updateAvailability(103, false);
        library.displayBooks();

        System.out.println("Total Books: " + library.countBooks());
    }
}
