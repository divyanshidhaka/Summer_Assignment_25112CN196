import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayIntersection {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 4};
        Integer[] array2 = {2, 2, 4, 6, 7};

        HashSet<Integer> set = new HashSet<>(Arrays.asList(array1));
        
        HashSet<Integer> intersectionSet = new HashSet<>();

        for (Integer num : array2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }

        Integer[] intersection = intersectionSet.toArray(new Integer[0]);

        System.out.println("Intersection: " + Arrays.toString(intersection));
    }
}