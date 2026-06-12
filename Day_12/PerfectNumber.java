import java.util.Scanner;

public class PerfectNumber {
   
    public static boolean isPerfectNumber(int number) {
        if (number <= 1) {
            return false;
        }

        int sum = 1;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (i == number / i) {
                    sum += i;
                } else {
                    sum += i + (number / i);
                }
            }
        }
        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int test = sc.nextInt();

        System.out.println("Is " + test + " a perfect number? -> " + isPerfectNumber(test));
       
    }
}