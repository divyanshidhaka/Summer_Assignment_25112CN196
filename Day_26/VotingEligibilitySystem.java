import java.util.Scanner;

public class VotingEligibilitySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Voting Eligibility System ===");
        System.out.print("Please enter your age: ");
        
        if (scanner.hasNextInt()) {
            int age = scanner.nextInt();
            
            if (age < 0 || age > 120) {
                System.out.println("Error: Please enter a realistic age.");
            } else if (age >= 18) {
                System.out.println("Status: Eligible to vote! Please register if you haven't already.");
            } else {
                int yearsLeft = 18 - age;
                System.out.println("Status: Not eligible to vote yet.");
                System.out.println("You will be eligible in " + yearsLeft + " year(s).");
            }
        } else {
            System.out.println("Error: Invalid input. Age must be a whole number.");
        }
        scanner.close();
        System.out.println("=================================");
    }
}