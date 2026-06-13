import java.util.Scanner;

public class CountEvenOdd {
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        
        int[] numbers = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }
        
        int evenCount = 0;
        int oddCount = 0;
        
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("\n--- Results ---");
        System.out.println("Total Even elements: " + evenCount);
        System.out.println("Total Odd elements: " + oddCount);
        
        input.close();
    }
}