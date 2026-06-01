import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number to check: ");
        long num = input.nextLong();
        
        if (num <= 0) {
            System.out.println(num + " is not a perfect number.");
        } else {
            long sum = 0;
            
            for (long i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i; 
                }
            }
            
            if (sum == num) {
                System.out.println(num + " is a perfect number.");
            } else {
                System.out.println(num + " is not a perfect number.");
            }
        }
        
        input.close();
    }
}
