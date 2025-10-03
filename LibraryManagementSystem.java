import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // toString method for displaying book details
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

// Main class
public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add New Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // discard invalid input
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    // Add a new book
    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter author: ");
        String author = scanner.nextLine().trim();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();

        Book newBook = new Book(title, author, isbn);
        books.add(newBook);
        System.out.println("Book added successfully!");
    }

    // Display all books
    private static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\n--- Book List ---");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Search for a book by title
    private static void searchBook() {
        System.out.print("Enter title to search: ");
        String searchTitle = scanner.nextLine().trim().toLowerCase();
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTitle)) {
                System.out.println("Found: " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with title containing: " + searchTitle);
        }
    }

    // Remove a book by exact title
    private static void removeBook() {
        System.out.print("Enter title of the book to remove: ");
        String titleToRemove = scanner.nextLine().trim().toLowerCase();
        boolean removed = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().toLowerCase().equals(titleToRemove)) {
                books.remove(i);
                System.out.println("Book removed successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("No book found with exact title: " + titleToRemove);
        }
    }
}
