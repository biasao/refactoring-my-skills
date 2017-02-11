import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int leftRotation = scanner.nextInt();

        List<Integer> values = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            values.add(scanner.nextInt());
        }

        for (int i = 0; i < leftRotation; i++) {
            int value = values.remove(0);
            values.add(n - 1, value);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(values.get(i));
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }

}
