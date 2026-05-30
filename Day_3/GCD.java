import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        
        int n1 = num1;
        int n2 = num2;
        
        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        
        System.out.println("The GCD of " + n1 + " and " + n2 + " is: " + num1);
        
    }
}
