import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    /**
     * Optimal solution (at least I think it is optimal, still need to evaluate the complexity of substring and streams).
     * Time Complexity -> O(n)
     * Space Complexity -> O(n)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        String stringSpace = Stream.generate(() -> String.valueOf(' ')).limit(size).collect(Collectors.joining());
        String stringHash = Stream.generate(() -> String.valueOf('#')).limit(size).collect(Collectors.joining());

        for (int i = 1; i <= size; i++) {
            System.out.print(stringSpace.substring(0, size - i));
            System.out.println(stringHash.substring(0, i));
        }
    }
}
