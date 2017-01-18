import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int change = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();

        int[] coins = new int[c];
        for (int i = 0; i < c; i++) {
            coins[i] = scanner.nextInt();
        }

        memos = new long[change+1][coins.length+1];
        long ways = calculateNumberOfWaysToProvideChangeFor(change, coins, coins.length);
        System.out.println(ways);
    }

    private static long[][] memos;

    private static void memoize(int change, int numberOfCoins, long result) {
        memos[change][numberOfCoins] = result;
    }

    private static boolean isMemoized(int change, int numberOfCoins) {
        if (change < 0 || numberOfCoins < 0) {
            return false;
        }

        return memos[change][numberOfCoins] != 0;
    }

    private static long calculateNumberOfWaysToProvideChangeFor(int change, int[] coins, int numberOfCoins) {
        if (isMemoized(change, numberOfCoins)) {
            return memos[change][numberOfCoins];
        }

        if (change == 0) {
            return 1;
        }

        if (change < 0) {
            return 0;
        }

        if (numberOfCoins <= 0 && change > 0) {
            return 0;
        }

        long result = calculateNumberOfWaysToProvideChangeFor(change, coins, numberOfCoins - 1) + calculateNumberOfWaysToProvideChangeFor(change - coins[numberOfCoins - 1], coins, numberOfCoins);
        memoize(change, numberOfCoins, result);

        return result;
    }
}
