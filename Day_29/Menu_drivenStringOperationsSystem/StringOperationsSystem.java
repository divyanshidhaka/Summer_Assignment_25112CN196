import java.util.Scanner;

public class StringOperationsSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your initial source string: ");
        String sourceString = scanner.nextLine();

        while (true) {
            System.out.println("\n--- Current String: \"" + sourceString + "\" ---");
            System.out.println("--- String Operations Menu ---");
            System.out.println("1. Find Length of the String");
            System.out.println("2. Reverse the String");
            System.out.println("3. Convert to Uppercase / Lowercase");
            System.out.println("4. Check if Palindrome");
            System.out.println("5. Concatenate (Append) another String");
            System.out.println("6. Change the Source String");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 7) {
                System.out.println("Exiting String Operations System. Goodbye!");
                break;
            }

            switch (choice) {
                case 1: // LENGTH
                    System.out.println("Length of the string: " + sourceString.length() + " characters.");
                    break;

                case 2: 
                    String reversed = new StringBuilder(sourceString).reverse().toString();
                    System.out.println("Reversed string: \"" + reversed + "\"");
                    break;

                case 3:
                    System.out.println("Uppercase: \"" + sourceString.toUpperCase() + "\"");
                    System.out.println("Lowercase: \"" + sourceString.toLowerCase() + "\"");
                    break;

                case 4:
                    String cleanString = sourceString.replaceAll("\\s+", "").toLowerCase();
                    String revClean = new StringBuilder(cleanString).reverse().toString();

                    if (cleanString.equals(revClean)) {
                        System.out.println("Result: Yes, it is a palindrome!");
                    } else {
                        System.out.println("Result: No, it is not a palindrome.");
                    }
                    break;

                case 5:
                    System.out.print("Enter string to append: ");
                    String appendStr = scanner.nextLine();
                    sourceString = sourceString.concat(appendStr); // Updates the active string
                    System.out.println("Updated String: \"" + sourceString + "\"");
                    break;

                case 6:
                    System.out.print("Enter your new source string: ");
                    sourceString = scanner.nextLine();
                    System.out.println("Source string updated successfully.");
                    break;

                default:
                    System.out.println("Invalid choice! Please pick a number between 1 and 7.");
            }
        }
        scanner.close();
    }
}