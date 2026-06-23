public class MaxOccurringChar {
    
    public static char getMaxOccurringChar(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        int[] charCounts = new int[256];

        for (int i = 0; i < str.length(); i++) {
            charCounts[str.charAt(i)]++;
        }

        int maxCount = -1;
        char maxChar = ' ';

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (charCounts[currentChar] > maxCount) {
                maxCount = charCounts[currentChar];
                maxChar = currentChar;
            }
        }

        return maxChar;
    }

    public static void main(String[] args) {
        String testStr = "sample string";
                
        char result = getMaxOccurringChar(testStr);
        
        System.out.println("The original string is: \"" + testStr + "\"");
        System.out.println("The maximum occurring character is: '" + result + "'");
    }
}