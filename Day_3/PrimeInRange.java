import java.util.Scanner;

public class PrimeInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Starting number :");
        int num1 = sc.nextInt();

        System.out.print("Enter the Ending number :");
        int num2 = sc.nextInt();

        for(int i = num1;i<= num2;i++){
        boolean isPrime = true;
        if(i<=1){
            isPrime = false;
        }
        else{
        for(int j =2;j*j<= i;j++){
            if(i%j == 0){
                isPrime = false;
                break;
            }
        }
        }
        if(isPrime){
            System.out.println(i + " is a prime number");
        }
    }
}}
