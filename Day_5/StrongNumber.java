import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number to check: ");
        long num = input.nextLong();
        
        long originalNum = num;
        long temp = num;
        long totalSum = 0;
        
        if (num <= 0) {
            System.out.println(num + " is not a strong number.");
        } else {
            while (temp > 0) {
                long lastDigit = temp % 10;
                
                long factorial = 1;
                for (int i = 1; i <= lastDigit; i++) {
                    factorial *= i;
                }
                
                totalSum += factorial;
                temp /= 10;
            }
            
            if (totalSum == originalNum) {
                System.out.println(originalNum + " is a strong number.");
            } else {
                System.out.println(originalNum + " is not a strong number.");
            }
        }
        
        input.close();
    }
}

