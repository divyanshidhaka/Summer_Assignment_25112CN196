import java.util.Scanner;

public class SumOfDigits{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long num = input.nextLong();

        long i = num;
        long sum = 0;

        while(i>0){
            long lastDigit =i % 10;
            sum = sum + lastDigit;
            i = i / 10; 
        }
        System.out.println("The Sum of Digit of a number "+num+" is "+sum);
    }
}