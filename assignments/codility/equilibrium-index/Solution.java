import java.util.*;
import java.util.stream.*;

public class Solution {

    // Input
    // n -> Array size
    // n1 n2 n3 n4 -> Array elements
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());
        int[] A = new int[n];

        IntStream.range(0, n).forEach(i -> A[i] = scanner.nextInt());

        System.out.println(s.solution(A));
    }

    // Codility method
    public int solution(int[] A) {
        int equilibriumIndex = -1;
        if (A == null) {
            return equilibriumIndex;
        }

        int n = A.length;
        long sumLower = 0;
        long sumHigher = 0;
        for (int p = 0; p < n; p++) {
            sumLower = calculateSumLower(p, n, A, sumLower);
            sumHigher = calculateSumHigher(p, n, A, sumHigher);

            if (sumLower == sumHigher) {
                return p;
            }
        }

        return equilibriumIndex;
    }

    public long calculateSumLower(int p, int n, int[] A, long sumLower) {
        if (p == 0) {
            return 0;
        }

        return sumLower + A[p - 1];
    }

    public long calculateSumHigher(int p, int n, int[] A, long sumHigher) {
        if (p == 0) {
            long initialSumHigher = 0;
            for (int i = 1; i < n; i++) {
                initialSumHigher += A[i];
            }

            return initialSumHigher;
        }

        if (p == (n - 1)) {
            return 0;
        }

        return sumHigher - A[p];
    }

}
