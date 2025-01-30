package doublylinkedlist.librarymanagementsystem;

class Library {
    Book head, tail;

    void addBook(String title, String author, String genre, int bookId, boolean available) {
        Book newBook = new Book(title, author, genre, bookId, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    void removeBook(int bookId) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    void displayBooks() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.bookId + " " + (temp.available ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.bookId + " " + (temp.available ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    void searchBook(String title, String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equals(title) || temp.author.equals(author)) {
                System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.bookId + " " + (temp.available ? "Available" : "Not Available"));
            }
            temp = temp.next;
        }
    }

    void updateAvailability(int bookId, boolean available) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.available = available;
                return;
            }
            temp = temp.next;
        }
    }

    int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
