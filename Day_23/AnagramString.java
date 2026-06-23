
public class AnagramString {

    public static boolean isAnagram(String str1, String str2) {
    
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] charCounts = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            charCounts[str1.charAt(i)]++;
            charCounts[str2.charAt(i)]--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        if (isAnagram(s1, s2)) {
            System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are anagrams.");
        } else {
            System.out.println("\"" + s1 + "\" and \"" + s2 + "\" are NOT anagrams.");
        }
    }
}