import java.util.Scanner;

public class CharacterPyramid {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        
        for (int i = 1; i <= rows; i++) {
            
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            
            char ch = 'A';
            int totalCharsInRow = 2 * i - 1;
            
            for (int k = 1; k <= totalCharsInRow; k++) {
                System.out.print(ch);
                
                if (k < i) {
                    ch++;
                } else {
                    ch--;
                }
            }
            System.out.println();
        }
        
        input.close();
    }
}