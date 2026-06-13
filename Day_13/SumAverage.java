import java.util.Scanner;

public class SumAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        
        int[] numbers = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        
        double average = (double) sum / size;
        
        System.out.println("\n--- Results ---");
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);
        
        input.close();
    }
}