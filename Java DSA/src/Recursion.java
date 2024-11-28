import java.math.BigInteger;

public class Recursion {

    static class SquareRoot {

        static double sqrt(int x) {
            // Handle negative input by returning Not-a-Number
            if (x < 0)
                return Double.NaN;
            // Base case: square root of 0 is 0
            if (x == 0)
                return 0.0;
            // Initial guess of 1 to start the approximation
            double guess = 1;
            // Check if initial guess is accurate enough
            if (goodEnogh(guess, x)) {
                return guess;
            } else {
                // If not accurate enough, improve the guess and recurse
                double newGuess = improveGuess(guess, x);
                return sqrt(x, newGuess);
            }
        }

        static double sqrt(int x, double guess) {
            // Base case: return when guess is accurate enough
            if (goodEnogh(guess, x)) {
                return guess;
            } else {
                // Recursive case: improve guess and continue approximating
                double newGuess = improveGuess(guess, x);
                return sqrt(x, newGuess);
            }
        }

        private static boolean goodEnogh(double guess, int x) {
            // Check if guess is within acceptable error margin (10^-4)
            boolean boolVal = Math.abs(guess * guess - x) < 0.0001;
            return boolVal;
        }

        private static double improveGuess(double guess, int x) {
            // Newton's method: improve guess using average of guess and x/guess
            guess = (guess + x / guess) / 2;
            return guess;
            // Legacy linear approximation method (commented out)
            // if (guess < x) {
            // return guess + 0.1;
            // } else {
            // return guess - 0.1;
            // }
        }
    }

    static class Factorial {
        static BigInteger fact(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Factorial is not defined for Negative Number!");

            }
            // base cases
            if (n == 0) {
                return BigInteger.ONE;
            }

            // induction case
            return BigInteger.valueOf(n).multiply(fact(n - 1));

        }
    }

    static class Fibonacci {
        static int fibo(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 0) {
                return 0;
            }
            return fibo(n - 1) + fibo(n - 2); 
        }
    }

    public static void main(String[] args) {
        // System.out.println( (float) SquareRoot.sqrt(2400););

        // System.out.println(Factorial.fact(50));

        // System.out.println(Fibonacci.fibo(30));
    }
}
