package hust.soict.hespi.lab01;
import java.util.Scanner;

public class StarTriagle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Height of triagle:  ");
        int n = sc.nextInt();
        sc.close();

        for (int i = 1; i <= n; i++) {
            // print space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" "); 
            }

            // print star
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}