import java.util.Scanner;
public class DerivativeCalculator{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the term (e.g., 3x^2):");
        String term = scanner.nextLine();
        scanner.close();
        //array 
        int[] derivative = powerRule(term);
        System.out.printf("The derivative of %s is %dx^%d%n", term, derivative[0], derivative[1]);
    }

    public static int[] powerRule(String term) {
        String[] parts = term.split("x\\^?");
        int coefficient = 0;
        int exponent = 0;
        
        if (parts.length == 1) {
            // Only coefficient
            coefficient = Integer.parseInt(parts[0]);
            exponent = 0;
        } else if (parts.length == 2) {
            // Both coefficient and exponent
            coefficient = Integer.parseInt(parts[0]);
            exponent = Integer.parseInt(parts[1]);
        } else {
            throw new IllegalArgumentException("Invalid format");
        }
        
        if (exponent == 0) {
            // Derivative of constant term is zero
            return new int[] { 0, 0 };
        } else {
            int newCoefficient = coefficient * exponent;
            int newExponent = exponent - 1;
            return new int[] { newCoefficient, newExponent };
        }
    }
}
