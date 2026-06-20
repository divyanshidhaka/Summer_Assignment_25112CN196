import java.util.Scanner;

public class SymmetricMatrixCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        if (rows != cols) {
            System.out.println("\nThe matrix is NOT symmetric (It must be a square matrix).");
            scanner.close();
            return;
        }

        int[][] matrix = new int[rows][cols];

        System.out.println("\nEnter elements for the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        boolean isSymmetric = true;

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    isSymmetric = false;
                    break;
                }
            }
            if (!isSymmetric) {
                break;
            }
        }

        System.out.println("\nYour Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        if (isSymmetric) {
            System.out.println("\nVerdict: The matrix IS symmetric.");
        } else {
            System.out.println("\nVerdict: The matrix is NOT symmetric.");
        }

        scanner.close();
    }
}