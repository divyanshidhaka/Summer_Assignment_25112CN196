import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the nth term to find: ");
    int n = input.nextInt();
        
    if (n <= 0) {
    System.out.println("Please enter a positive position greater than 0.");
    } else {
    long result = fibonacci(n);
    System.out.println("The " + n + "th term of the Fibonacci series is: " + result);
    }
    input.close();
    }
    
    public static long fibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}