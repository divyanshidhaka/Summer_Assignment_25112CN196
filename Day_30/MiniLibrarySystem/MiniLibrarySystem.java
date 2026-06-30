import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String accessionNumber;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String accessionNumber, String title, String author) {
        this.accessionNumber = accessionNumber;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getAccessionNumber() { return accessionNumber; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Issued";
        return String.format("Acc No: %-8s | Title: %-25s | Author: %-20s | Status: [%s]", 
                accessionNumber, title, author, status);
    }
}

public class MiniLibrarySystem {
    private static ArrayList<Book> catalog = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        catalog.add(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        catalog.add(new Book("B002", "1984", "George Orwell"));
        catalog.add(new Book("B003", "To Kill a Mockingbird", "Harper Lee"));

        while (true) {
            System.out.println("\n===== Mini Library System Menu =====");
            System.out.println("1. Add a New Book to Catalog");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Issue a Book (Check-out)");
            System.out.println("5. Return a Book (Check-in)");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 6) {
                System.out.println("Closing the library application. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayCatalog();
                    break;
                case 3:
                    searchBookByTitle();
                    break;
                case 4:
                    issueBook();
                    break;
                case 5:
                    returnBook();
                    break;
                default:
                    System.out.println("Invalid selection! Please input an option between 1 and 6.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Unique Accession Number (e.g., B004): ");
        String accNum = scanner.nextLine().trim();

        if (findBookByAccNumber(accNum) != null) {
            System.out.println("Error: A book with this Accession Number already exists.");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine().trim();

        catalog.add(new Book(accNum, title, author));
        System.out.println("Book successfully catalogs and added to shelf.");
    }

    private static void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The library catalog is currently empty.");
            return;
        }
        System.out.println("\n----------------------------------- LIBRARY CATALOG -----------------------------------");
        for (Book b : catalog) {
            System.out.println(b);
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void searchBookByTitle() {
        System.out.print("Enter partial or full book title to search: ");
        String searchTitle = scanner.nextLine().toLowerCase().trim();
        boolean found = false;

        System.out.println("\n--- Search Results ---");
        for (Book b : catalog) {
            if (b.getTitle().toLowerCase().contains(searchTitle)) {
                System.out.println(b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found with that title.");
        }
    }

    private static void issueBook() {
        System.out.print("Enter the Accession Number of the book to issue: ");
        String accNum = scanner.nextLine().trim();
        Book book = findBookByAccNumber(accNum);

        if (book == null) {
            System.out.println("Error: Book not found in catalog.");
        } else if (!book.isAvailable()) {
            System.out.println("Sorry, \"" + book.getTitle() + "\" is already checked out.");
        } else {
            book.setAvailable(false);
            System.out.println("Success! \"" + book.getTitle() + "\" has been checked out.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter the Accession Number of the book being returned: ");
        String accNum = scanner.nextLine().trim();
        Book book = findBookByAccNumber(accNum);

        if (book == null) {
            System.out.println("Error: This book does not belong to our catalog.");
        } else if (book.isAvailable()) {
            System.out.println("Strange... This book was already marked as available on shelves.");
        } else {
            book.setAvailable(true);
            System.out.println("Success! \"" + book.getTitle() + "\" has been returned and checked in.");
        }
    }

    private static Book findBookByAccNumber(String accNum) {
        for (Book b : catalog) {
            if (b.getAccessionNumber().equalsIgnoreCase(accNum)) {
                return b;
            }
        }
        return null;
    }
}
