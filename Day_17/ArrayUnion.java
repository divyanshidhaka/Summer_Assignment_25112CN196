import java.util.Arrays;
import java.util.HashSet;

public class ArrayUnion {
    public static void main(String[] args) {
        Integer[] array1 = {1, 3, 5, 7};
        Integer[] array2 = {3, 5, 8, 9};

        HashSet<Integer> set = new HashSet<>();

        set.addAll(Arrays.asList(array1));
        set.addAll(Arrays.asList(array2));

        Integer[] unionArray = set.toArray(new Integer[0]);

        System.out.println("Union: " + Arrays.toString(unionArray));
    }
}