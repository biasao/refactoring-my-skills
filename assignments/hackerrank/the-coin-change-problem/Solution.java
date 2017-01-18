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

        long ways = calculateNumberOfWaysToProvideChangeFor(change, coins, coins.length);
        System.out.println(ways);
    }

    private static long calculateNumberOfWaysToProvideChangeFor(int change, int[] coins, int numberOfCoins) {
        if (isMemoized(change, numberOfCoins)) {
            return 0;
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

        return calculateNumberOfWaysToProvideChangeFor(change, coins, numberOfCoins - 1) + calculateNumberOfWaysToProvideChangeFor(change - coins[numberOfCoins - 1], coins, numberOfCoins);
    }

    private static class Memo {
        private int change;
        private int numberOfCoins;

        public Memo(int change, int numberOfCoins) {
            this.change = change;
            this.numberOfCoins = numberOfCoins;
        }

        @Override
        public int hashCode() {
            return change + numberOfCoins;
        }

        @Override
        public boolean equals(Object other) {
            Memo otherMemo = (Memo) other;
            return otherMemo.change == change && otherMemo.numberOfCoins == numberOfCoins;
        }
    }

    private static Set<Memo> memos = new HashSet<>();

    private static void memoize(int change, int numberOfCoins) {
        memos.add(new Memo(change, numberOfCoins));
    }

    private static boolean isMemoized(int change, int numberOfCoins) {
        return memos.contains(new Memo(change, numberOfCoins));
    }
}
