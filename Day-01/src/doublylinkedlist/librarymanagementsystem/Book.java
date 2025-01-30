package doublylinkedlist.librarymanagementsystem;

class Book {
    String title, author, genre;
    int bookId;
    boolean available;
    Book next, prev;

    Book(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}
