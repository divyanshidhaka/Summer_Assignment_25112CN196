import java.util.Scanner;

public class PrintRepeatedCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        char n = 'A';
        
        for (int i = 1; i <=rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(n);
            }
            n++;
            System.out.println();
        }
        
        input.close();
    }
}