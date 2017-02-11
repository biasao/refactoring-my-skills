import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int count = scanner.nextInt();
      int[] numbers = new int[count];

      for (int i = 0; i < count; i++) {
        numbers[i] = scanner.nextInt();
      }

      for (int i = count - 1; i >= 0; i--) {
        System.out.print(numbers[i]);
        if (i > 0) {
          System.out.print(" ");
        }
      }

      System.out.println();
    }

}
