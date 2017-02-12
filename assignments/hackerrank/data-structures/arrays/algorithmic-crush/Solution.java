import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    /**
     * Algorithm Crush can be resolved on O(M + N) time complexity by applying a prefix sum array (see http://wcipeg.com/wiki/Prefix_sum_array_and_difference_array).
     * The previous solutions were O(MN) time complexity, causing timeout.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int operations = scanner.nextInt();

        long[] prefixSumValues = generatePrefixSumArray(scanner, arraySize, operations);
        long maxValue = getMaxValue(arraySize, prefixSumValues);

        System.out.println(maxValue);
    }

    private static long[] generatePrefixSumArray(Scanner scanner, int arraySize, int operations) {
        long[] prefixSumValues = new long[arraySize + 1];

        for (int i = 1; i <= operations; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            long k = scanner.nextLong();

            prefixSumValues[a] += k;
            if (b + 1 <= arraySize) {
                prefixSumValues[b + 1] -= k;
            }
        }

        return prefixSumValues;
    }

    private static long getMaxValue(int arraySize, long[] prefixSumValues) {
        long maxValue = Long.MIN_VALUE;
        long[] values = new long[arraySize];
        long sumOfPrevious = 0;
        for (int i = 1; i < prefixSumValues.length; i++) {
            sumOfPrevious += prefixSumValues[i];
            values[i - 1] = prefixSumValues[0] + sumOfPrevious;
            if (values[i - 1] > maxValue) {
                maxValue = values[i - 1];
            }
        }

        return maxValue;
    }

}
