import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    
    public static char findFirstNonRepeating(String str) {
        
        if (str == null || str.isEmpty()) {
            return '\0';
        }

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (charCountMap.get(ch) == 1) {
                return ch;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String testStr = "swiss";
        char result = findFirstNonRepeating(testStr);

        if (result != '\0') {
            System.out.println("The first non-repeating character in \"" + testStr + "\" is: " + result);
        } else {
            System.out.println("All characters are repeating or the string is empty.");
        }
    }
}