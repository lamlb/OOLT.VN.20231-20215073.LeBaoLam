package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the dimensions of the matrices
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Create two matrices
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];

        // Input the elements of the first matrix
        System.out.println("Enter elements of the first matrix:");
        inputMatrix(matrix1, scanner);

        // Input the elements of the second matrix
        System.out.println("Enter elements of the second matrix:");
        inputMatrix(matrix2, scanner);

        // Initialize the result matrix
        int[][] resultMatrix = new int[rows][cols];

        // Add the two matrices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Display the result
        System.out.println("Matrix Addition Result:");
        printMatrix(resultMatrix);

        scanner.close();
    }

    // Function to input matrix elements
    public static void inputMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Function to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}