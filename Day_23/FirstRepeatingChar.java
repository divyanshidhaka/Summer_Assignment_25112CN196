import java.util.HashSet;
public class FirstRepeatingChar {
    
    public static char findFirstRepeating(String str) {

        if (str == null || str.isEmpty()) {
            return '\0';
        }
        HashSet<Character> seenCharacters = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (seenCharacters.contains(ch)) {
                return ch;
            }

        seenCharacters.add(ch);
        }

       
        return '\0';
    }

    public static void main(String[] args) {
        String testStr = "geeksforgeeks";
        char result = findFirstRepeating(testStr);

        if (result != '\0') {
            System.out.println("The first repeating character in \"" + testStr + "\" is: " + result);
        } else {
            System.out.println("There are no repeating characters in the string.");
        }
    }
}