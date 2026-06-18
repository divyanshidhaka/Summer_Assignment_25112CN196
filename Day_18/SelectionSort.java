import java.util.Arrays;

public class SelectionSort {
    
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11};
        
        System.out.println("Original Array: " + Arrays.toString(data));
        
        selectionSort(data);
        
        System.out.println("Sorted Array: " + Arrays.toString(data));
    }
}