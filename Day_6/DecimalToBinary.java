import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a decimal number: ");
        int decimal = input.nextInt();
        
        if (decimal == 0) {
            System.out.println("Binary representation: 0");
        } else {
            int temp = decimal;
            String binary = "";
            
            while (temp > 0) {
                int remainder = temp % 2;
                binary = remainder + binary;
                temp = temp / 2;
            }
            
            System.out.println("Binary representation of " + decimal + " is: " + binary);
        }
        
        input.close();
    }
}