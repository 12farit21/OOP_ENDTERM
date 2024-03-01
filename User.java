import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private List<Book> borrowedBooks;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }


    public void displayInfo() {
        System.out.println("User ID: " + id + ", Name: " + name);
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //
    public boolean login(String id) {
        return this.id.equals(id);
    }


    public void borrowBookFromLibrary(String bookTitle, Library library) {
        for (Book book : library.getLibraryBooks()) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                borrowedBooks.add(book);
                library.getRentedBooks().add(book);
                library.getLibraryBooks().remove(book);
                System.out.println("Book borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found or not available.");
    }

    public void returnBookToLibrary(String bookTitle, Library library) {
    for (Book book : borrowedBooks) {
        if (book.getTitle().equalsIgnoreCase(bookTitle)) {
            borrowedBooks.remove(book);
            library.getRentedBooks().remove(book);
            library.getLibraryBooks().add(book);
            System.out.println("Book returned: " + book.getTitle());
            return;
        }
    }
    System.out.println("You don't have this book.");
}

    
}