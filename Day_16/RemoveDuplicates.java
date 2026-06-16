import java.util.Arrays;
import java.util.LinkedHashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 1, 2, 4, 5, 3};
        
        LinkedHashSet<Integer> set = new LinkedHashSet<>(Arrays.asList(numbers));
        
        Integer[] uniqueNumbers = set.toArray(new Integer[0]);
        
        System.out.println(Arrays.toString(uniqueNumbers)); 
    }
}
