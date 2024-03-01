import java.util.List;

public class Librarian extends User {
    private Library library;

    public Librarian(String id, String name, Library library) {
        super(id, name);
        this.library = library;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Librarian manages " + library.getLibraryBooks().size() + " books");
    }

    public void addBook(Book book) {
        library.getLibraryBooks().add(book);
    }

    public void removeBook(Book book) {
        library.getLibraryBooks().remove(book); 
    }

    public void displayAllBooks() {
        library.displayAllBooks();
    }

    @Override
    public boolean login(String id) {

        return super.login(id);
    }

}
