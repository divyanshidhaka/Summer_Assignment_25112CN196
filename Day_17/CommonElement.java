import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CommonElement {
    public static void main(String[] args) {
        
        Integer[] array1 = {4, 2, 9, 6, 2, 1, 8};
        Integer[] array2 = {6, 2, 11, 8, 10};

        List<Integer> commonElements = findCommonElements(array1, array2);
        System.out.println("Common elements: " + commonElements);
    }

    public static List<Integer> findCommonElements(Integer[] arr1, Integer[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : arr1) {
            set.add(num);
        }

       for (Integer num : arr2) {
            if (set.contains(num)) {
                result.add(num);

                set.remove(num); 
            }
        }

        return result;
    }
}