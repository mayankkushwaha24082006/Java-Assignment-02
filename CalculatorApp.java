import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {

    // --- Calculator Methods ---
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }

    // --- User Interface and Menu Handling ---
    private Scanner scanner = new Scanner(System.in);

    public void performAddition() {
        System.out.println("Choose Addition Type:");
        System.out.println("1. Two Integers");
        System.out.println("2. Two Doubles");
        System.out.println("3. Three Integers");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter first integer: ");
                int a = scanner.nextInt();
                System.out.print("Enter second integer: ");
                int b = scanner.nextInt();
                System.out.println("Result: " + add(a, b));
            }
            case 2 -> {
                System.out.print("Enter first double: ");
                double a = scanner.nextDouble();
                System.out.print("Enter second double: ");
                double b = scanner.nextDouble();
                System.out.println("Result: " + add(a, b));
            }
            case 3 -> {
                System.out.print("Enter first integer: ");
                int a = scanner.nextInt();
                System.out.print("Enter second integer: ");
                int b = scanner.nextInt();
                System.out.print("Enter third integer: ");
                int c = scanner.nextInt();
                System.out.println("Result: " + add(a, b, c));
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    public void performSubtraction() {
        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();
        System.out.println("Result: " + subtract(a, b));
    }

    public void performMultiplication() {
        System.out.print("Enter first double: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second double: ");
        double b = scanner.nextDouble();
        System.out.println("Result: " + multiply(a, b));
    }

    public void performDivision() {
        try {
            System.out.print("Enter numerator: ");
            int a = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int b = scanner.nextInt();
            System.out.println("Result: " + divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> performAddition();
                    case 2 -> performSubtraction();
                    case 3 -> performMultiplication();
                    case 4 -> performDivision();
                    case 5 -> System.out.println("Exiting... Thank you!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.next(); 
                choice = 0; 
            }

        } while (choice != 5);
    }

    // --- Main Method ---
    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();
        app.mainMenu();
    }
}
