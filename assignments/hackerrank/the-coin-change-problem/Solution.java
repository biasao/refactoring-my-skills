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

        long ways = calculateNumberOfWaysToProvideChangeFor(change, coins);
        System.out.println(ways);
    }

    private static long calculateNumberOfWaysToProvideChangeFor(int change, int[] coins) {
        if (coins.length == 0) {
            return 0;
        }

        if (isMemoized(change, coins)) {
            return 0;
        }

        long ways = 0;
        memoize(change, coins);

        if (coins.length == 1) {
            int sum = 0;
            int counter = 1;
            do {
                sum = coins[0] * counter;
                if (sum == change) {
                    ways += 1;
                } else {
                    counter++;
                }
            } while (sum < change);
        } else {
            int sum = Arrays.stream(coins).sum();
            if (sum == change) {
                ways += 1;
            } else if (sum < change) {
                // sum < change
                int diff = change - sum;
                int[] possibleCoins = Arrays.stream(coins).filter(e -> e <= diff).toArray();
                ways += calculateNumberOfWaysToProvideChangeFor(diff, possibleCoins);
            }
        }

        for (int i = 0; i < coins.length; i++) {
            final int currentCoin = coins[i];
            int[] coinsSubset = Arrays.stream(coins).filter(e -> e != currentCoin).toArray();
            ways += calculateNumberOfWaysToProvideChangeFor(change, coinsSubset);
        }

        return ways;
    }

    private static class Memo {
        private int change;
        private int[] coins;

        public Memo(int change, int[] coins) {
            this.change = change;
            this.coins = coins;
        }

        @Override
        public int hashCode() {
            return change + Arrays.hashCode(coins);
        }

        @Override
        public boolean equals(Object other) {
            Memo otherMemo = (Memo) other;
            return otherMemo.hashCode() == hashCode();
        }
    }

    private static Set<Memo> memos = new HashSet<>();

    private static void memoize(int change, int[] coins) {
        memos.add(new Memo(change, coins));
    }

    private static boolean isMemoized(int change, int[] coins) {
        return memos.contains(new Memo(change, coins));
    }
}
