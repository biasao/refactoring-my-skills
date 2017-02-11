import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int SIZE = 6;
        int[][] values = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                values[i][j] = scanner.nextInt();
            }
        }

        int maxHourglassSum = Integer.MIN_VALUE;
        final int MIN_HOURGLASS_INDEX = 1;
        final int MAX_HOURGLASS_INDEX = SIZE - 1;

        for (int i = MIN_HOURGLASS_INDEX; i < MAX_HOURGLASS_INDEX; i++) {
            for (int j = MIN_HOURGLASS_INDEX; j < MAX_HOURGLASS_INDEX; j++) {
                int hourglassSum = values[i][j] + values[i-1][j-1] + values[i-1][j] + values[i-1][j+1] + values[i+1][j-1] + values[i+1][j] + values[i+1][j+1];
                if (hourglassSum > maxHourglassSum) {
                    maxHourglassSum = hourglassSum;
                }
            }
        }

        System.out.println(maxHourglassSum);
    }

}
