import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a binary number: ");
        long binary = input.nextLong();
        
        long temp = binary;
        long decimalValue = 0;
        int base = 1;
        boolean isValid = true;
        
        while (temp > 0) {
            long lastDigit = temp % 10;
            
            if (lastDigit != 0 && lastDigit != 1) {
                isValid = false;
                break;
            }
            
            decimalValue += lastDigit * base;
            base = base * 2;
            temp = temp / 10;
        }
        
        if (!isValid) {
            System.out.println("Invalid input! Please enter a valid binary number containing only 0 and 1.");
        } else {
            System.out.println("Decimal representation of " + binary + " is: " + decimalValue);
        }
        
        input.close();
    }
}
