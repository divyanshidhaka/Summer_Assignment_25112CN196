import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
       
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfAttempts = 0;
        int userGuess = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");
        
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                scanner.next(); 
                continue;
            }
            
            userGuess = scanner.nextInt();
            numberOfAttempts++;
            
            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Remember, the number is between 1 and 100!");
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("\nCongratulations! You found the number!");
                System.out.println("It took you " + numberOfAttempts + " attempts.");
            }
        }
        scanner.close();
    }
}