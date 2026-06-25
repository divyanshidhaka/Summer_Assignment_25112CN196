import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordLengthSorter {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Elephant");
        words.add("Cat");
        words.add("Hippopotamus");
        words.add("Dog");
        words.add("Giraffe");

        System.out.println("Original list: " + words);

        words.sort(Comparator.comparingInt(String::length));

        System.out.println("Sorted by length: " + words);
    }
}