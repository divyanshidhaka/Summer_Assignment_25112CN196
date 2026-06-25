import java.util.ArrayList;
import java.util.List;

public class CommonCharacters {

    public static List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        
        if (words == null || words.length == 0) {
            return result;
        }

        int[] minStatuses = new int[26];
        
        for (char ch : words[0].toCharArray()) {
            minStatuses[ch - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] currentStatuses = new int[26];
            
            for (char ch : words[i].toCharArray()) {
                currentStatuses[ch - 'a']++;
            }
            
            for (int j = 0; j < 26; j++) {
                minStatuses[j] = Math.min(minStatuses[j], currentStatuses[j]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (minStatuses[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minStatuses[i]--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        
        List<String> common = commonChars(words);
        
        System.out.println("Input Words: " + java.util.Arrays.toString(words));
        System.out.println("Common Characters: " + common);
    }
}