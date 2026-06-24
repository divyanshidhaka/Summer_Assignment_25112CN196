public class StringCompression {

    public static String compress(String str) {
    
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        String input1 = "aabcccccaaa";
        String input2 = "abcd";

        System.out.println("Original: " + input1 + " -> Compressed: " + compress(input1));
        System.out.println("Original: " + input2 + " -> Compressed: " + compress(input2));
    }
}