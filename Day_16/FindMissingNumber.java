import java.util.Scanner;

public class FindMissingNumber {
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("What should be the total count of numbers (n): ");
        int n = input.nextInt();
        
        int size = n - 1;
        int[] numbers = new int[size];
        
        System.out.println("Enter " + size + " elements (ranging from 1 to " + n + "):");
        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }
    
        int expectedSum = (n * (n + 1)) / 2;
        
        int actualSum = 0;
        for (int num : numbers) {
            actualSum += num;
        }
        
        int missingNumber = expectedSum - actualSum;
        
        System.out.println("The missing number is: " + missingNumber);
        
        input.close();
    }
}