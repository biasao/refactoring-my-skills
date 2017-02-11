import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> summary = new HashMap<>();
        String[] strings = new String[numberOfStrings];

        for (int i = 0; i < numberOfStrings; i++) {
            String string = scanner.nextLine();
            strings[i] = string;
            int count = summary.containsKey(string)
                            ? summary.get(string) + 1
                            : 1;
            summary.put(string, count);
        }

        int numberOfQueries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfQueries; i++) {
            String query = scanner.nextLine();
            Integer count = summary.get(query);
            System.out.println(count == null ? 0 : count);
        }
    }

}
