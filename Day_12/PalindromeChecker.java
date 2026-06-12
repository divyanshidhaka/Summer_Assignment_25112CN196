public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
       
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String test1 = "Radar";
        String test2 = "Java";
        String test3 = "racecar";

        System.out.println("Is '" + test1 + "' a palindrome? " + isPalindrome(test1));
        System.out.println("Is '" + test2 + "' a palindrome? " + isPalindrome(test2));
        System.out.println("Is '" + test3 + "' a palindrome? " + isPalindrome(test3));
    }
}