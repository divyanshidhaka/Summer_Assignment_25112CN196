import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }
    
    public void setBorrowed(boolean borrowed) { this.isBorrowed = borrowed; }

    @Override
    public String toString() {
        String status = isBorrowed ? "Borrowed" : "Available";
        return "[" + isbn + "] " + title + " by " + author + " | Status: " + status;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Success: Book added to inventory.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library inventory is currently empty.");
            return;
        }
        System.out.println("\n--- Library Inventory ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching books found for title: \"" + title + "\"");
        }
    }

    public void checkOutBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isBorrowed()) {
                    System.out.println("Error: Sorry, this book is already checked out.");
                } else {
                    book.setBorrowed(true);
                    System.out.println("Success: You have checked out \"" + book.getTitle() + "\".");
                }
                return;
            }
        }
        System.out.println("Error: Book with ISBN " + isbn + " not found.");
    }

    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isBorrowed()) {
                    System.out.println("Warning: This book was already present in the library.");
                } else {
                    book.setBorrowed(false);
                    System.out.println("Success: \"" + book.getTitle() + "\" returned successfully.");
                }
                return;
            }
        }
        System.out.println("Error: Invalid ISBN. This book does not belong to our library.");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "101"));
        library.addBook(new Book("1984", "George Orwell", "102"));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "103"));

        while (true) {
            System.out.println("\n=================================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM    ");
            System.out.println("=================================");
            System.out.println("1. Add a Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Check Out a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. Exit App");
            System.out.print("Choose an option (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter ISBN to check out: ");
                    String checkOutIsbn = scanner.nextLine();
                    library.checkOutBook(checkOutIsbn);
                    break;

                case 5:
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn);
                    break;

                case 6:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid selection! Please enter a number between 1 and 6.");
            }
        }
    }
}