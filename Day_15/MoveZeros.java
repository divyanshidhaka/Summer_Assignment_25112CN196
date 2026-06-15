import java.util.Scanner;


public class MoveZeros {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        
        int[] numbers = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }
        
        int insertPos = 0;
        
        for (int i = 0; i < size; i++) {
            if (numbers[i] != 0) {
                numbers[insertPos] = numbers[i];
                insertPos++;
            }
        }
        
        while (insertPos < size) {
            numbers[insertPos] = 0;
            insertPos++;
        }
        
        System.out.println("Array After Moving Zeroes to End: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        input.close();
    }
}