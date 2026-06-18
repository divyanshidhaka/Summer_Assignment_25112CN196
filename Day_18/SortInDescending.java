import java.util.Arrays;

public class SortInDescending {
    public static void sortDescending(int[] arr) {
        Arrays.sort(arr);
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original Array: " + Arrays.toString(data));
        
        sortDescending(data);
        
        System.out.println("Descending Order: " + Arrays.toString(data));
    }
}