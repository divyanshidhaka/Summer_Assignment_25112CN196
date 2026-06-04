import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
      
    System.out.print("Enter base (x): ");
    double x = input.nextDouble();
    System.out.print("Enter exponent (n): ");
    int n = input.nextInt();
        
    double originalBase = x;
    double result = 1.0;
    long exp = n; 
        
    if (exp < 0) {
        exp = -exp;
    }
        
    while (exp > 0) {
        if (exp % 2 == 1) {
            result *= x;
        }
        x *= x;       
        exp /= 2;     
    }
        
        if (n < 0) {
            result = 1.0 / result;
        }
        
    System.out.println(originalBase + " raised to the power of " + n + " is: " + result);
    input.close();
    }
}