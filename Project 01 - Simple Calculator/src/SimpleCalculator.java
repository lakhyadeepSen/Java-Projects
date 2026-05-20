import java.util.Scanner;

public class SimpleCalculator {
    // Method to add two numbers
    static double add(double a, double b) {
        return a + b;
    }

    // Method to subtract two numbers
    static double subtract(double a, double b) {
        return a - b;
    }

    // Method to multiply two numbers
    static double multiply(double a, double b) {
        return a * b;
    }

    // Method to divide two numbers
    static double divide(double a, double b) {
        // checking to avoid division by zero
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return a / b;
    }

    // Method to display the calculator menu
    static void displayMenu() {
        System.out.println("\nSimple Calculator");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("Choose an option : ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // loop keeps running until user chooses exit
        while (true) {
            displayMenu();
            choice = scanner.nextInt();

            // exit condition
            if (choice == 5) {
                System.out.println("Calculator closed.");
                break;
            }

            // taking numbers from user
            System.out.print("Enter first number : ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number : ");
            double num2 = scanner.nextDouble();

            double result = 0;

            // performing operation based on user choice
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    System.out.println("Result : " + result);
                    break;

                case 2:
                    result = subtract(num1, num2);
                    System.out.println("Result : " + result);
                    break;

                case 3:
                    result = multiply(num1, num2);
                    System.out.println("Result : " + result);
                    break;

                case 4:
                    result = divide(num1, num2);
                    System.out.println("Result : " + result);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}