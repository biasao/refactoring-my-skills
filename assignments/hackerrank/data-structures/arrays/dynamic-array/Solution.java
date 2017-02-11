import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        List<ArrayList<Long>> seqList = Stream.generate(ArrayList<Long>::new).limit(n).collect(Collectors.toList());
        long lastAns = 0;

        for (int i = 0; i < q; i++) {
            int query = scanner.nextInt();
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            int index = (int)((x ^ lastAns) % (long) n);
            List<Long> seq = seqList.get(index);

            if (query == 1) {
                seq.add(y);
                continue;
            }

            if (query == 2) {
                int element = (int)(y % (long)seq.size());
                lastAns = seq.get(element);
                System.out.println(lastAns);
            }
        }
    }

}
