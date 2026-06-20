import java.util.Scanner;


public class SumOfDiagonal {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the square matrix (N x N): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("\nEnter elements for the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        int principalSum = 0;
        int secondarySum = 0;

        for (int i = 0; i < n; i++) {
            principalSum += matrix[i][i];
            secondarySum += matrix[i][n - 1 - i];
        }
        System.out.println("\nYour Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\n--- Results ---");
        System.out.println("Sum of Principal Diagonal: " + principalSum);
        System.out.println("Sum of Secondary Diagonal: " + secondarySum);
        
        if (n % 2 != 0) {
            int middleElement = matrix[n / 2][n / 2];
            System.out.println("Note: The matrices intersect at the center element (" + middleElement + ").");
            System.out.println("Total combined diagonal sum (without duplicating center): " + (principalSum + secondarySum - middleElement));
        } else {
            System.out.println("Total combined diagonal sum: " + (principalSum + secondarySum));
        }

        scanner.close();
    }
}