import java.util.Scanner;

public class MaxFrequency {
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
        
        int mostFrequentElement = numbers[0];
        int maxCount = 0;
        
        for (int i = 0; i < size; i++) {
            int currentElement = numbers[i];
            int currentCount = 0;
            
            for (int j = 0; j < size; j++) {
                if (numbers[j] == currentElement) {
                    currentCount++;
                }
            }
            
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentElement = currentElement;
            }
        }
        
        System.out.println("Most frequent element: " + mostFrequentElement);
        System.out.println("It appears " + maxCount + " times.");
        
        input.close();
    }
}