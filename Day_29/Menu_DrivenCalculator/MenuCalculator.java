import java.util.Scanner;

public class MenuCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double num1, num2, result;

        while (true) {
           
            System.out.println("\n--- Menu-Driven Calculator ---");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Please select an option between 1 and 5.");
                continue;
            }

            System.out.print("Enter first number: ");
            num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();

            switch (choice) {
                case 1:
                    result = num1 + num2;
                    System.out.printf("Result: %.2f + %.2f = %.2f\n", num1, num2, result);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.printf("Result: %.2f - %.2f = %.2f\n", num1, num2, result);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.printf("Result: %.2f * %.2f = %.2f\n", num1, num2, result);
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        result = num1 / num2;
                        System.out.printf("Result: %.2f / %.2f = %.2f\n", num1, num2, result);
                    }
                    break;
            }
        }
        scanner.close();
    }
}
