import java.util.Scanner;

public class RecursiveReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to reverse: ");
        long num = input.nextLong();
        
        long absoluteNum = Math.abs(num);
        long reversedNum = reverse(absoluteNum, 0);
        
        if (num < 0) {
            reversedNum = -reversedNum;
        }
        
        System.out.println("Reversed number: " + reversedNum);
        input.close();
    }
    
    public static long reverse(long n, long rev) {
        if (n == 0) { // Base case
            return rev;
        }
        long lastDigit = n % 10;
        return reverse(n / 10, rev * 10 + lastDigit);
    }
}