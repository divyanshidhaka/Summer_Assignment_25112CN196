import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Name: %-20s | Qty: %-6d | Price: $%.2f", id, name, quantity, price);
    }
}

public class InventoryManagementSystem {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add New Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Update Product Stock / Price");
            System.out.println("4. Delete a Product");
            System.out.println("5. Search Product by ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 6) {
                System.out.println("Exiting Inventory System. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayInventory();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter Product ID (Integer): ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (findProductById(id) != null) {
            System.out.println("Error: A product with this ID already exists.");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price per Unit: ");
        double price = scanner.nextDouble();

        inventory.add(new Product(id, name, quantity, price));
        System.out.println("Product added successfully!");
    }

    private static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("The inventory is completely empty.");
            return;
        }
        System.out.println("\n----------------- CURRENT INVENTORY -----------------");
        for (Product p : inventory) {
            System.out.println(p);
        }
        System.out.println("-----------------------------------------------------");
    }

    private static void updateProduct() {
        System.out.print("Enter the ID of the product to update: ");
        int id = scanner.nextInt();
        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Modifying: " + product.getName());
        System.out.println("1. Update Quantity Only");
        System.out.println("2. Update Price Only");
        System.out.println("3. Update Both");
        System.out.print("Select an option: ");
        int opt = scanner.nextInt();

        if (opt == 1 || opt == 3) {
            System.out.print("Enter new quantity: ");
            product.setQuantity(scanner.nextInt());
        }
        if (opt == 2 || opt == 3) {
            System.out.print("Enter new price: ");
            product.setPrice(scanner.nextDouble());
        }
        System.out.println("Product metrics updated successfully.");
    }

    private static void deleteProduct() {
        System.out.print("Enter the ID of the product to delete: ");
        int id = scanner.nextInt();
        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
        } else {
            inventory.remove(product);
            System.out.println("Successfully removed \"" + product.getName() + "\" from tracking.");
        }
    }

    private static void searchProduct() {
        System.out.print("Enter Product ID to look up: ");
        int id = scanner.nextInt();
        Product product = findProductById(id);

        if (product == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println("\nMatch Found:");
            System.out.println(product);
        }
    }

    private static Product findProductById(int id) {
        for (Product p : inventory) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}