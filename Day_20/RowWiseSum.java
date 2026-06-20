import java.util.Scanner;
public class RowWiseSum {
    
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

        System.out.println("\n--- Matrix and Row Sums ---");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
                rowSum += matrix[i][j]; // Accumulate sum of current row elements
            }
            
            System.out.println("-> Sum of row " + (i + 1) + " = " + rowSum);
        }

        scanner.close();
    }
}