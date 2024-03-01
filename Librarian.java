import java.util.List;

public class Librarian extends User {
    private List<Book> libraryBooks;

    public Librarian(String id, String name, List<Book> libraryBooks) {
        super(id, name);
        this.libraryBooks = libraryBooks;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Librarian manages " + libraryBooks.size() + " books");
    }

    public void addBook(Book book) {
        libraryBooks.add(book);
    }

    public void removeBook(Book book) {
        libraryBooks.remove(book);
    }

    // Getters and Setters
    public List<Book> getLibraryBooks() {
        return libraryBooks;
    }

    public void setLibraryBooks(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    //

    @Override
    public boolean login(String id) {
        // Можно добавить дополнительные проверки для библиотекаря
        return super.login(id);
    }

    public void displayAllBooks() {
        for (Book book : libraryBooks) {
            System.out.println(book);
        }
    }

}
