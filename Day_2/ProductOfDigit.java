import java.util.Scanner;

public class ProductOfDigit {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = input.nextLong();

        long i = num;
        long product = 1;

        while(i>0){
            long lastDigit = i % 10;
            product = product*lastDigit;
            i = i / 10;
        }
        
        System.out.println("The product of digits of number "+num+" is " +product);

    }
}
