

public class StringLength {
    public static void main(String[] args) {
        String str = "Hello, World!";
        
        int length = 0;
        
        for (char c : str.toCharArray()) {
            length++;
        }
        
        System.out.println("The string is: \"" + str + "\"");
        System.out.println("The length of the string is: " + length);
    }
}