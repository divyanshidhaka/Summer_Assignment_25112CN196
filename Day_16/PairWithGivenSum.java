import java.util.Arrays;
import java.util.Scanner;

public class PairWithGivenSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        
        int[] numbers = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }
        
        System.out.print("Enter the target sum you are looking for: ");
        int targetSum = input.nextInt();
        
        Arrays.sort(numbers);
        
        int left = 0;
        int right = size - 1;
        boolean pairFound = false;
        
        System.out.println("\nResults :");
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            
            if (currentSum == targetSum) {
                System.out.println("Pair found: " + numbers[left] + " + " + numbers[right] + " = " + targetSum);
                pairFound = true;
                
                left++;
                right--;
            } 
            else if (currentSum < targetSum) {
                left++;
            } 
            else {
                right--;
            }
        }
        
        if (!pairFound) {
            System.out.println("No pair found with the sum " + targetSum);
        }
        
        input.close();
    }
}