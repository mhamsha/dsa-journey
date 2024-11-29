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
   // functional approach
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
    // OOP approach
    // class Factorial {
    //     private int n;

    //     public Factorial(int n) {
    //         if (n < 0) {
    //             throw new IllegalArgumentException("Factorial is not defined for Negative Number!");
    //         }
    //         this.n = n;
    //     }

    //     public BigInteger compute() {
    //         // base cases
    //         if (n == 0) {
    //             return BigInteger.ONE;
    //         }

    //         // induction case
    //         return BigInteger.valueOf(n).multiply(new Factorial(n - 1).compute());
    //     }
    // }

    static class Fibonacci {
        static int fibo(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 0) {
                return 0;
            }
            // Recursive case: sum of the two preceding numbers
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    static class TowerOfHanoi {
        static void hanoi(int lvl) {
            // Start moving the tower from rod A to rod C using rod B as auxiliary
            moveTower(lvl, 'A', 'C', 'B');
        }

        private static void moveTower(int lvl, char fr, char to, char ax) {
            // Base case: only one disk to move
            if (lvl == 1) {
                printMove(lvl, fr, to);
                return;
            }
            // Move the top lvl-1 disks from source to auxiliary
            moveTower(lvl - 1, fr, ax, to);
            // Move the remaining disk from source to destination
            printMove(lvl, fr, to);
            // Move the lvl-1 disks from auxiliary to destination
            moveTower(lvl - 1, ax, to, fr);
        }

        private static void printMove(int lvl, char fr, char to) {
            // Print the move of a disk from one rod to another
            // Print the move of a disk from one rod to another
            System.out.println("Move: " + lvl + " from " + fr + " to " + to);
        }
    }

    static class SumOverList {
        // Iterative function to sum elements of a list
        static int itSum(int[] list) {
            int sum = 0;
            for (int i = 0; i < list.length; i++) {
                sum += list[i];
            }
            return sum;
        }

        // Recursive function to sum elements of a list
        static int reSum(int[] list) {
            return reSumHelper(list, 0);
        }

        // Helper function for recursive sum
        static int reSumHelper(int[] list, int index) {
            // Base case: if index reaches the end of the list, return 0
            if (index == list.length)
                return 0;
            // Recursive case: sum current element and recurse for the rest
            return list[index] + reSumHelper(list, index + 1);
        }
    }

    public static void main(String[] args) {
        // System.out.println( (float) SquareRoot.sqrt(2400););

        // System.out.println(Factorial.fact(50));

        // System.out.println(Fibonacci.fibo(30));

        // TowerOfHanoi.hanoi(3);

        int[] list = { 1, 2, 3, 4, 5 };
        // System.out.println(sumOverList.itSum(list));

        // System.out.println(SumOverList.reSum(list));

    }
}
