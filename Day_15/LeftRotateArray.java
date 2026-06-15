import java.util.Scanner;

public class LeftRotateArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        
        int[] numbers = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }
        
        System.out.print("Enter number of positions to rotate left: ");
        int d = input.nextInt();
        
        d = d % size;
        
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = numbers[i];
        }
    
        for (int i = d; i < size; i++) {
            numbers[i - d] = numbers[i];
        }
        
        for (int i = 0; i < d; i++) {
            numbers[size - d + i] = temp[i];
        }
        
        System.out.println(" Array After Left Rotation:");
        System.out.print("[ ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
        
        input.close();
    }
}