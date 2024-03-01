import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> libraryBooks = new ArrayList<>();
    private List<Book> rentedBooks = new ArrayList<>();

    // Геттер для списка книг в библиотеке
    public List<Book> getLibraryBooks() {
        return libraryBooks;
    }

    public void displayAllBooks() {
        if (libraryBooks.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : libraryBooks) {
                System.out.println(book);
            }
        }
    }
    
    // Геттер для списка арендованных книг
    public List<Book> getRentedBooks() {
        return rentedBooks;
    }


}
