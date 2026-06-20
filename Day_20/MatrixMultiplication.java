import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows for Matrix A: ");
        int r1 = scanner.nextInt();
        System.out.print("Enter columns for Matrix A: ");
        int c1 = scanner.nextInt();

        System.out.print("Enter rows for Matrix B: ");
        int r2 = scanner.nextInt();
        System.out.print("Enter columns for Matrix B: ");
        int c2 = scanner.nextInt();

        if (c1 != r2) {
            System.out.println("\nError: Matrix multiplication is not possible!");
            System.out.println("Columns of Matrix A must equal Rows of Matrix B.");
            scanner.close();
            return;
        }

        int[][] matrixA = new int[r1][c1];
        int[][] matrixB = new int[r2][c2];
        int[][] productMatrix = new int[r1][c2];

        System.out.println("\nEnter elements for Matrix A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.printf("A[%d][%d]: ", i, j);
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nEnter elements for Matrix B:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.printf("B[%d][%d]: ", i, j);
                matrixB[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        System.out.println("\nResultant Matrix (Product A x B):");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(productMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}