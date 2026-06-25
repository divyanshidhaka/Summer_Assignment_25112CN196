import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameSorter {
    
    public static void main(String[] args) {
        
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Liam");
        names.add("Emma");
        names.add("Noah");
        names.add("Olivia");

        System.out.println("Original list: " + names);

        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

        System.out.println("Sorted list:   " + names);
    }
}