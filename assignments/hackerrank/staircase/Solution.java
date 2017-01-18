import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    /**
     * Non-optimal solution.
     * Time Complexity -> O(n2)
     * Space Complexity -> O(1)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int hashes = size;

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (j < hashes) {
                  System.out.print(" ");
                } else {
                  System.out.print("#");
                }
            }

            System.out.println();
            hashes--;
        }
    }
}
