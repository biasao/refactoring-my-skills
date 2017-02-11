import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int operations = scanner.nextInt();

        long[] values = new long[arraySize];

        for (int i = 0; i < operations; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            long k = scanner.nextLong();

            // Not sure why, but the arrays on this assignment are not 0-based.
            IntStream.rangeClosed(a, b).forEach(j -> values[j-1] += k);
        }

        System.out.println(Arrays.stream(values).max().getAsLong());
    }

}
