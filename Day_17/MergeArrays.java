import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        int[] array1 = {10, 20, 30};
        int[] array2 = {40, 50, 60};

        int[] mergedArray = new int[array1.length + array2.length];
        int position = 0;

        for (int element : array1) {
            mergedArray[position] = element;
            position++;
        }

        for (int element : array2) {
            mergedArray[position] = element;
            position++;
        }

        System.out.println(Arrays.toString(mergedArray));
    }
}