import java.util.Scanner;

public class MinMaxFinder {
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        
        if (size <= 0) {
            System.out.println("Array size must be greater than 0.");
            input.close();
            return;
        }
        
        int[] numbers = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }
        
        int max = numbers[0];
        int min = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            } else if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        
        System.out.println("\n--- Results ---");
        System.out.println("Smallest element: " + min);
        System.out.println("Largest element: " + max);
        
        input.close();
    }
}