import java.util.Scanner;

public class ATMSimulation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int correctPin = 1234;
        double balance = 5000.00;
        boolean isAuthenticated = false;
        
        System.out.println("=== Welcome to the JavaTech Bank ATM ===");
        
        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Enter your 4-digit PIN: ");
            if (scanner.hasNextInt()) {
                int enteredPin = scanner.nextInt();
                if (enteredPin == correctPin) {
                    isAuthenticated = true;
                    break;
                } else {
                    System.out.println("Incorrect PIN. Attempts used: " + attempts + "/3");
                }
            } else {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.next();
            }
        }
        
        if (!isAuthenticated) {
            System.out.println("\nToo many incorrect attempts. Your card has been blocked for safety.");
            scanner.close();
            return;
        }
        
        System.out.println("\nAuthentication Successful!");
        int choice = 0;
        
        while (choice != 4) {
            System.out.println("\n--- ATM MAIN MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit / Eject Card");
            System.out.print("Choose an option (1-4): ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid option number.");
                scanner.next();
                continue;
            }
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is: $%.2f\n", balance);
                    break;
                    
                case 2:
                    System.out.print("Enter deposit amount: $");
                    if (scanner.hasNextDouble()) {
                        double depositAmount = scanner.nextDouble();
                        if (depositAmount > 0) {
                            balance += depositAmount;
                            System.out.printf("Successfully deposited $%.2f\n", depositAmount);
                            System.out.printf("New balance: $%.2f\n", balance);
                        } else {
                            System.out.println("Deposit amount must be greater than zero.");
                        }
                    } else {
                        System.out.println("Invalid amount entered.");
                        scanner.next();
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    if (scanner.hasNextDouble()) {
                        double withdrawAmount = scanner.nextDouble();
                        if (withdrawAmount <= 0) {
                            System.out.println("Withdrawal amount must be greater than zero.");
                        } else if (withdrawAmount > balance) {
                            System.out.println("Transaction Failed: Insufficient funds.");
                            System.out.printf("Your maximum available balance is: $%.2f\n", balance);
                        } else {
                            balance -= withdrawAmount;
                            System.out.printf("Successfully withdrew $%.2f\n", withdrawAmount);
                            System.out.printf("Remaining balance: $%.2f\n", balance);
                        }
                    } else {
                        System.out.println("Invalid amount entered.");
                        scanner.next();
                    }
                    break;
                    
                case 4:
                    System.out.println("\nThank you for using our ATM. Please take your card! Goodbye.");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 4.");
            }
        }
        
        scanner.close();
    }
}