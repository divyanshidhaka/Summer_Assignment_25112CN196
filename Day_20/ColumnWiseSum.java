import java.util.Scanner;

public class ColumnWiseSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("\nEnter elements for the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nYour Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("---------------------------------");

        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            
            System.out.print(colSum + "\t");
        }
        System.out.println("<- Sum of columns");

        scanner.close();
    }
}