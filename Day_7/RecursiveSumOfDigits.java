import java.util.Scanner;

public class RecursiveSumOfDigits {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number: ");
    long num = input.nextLong();
        
    long absoluteNum = Math.abs(num);
    long result = sumOfDigits(absoluteNum);
        
    System.out.println("The sum of digits of " + num + " is: " + result);
    input.close();
    }
    
    public static long sumOfDigits(long n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }
}