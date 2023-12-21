package hust.soict.hedspi.lab01;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySortSumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Create an array to store the elements
        double[] array = new double[n];

        // Input the elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextDouble();
        }

        // Sort the array
        Arrays.sort(array);

        // Calculate the sum of elements
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }

        // Calculate the average
        double average = sum / n;

        // Display the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(array));

        // Display the sum and average
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + average);

        scanner.close();
    }
}