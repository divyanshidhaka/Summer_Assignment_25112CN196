import java.util.Scanner;

public class LargestPrimeFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long num = input.nextLong();
        
        if (num < 2) {
            System.out.println("Numbers less than 2 do not have prime factors.");
        } else {
            long originalNum = num;
            long maxPrime = -1;
            
            while (num % 2 == 0) {
                maxPrime = 2;
                num /= 2;
            }
            
            for (long i = 3; i * i <= num; i += 2) {
                while (num % i == 0) {
                    maxPrime = i;
                    num /= i;
                }
            }
            
            if (num > 2) {
                maxPrime = num;
            }
            
            System.out.println("The largest prime factor of " + originalNum + " is: " + maxPrime);
        }
        
        input.close();
    }
}

