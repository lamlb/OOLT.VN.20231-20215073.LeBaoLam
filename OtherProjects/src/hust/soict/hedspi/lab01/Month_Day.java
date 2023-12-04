package hust.soict.hespi.lab01;
import java.util.Scanner;

public class Month_Day {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for month and year
        String month;
        int year;

        while (true) {
            System.out.print("Enter a month (full name, abbreviation, 3 letters, or number): ");
            month = scanner.nextLine().toLowerCase();

            if (isValidMonth(month)) {
                break;
            } else {
                System.out.println("Invalid month. Please try again.");
            }
        }

        while (true) {
            System.out.print("Enter a year: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) {
                    break;
                }
            }
            scanner.nextLine(); // Consume the invalid input
            System.out.println("Invalid year. Please enter a non-negative integer.");
        }

        scanner.close();

        // Determine the number of days in the entered month and year
        int days = getDaysInMonth(month, year);
        System.out.println("Number of days in month " + month + " year " + year + " is: " + days + " days.");
    }

    // Function to check if the input month is valid
    public static boolean isValidMonth(String input) {
        String[] validMonths = {"january", "jan.", "jan", "1", "february", "feb.", "feb", "2", "march", "mar.", "mar", "3",
                "april", "apr.", "apr", "4", "may", "5", "june", "jun.", "jun", "6", "july", "jul.", "jul", "7",
                "august", "aug.", "aug", "8", "september", "sept.", "sept", "9", "october", "oct.", "oct", "10",
                "november", "nov.", "nov", "11", "december", "dec.", "dec", "12"};

        for (String validMonth : validMonths) {
            if (validMonth.equals(input)) {
                return true;
            }
        }
        return false;
    }

    // Function to get the number of days in a month
    public static int getDaysInMonth(String month, int year) {
        int days;
        switch (month) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
            case "march":
            case "mar.":
            case "mar":
            case "3":
            case "may":
            case "5":
            case "july":
            case "jul.":
            case "jul":
            case "7":
            case "august":
            case "aug.":
            case "aug":
            case "8":
            case "october":
            case "oct.":
            case "oct":
            case "10":
            case "december":
            case "dec.":
            case "dec":
            case "12":
                days = 31;
                break;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                days = isLeapYear(year) ? 29 : 28;
                break;
            default:
                days = 30;
                break;
        }
        return days;
    }

    // Function to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}