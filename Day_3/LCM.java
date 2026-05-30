import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        
        int a = num1;
        int b = num2;
        
        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        int gcd = num1;
        int lcm = (a / gcd) * b; 
        
        System.out.println("The LCM of " + a + " and " + b + " is: " + lcm);
        
        sc.close();
    }
}

