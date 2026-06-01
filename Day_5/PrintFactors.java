import java.util.Scanner;

public class PrintFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long num = input.nextLong();
        
        if (num <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            System.out.print("Factors of " + num + " are: ");
            
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
        
        input.close();
    }
}

