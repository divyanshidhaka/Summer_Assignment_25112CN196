import java.util.Scanner;

public class FindFactorial {
    
    public static long findFactorial(int num) {
        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1; 
        }
        
        long factorial = 1; 
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        
        return factorial;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive number: ");
        int number = input.nextInt();
        
        long result = findFactorial(number);
        
        if (result != -1) {
            System.out.println("The factorial of " + number + " is: " + result);
        }
        
        input.close();
    }
}