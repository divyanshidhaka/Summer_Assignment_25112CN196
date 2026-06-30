import java.util.Scanner;

public class ArrayOperationsSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum size of the array: ");
        int maxSize = scanner.nextInt();
        
        int[] array = new int[maxSize];
        int currentSize = 0;

        while (true) {
            System.out.println("\n--- Array Operations Menu ---");
            System.out.println("1. Insert an Element");
            System.out.println("2. Delete an Element by Value");
            System.out.println("3. Search for an Element");
            System.out.println("4. Display Array");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    if (currentSize >= maxSize) {
                        System.out.println("Error: Array is full! Cannot insert more elements.");
                    } else {
                        System.out.print("Enter the integer value to insert: ");
                        int value = scanner.nextInt();
                        array[currentSize] = value;
                        currentSize++;
                        System.out.println("Successfully inserted " + value);
                    }
                    break;

                case 2:
                    if (currentSize == 0) {
                        System.out.println("Error: Array is empty! Nothing to delete.");
                    } else {
                        System.out.print("Enter the value to delete: ");
                        int target = scanner.nextInt();
                        int indexToDelete = -1;

                        for (int i = 0; i < currentSize; i++) {
                            if (array[i] == target) {
                                indexToDelete = i;
                                break;
                            }
                        }

                        if (indexToDelete == -1) {
                            System.out.println("Element not found in the array.");
                        } else {
                            for (int i = indexToDelete; i < currentSize - 1; i++) {
                                array[i] = array[i + 1];
                            }
                            currentSize--;
                            System.out.println("Successfully deleted " + target);
                        }
                    }
                    break;

                case 3:
                    if (currentSize == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        System.out.print("Enter the value to search for: ");
                        int searchTarget = scanner.nextInt();
                        boolean found = false;

                        for (int i = 0; i < currentSize; i++) {
                            if (array[i] == searchTarget) {
                                System.out.println("Element " + searchTarget + " found at index: " + i);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Element " + searchTarget + " not found in the array.");
                        }
                    }
                    break;

                case 4:
                    if (currentSize == 0) {
                        System.out.println("Array is currently empty: []");
                    } else {
                        System.out.print("Current Array: [");
                        for (int i = 0; i < currentSize; i++) {
                            System.out.print(array[i]);
                            if (i < currentSize - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("]");
                    }
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }
}
