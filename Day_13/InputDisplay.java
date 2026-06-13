import java.util.Scanner;

public class InputDisplay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] numbers = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element at index " + i + ": ");
            numbers[i] = input.nextInt();
        }
        
        System.out.println("\n--- Displaying Array Elements ---");
        System.out.print("[ ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
        
        input.close();
    }
}