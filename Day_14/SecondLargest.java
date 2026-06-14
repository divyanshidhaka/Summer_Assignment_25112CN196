
public class SecondLargest {

    public static int getSecondLargest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array must have at least two elements.");
            return Integer.MIN_VALUE; 
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } 
            else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        
        int result = getSecondLargest(arr);
        
        if (result != Integer.MIN_VALUE) {
            System.out.println("The second largest element is: " + result);
        } else {
            System.out.println("No second largest element found.");
        }
    }
}