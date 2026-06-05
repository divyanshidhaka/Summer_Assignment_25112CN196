import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = input.nextInt();
        
    if (num < 0) {
        System.out.println("Factorial is not defined for negative numbers.");
    } else {
        long result = factorial(num);
        System.out.println("Factorial of " + num + " is: " + result);
    }
    input.close();
    }
    
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}