import java.util.ArrayList;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Создание книг
        library.getLibraryBooks().add(new Book("1984", "George Orwell", "1234567890"));
        library.getLibraryBooks().add(new Book("To Kill a Mockingbird", "Harper Lee", "2345678901"));
        library.getLibraryBooks().add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "3456789012"));
        library.getLibraryBooks().add(new Book("Moby Dick", "Herman Melville", "4567890123"));

        // Создание пользователей
        User user = new User("U1001", "Alice");
        Librarian librarian = new Librarian("L1001", "Bob", new ArrayList<>());


        // Вывод информации о пользователях
        //user.displayInfo(); // Вывод информации о пользователе
        //librarian.displayInfo(); // Вывод информации о библиотекаре

        //
        System.out.println("Enter User ID for login:");
        String userId = scanner.nextLine();

        if (user.login(userId)) {
            boolean done = false;
            while (!done) {
                System.out.println("Available actions: \n1) Borrow book\n2) Return book\n3) Display all books\n4) Exit");
                int action = scanner.nextInt();
                scanner.nextLine(); // очистить буфер

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
        } else {
            System.out.println("Invalid ID.");
        }

        scanner.close();
    }
}