import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static String removeDuplicateChars(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : set) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicateChars(input);

        System.out.println("Original: " + input);
        System.out.println("After removing duplicates: " + result); 
    }
}