import java.util.Scanner;
public class ArmstrongInRange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the starting number: ");
        int num1 = input.nextInt();
        System.out.print("Enter the ending number: ");
        int num2 = input.nextInt();
        
        for(int i = num1;i<=num2;i++){
        long temp =i;
        long originalNum = i;
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
            System.out.print(originalNum+"\t");
        }
        }
    }
}
