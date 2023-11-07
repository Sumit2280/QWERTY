import java.util.Scanner;

public class fibonacci {
    public int fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        int prev2 = 0;
        int prev1 = 1;
        for (int i = 2; i <= n; ++i) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        fibonacci fibonacciCalculator = new fibonacci();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of numbers: ");
        int n = sc.nextInt();

        System.out.println("Choose the method to calculate Fibonacci: ");
        System.out.println("1. Iterative method");
        System.out.println("2. Recursive method");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Fibonacci(" + n + ") using iterative method: " + fibonacciCalculator.fibonacciIterative(n));
                break;
            case 2:
                System.out.println("Fibonacci(" + n + ") using recursive method: " + fibonacciCalculator.fibonacciRecursive(n));
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
