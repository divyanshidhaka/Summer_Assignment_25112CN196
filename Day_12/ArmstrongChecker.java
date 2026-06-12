public class ArmstrongChecker {

    public static boolean isArmstrong(int number) {
        if (number < 0) {
            return false;
        }

        int originalNumber = number;
        int sum = 0;

        int numberOfDigits = String.valueOf(number).length();

        while (number > 0) {
            int lastDigit = number % 10;
            sum += Math.pow(lastDigit, numberOfDigits); 
            
            number = number / 10;
        }
        return sum == originalNumber;
    }

    public static void main(String[] args) {
        int test1 = 153;
        int test2 = 123;
        int test3 = 1634;

        System.out.println("Is " + test1 + " an Armstrong number? " + isArmstrong(test1));
        System.out.println("Is " + test2 + " an Armstrong number? " + isArmstrong(test2));
        System.out.println("Is " + test3 + " an Armstrong number? " + isArmstrong(test3));
    }
}