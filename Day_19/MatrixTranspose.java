import java.util.Scanner;

public class MatrixTranspose {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] originalMatrix = new int[rows][cols];
        
        int[][] transposedMatrix = new int[cols][rows];

        System.out.println("\nEnter elements for the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                originalMatrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = originalMatrix[i][j];
            }
        }

        System.out.println("\nOriginal Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(originalMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nTransposed Matrix:");
        for (int i = 0; i < cols; i++) { 
            for (int j = 0; j < rows; j++) {
                System.out.print(transposedMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}