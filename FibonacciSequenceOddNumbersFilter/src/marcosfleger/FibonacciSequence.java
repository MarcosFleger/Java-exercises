package marcosfleger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FibonacciSequence {

    private final List<Integer> fibonacciValuesList = new ArrayList<>();
    private final List<Integer> oddNumbers = new ArrayList<>();
    private Integer scNumber = null;
    private boolean leave = false;

    public Integer randomNumberGenerator(Integer maxValue) {
        if (maxValue != null) {
            Random random = new Random();
            int numGenerated = (random.nextInt(maxValue) + 1);
            System.out.println("The random number was " + numGenerated);
            return numGenerated;
        } else {
            return maxValue;
        }
    }


    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public void fibonacciSequenceInARange(int range) {
        for (int i = 0; i < range; i++) {
            fibonacciValuesList.add(fib(i));
        }
    }

    public void quantityOfOddNumbers() {
        for (int elem : fibonacciValuesList) {
            if (elem % 2 == 1) {
                oddNumbers.add(elem);
            }
        }
        System.out.println("The quantity of odd number for this set of values is: "
                + oddNumbers.size() + " and the set is: "
                + oddNumbers);
    }

    public void keyboardInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease, insert the value of the maximum range.");

        if (sc.hasNext("exit") || sc.hasNext("EXIT")) {
            leave = true;
            System.out.println("Good bye! :)");

        } else if (!sc.hasNextInt()) {
            System.out.println("Something went wrong. The input must be an integer.");
            keyboardInput();
        } else {
            scNumber = sc.nextInt();
        }
    }

    public void init() {
        System.out.println("\nWelcome to the Fibonacci sequence " +
                "odd numbers filter! \n\nChoose a positive integer for the " +
                "maximum range of possible numbers and \nwe´ll " +
                "show you how many odd numbers are in that set, and which they are!" +
                "\nwrite 'exit' to leave.");

        while (!leave) {
            scNumber = null;
            fibonacciValuesList.clear();
            oddNumbers.clear();
            keyboardInput();
            try {
                fibonacciSequenceInARange(randomNumberGenerator(scNumber));
                quantityOfOddNumbers();
            } catch (Exception ignored) {

            }

        }

    }

}
