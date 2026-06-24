
public class LongestWordFinder {
    public static String findLongestWord(String sentence) {
    
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        String[] words = sentence.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
        
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        String sentence = "Coding in Java is absolutely fascinating and rewarding.";
        
        String longest = findLongestWord(sentence);
        
        System.out.println("Original Sentence: \"" + sentence + "\"");
        System.out.println("The longest word is: \"" + longest + "\" (Length: " + longest.length() + ")");
    }
}