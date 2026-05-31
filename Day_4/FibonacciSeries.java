import java.util.Scanner;

public class FibonacciSeries {
    public static void main (String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of last term: ");
        num = input.nextInt();

        long n1 = 0;
        long n2 = 1;
        long fib;
        for(int i = 1;i <= num;i++){
            System.out.print(n1+"\t");
                fib = n1+n2;
                n1 = n2;
                n2 = fib;
        }
    }
}