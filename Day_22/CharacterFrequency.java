import java.util.HashMap;
import java.util.Map;


public class CharacterFrequency {
    
    public static void main(String[] args) {
        String input = "hello world";
        
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        
        System.out.println("Character frequencies in \"" + input + "\":");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
    }
}    

