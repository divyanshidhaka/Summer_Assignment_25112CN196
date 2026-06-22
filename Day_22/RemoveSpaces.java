public class RemoveSpaces {
    public static void main(String[] args) {
        String input = "  J a v a   P r o g r a m m i n g  ";
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if (ch != ' ' && ch != '\t' && ch != '\n') {
                result.append(ch);
            }
        }
        
        System.out.println("Original: \"" + input + "\"");
        System.out.println("Without Spaces: \"" + result.toString() + "\"");
    }
}
