import java.util.Scanner;

public class FindMaximum {

    public static int findMaximum(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = input.nextInt();
        
        System.out.print("Enter second number: ");
        int b = input.nextInt();
        
        int max = findMaximum(a, b);
        
        System.out.println("The maximum number between " + a + " and " + b + " is: " + max);
        
        input.close();
    }
}