import java.util.Scanner;
public class ReverseANumber {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = input.nextLong();

        long i = num;
        long reversedNum = 0;

        while(i>0){
            long lastDigit = i % 10;
            reversedNum = (reversedNum*10) + lastDigit;
            i = i / 10;
        }
        if(num<0){
            reversedNum = -reversedNum;
        }
        System.out.println("The reverse of "+num+" is " +reversedNum);

    }
}
