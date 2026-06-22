

public class CountWords {
    public static void main(String[] args) {
        String sentence = "  Java   programming is  fun  ";
        
        int wordCount = 0;
        boolean isWord = false;
        int endOfLine = sentence.length() - 1;

        for (int i = 0; i < sentence.length(); i++) {
    
            if (sentence.charAt(i) != ' ' && sentence.charAt(i) != '\t' && sentence.charAt(i) != '\n') {
            
                if (!isWord) {
                    wordCount++;
                    isWord = true;
                }
            } else {
            
                isWord = false;
            }
        }

        System.out.println("Sentence: \"" + sentence + "\"");
        System.out.println("Total word count: " + wordCount);
    }
}