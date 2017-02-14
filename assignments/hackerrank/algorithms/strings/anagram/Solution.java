import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String string = scanner.nextLine();
            int length = string.length();
            int changes = length % 2 == 1
                            ? -1
                            : calculateChanges(string, length);

            System.out.println(changes);
        }
    }

    private static int calculateChanges(String string, int length) {
        int halfLength = length / 2;
        Map<Character, Integer> frequencyS1 = calculateFrequency(string.substring(0, halfLength));
        Map<Character, Integer> frequencyS2 = calculateFrequency(string.substring(halfLength, length));

        int changes = frequencyS2
                            .keySet()
                            .stream()
                            .collect(
                                Collectors
                                    .summingInt(
                                        key -> frequencyS1.containsKey(key)
                                            ?
                                                (frequencyS2.get(key) >= frequencyS1.get(key)
                                                ? frequencyS2.get(key) - frequencyS1.get(key)
                                                : 0)
                                            : frequencyS2.get(key)));
        return changes;
    }

    private static Map<Character, Integer> calculateFrequency(String string) {
        return string
                    .chars()
                    .mapToObj(v -> (char)v)
                    .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
    }

}
