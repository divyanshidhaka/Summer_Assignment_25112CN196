import java.util.Scanner;
public class ArmstrongNum {
    public static void main(String[] args) {
        
        int num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        num = input.nextInt();

        long temp =num;
        long originalNum = num;
        int digit = 0;
        long sum = 0;

        while(temp!=0){
            digit++;
            temp = temp/10;
        }
        temp = originalNum;
        while(temp>0){
            long lastDigit = temp%10;
            sum += Math.pow(lastDigit, digit);
            temp = temp/10;
        }
        if(sum == originalNum){
            System.out.println(originalNum+" is Armstrong number.");
        }else{
            System.out.println(originalNum+" is not Armstrong number.");
        }

    }
}
