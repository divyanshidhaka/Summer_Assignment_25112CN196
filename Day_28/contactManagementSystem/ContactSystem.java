import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phoneNumber + " | Email: " + email;
    }
}

class ContactManager {
    private List<Contact> contactList;

    public ContactManager() {
        this.contactList = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Success: Contact for '" + contact.getName() + "' added successfully.");
    }

    public void displayAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Your address book is empty.");
            return;
        }
        System.out.println("\n--- Contact List (" + contactList.size() + ") ---");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + ". " + contactList.get(i));
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        System.out.println("\n--- Search Results for \"" + name + "\" ---");
        for (Contact contact : contactList) {
            if (contact.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("- " + contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contacts found matching that name.");
        }
    }

    public void deleteContact(String name) {
        Contact toRemove = null;
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                toRemove = contact;
                break;
            }
        }

        if (toRemove != null) {
            contactList.remove(toRemove);
            System.out.println("Success: Contact for '" + name + "' has been removed.");
        } else {
            System.out.println("Error: Contact with name '" + name + "' not found.");
        }
    }
}

public class ContactSystem {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        manager.addContact(new Contact("John Doe", "123-456-7890", "john@example.com"));
        manager.addContact(new Contact("Alice Smith", "987-654-3210", "alice@example.com"));

        while (true) {
            System.out.println("\n=================================");
            System.out.println("    CONTACT MANAGEMENT SYSTEM    ");
            System.out.println("=================================");
            System.out.println("1. Add New Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Delete a Contact");
            System.out.println("5. Exit Application");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Email Address: ");
                    String email = scanner.nextLine();
                    
                    manager.addContact(new Contact(name, phone, email));
                    break;

                case 2:
                    manager.displayAllContacts();
                    break;

                case 3:
                    System.out.print("Enter name to search for: ");
                    String searchName = scanner.nextLine();
                    manager.searchContact(searchName);
                    break;

                case 4:
                    System.out.print("Enter the exact name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteContact(deleteName);
                    break;

                case 5:
                    System.out.println("Saving changes... Exiting Address Book. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 5.");
            }
        }
    }
}