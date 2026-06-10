import java.util.Scanner;

public class AddTwoNumber {

    public static int findSum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = input.nextInt();
        
        int result = findSum(num1, num2);
        
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + result);
        
        input.close();
    }
}