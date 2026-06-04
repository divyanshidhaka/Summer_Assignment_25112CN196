import java.util.Scanner;


public class CountSetBits {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        
        int originalNum = n;
        int count = 0;
        
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        
        System.out.println("Number of set bits (1s) in " + originalNum + " is: " + count);
        input.close();
    }
}