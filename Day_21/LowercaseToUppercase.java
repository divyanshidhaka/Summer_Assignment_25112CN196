

public class LowercaseToUppercase {
    
    public static void main(String[] args) {
        String input = "hello, world! 2026";
        
        char[] charArray = input.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] >= 'a' && charArray[i] <= 'z') {
              
                charArray[i] = (char) (charArray[i] - 32);
            }
        }
        
        String result = new String(charArray);
        
        System.out.println("Original: " + input);
        System.out.println("Uppercase: " + result);
    }
}

