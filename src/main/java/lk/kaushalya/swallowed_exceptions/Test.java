package lk.kaushalya.swallowed_exceptions;

// ==========================================
// Bad Code: Swallowed Exceptions Anti-Pattern
// ==========================================
class CalculatorBad {
    void doCalculation() {
        try {
            int result = 100 / 0; // This throws an ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Bad practice: exception is silently ignored
        }
        
        // Because the exception was swallowed, the program continues and prints this
        // misleading message even though the calculation failed.
        System.out.println("Results saved successfully.");
    }
}

// ==========================================
// Good Code: Refactored with Proper Exception Handling
// ==========================================
class CalculatorGood {
    void doCalculation() {
        try {
            int result = calculateResult(100, 0);
            
            // Success messages stay inside the try block so they are skipped if an error occurs
            System.out.println("Result: " + result);
            System.out.println("Results saved successfully.");
            
        } catch (ArithmeticException e) {
            // Good practice: Log or print the exception details
            System.err.println("Could not calculate the result: " + e.getMessage());
        }
    }

    // Extracting the calculation logic into its own method improves readability
    private int calculateResult(int total, int count) {
        return total / count;
    }
}

public class Test {
    public static void main(String[] args) {
        
        System.out.println("--- Bad Code Execution ---");
        CalculatorBad badCalc = new CalculatorBad();
        badCalc.doCalculation();

        System.out.println("\n--- Good Code (Refactored) Execution ---");
        CalculatorGood goodCalc = new CalculatorGood();
        goodCalc.doCalculation();
    }
}