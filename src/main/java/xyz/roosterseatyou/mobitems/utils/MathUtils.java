package xyz.roosterseatyou.mobitems.utils;

import java.util.List;

public class MathUtils {

    public static boolean rngHelper(int n){
        int rInt = randomIntegerFromRange(1, 100);
        return rInt <= n;
    }

    /**
     * This generates a Random Integer from a range you specify
     * @param min minimum value in the range
     * @param max maximum value in the range
     * @return returns the random integer.
     */
    public static int randomIntegerFromRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) Math.floor(Math.random() * range) + min;
    }

    /**
     * Checks if a given int is positive.
     * @param n the number you want to check.
     * @return returns true if it is positive, false if not.
     */
    public static boolean isPositive(int n) {
        return n > 0;
    }

    /**
     * Checks if a given number is even.
     * @param n the number you want to check
     * @return returns true or false based on the findings.
     */

    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    /**
     * Checks if a number is divisible by another
     * @param n The number you want to check
     * @param divisor the number that the number you want to check will be divided by.
     * @return returns true or false based on the findings.
     */
    public static boolean isDivisibleBy(int n, int divisor) {
        return n % divisor == 0;
    }

    /**
     * Returns the average of a list of integers.
     * @param list list of integers you want to get the average of.
     * @return the average of the integers in list.
     */

    public static double average(List<Integer> list){
        int amount = list.size();
        int sum = 0;
        for(Integer at : list){
            sum += at;
        }
        return (double) sum/amount;
    }

    public static double sumOf(List<Double> list) {
        double sum = 0;
        for (Double at : list) {
            sum += at;
        }
        return sum;
    }
}
