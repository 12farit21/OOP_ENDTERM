import java.util.ArrayList;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Создание книг
        library.getLibraryBooks().add(new Book("1984", "George Orwell", "1234547890"));
        library.getLibraryBooks().add(new Book("To Kill a Mockingbird", "Harper Lee", "2345618901"));
        library.getLibraryBooks().add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "3456781012"));
        library.getLibraryBooks().add(new Book("Moby Dick", "Herman Melville", "4567190123"));

        // Создание пользователей
        User user = new User("U1001", "Ahmat");
        Librarian librarian = new Librarian("L1001", "Bob", library);



        // Вывод информации о пользователях
        //user.displayInfo(); 
        //librarian.displayInfo(); 

        //
        System.out.println("Enter User ID for login:");
        String userId = scanner.nextLine();

        if (user.login(userId)) {
            boolean done = false;
            while (!done) {
                System.out.println("Available actions: \n1) Borrow book\n2) Return book\n3) Display all books\n4) Exit");
                int action = scanner.nextInt();
                scanner.nextLine(); 

                switch (action) {
                    case 1:
                        System.out.println("Enter the title of the book to borrow:");
                        String borrowTitle = scanner.nextLine();
                        user.borrowBookFromLibrary(borrowTitle, library);
                        break;
                    case 2:
                        System.out.println("Enter the title of the book to return:");
                        String returnTitle = scanner.nextLine();
                        user.returnBookToLibrary(returnTitle, library);
                        break;
                    case 3:
                        library.displayAllBooks();
                        break;
                    case 4:
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid action.");
                }
            }
        } 

                
        else if (librarian.login(userId)) {
            boolean done = false;
            while (!done) {
                System.out.println("Available actions for librarian: \n1) Add new book\n2) Remove book\n3) Display all books\n4) Exit");
                int action = scanner.nextInt();
                scanner.nextLine(); 

                switch (action) {
                    case 1:
                        System.out.println("Enter book title:");
                        String title = scanner.nextLine();
                        System.out.println("Enter book author:");
                        String author = scanner.nextLine();
                        System.out.println("Enter book ISBN:");
                        String isbn = scanner.nextLine();

                        Book newBook = new Book(title, author, isbn);
                        librarian.addBook(newBook);
                        System.out.println("Book added: " + newBook);
                        break;

                    case 2:
                        System.out.println("Enter book title to remove:");
                        String removeTitle = scanner.nextLine();

                        // Поиск и удаление книги
                        boolean removed = false;
                        for (Book book : library.getLibraryBooks()) {
                            if (book.getTitle().equalsIgnoreCase(removeTitle)) {
                                library.getLibraryBooks().remove(book);
                                System.out.println("Book removed: " + book);
                                removed = true;
                                break;
                            }
                        }
                        if (!removed) {
                            System.out.println("Book not found.");
                        }


                    case 3:
                        librarian.displayAllBooks();
                        break;

                    case 4:
                        done = true;
                        break;

                    default:
                        System.out.println("Invalid action.");
                }
            }
        }

        else {
            System.out.println("Invalid ID.");
        }

        scanner.close();
    }
}