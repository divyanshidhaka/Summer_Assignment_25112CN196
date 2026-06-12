import java.util.Scanner;

public class Fibonacci {

    public static void printFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
            return;
        }

        int first = 0;
        int second = 1;

        System.out.print("Fibonacci Series up to " + n + " terms: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of term: ");
        int terms = sc.nextInt();
        printFibonacci(terms);
    }
}