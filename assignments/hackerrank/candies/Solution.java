import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfStudents = scanner.nextInt();
    int[] rates = new int[numberOfStudents];

    for (int i = 0; i < numberOfStudents; i++) {
      rates[i] = scanner.nextInt();
    }

    long candiesToBuy = 0;
    int numberOfCandiesToStudent = 1;
    for (int student = 0; student < numberOfStudents; student++) {
      int previousStudent = student - 1;
      int nextStudent = student + 1;
      if (previousStudent >= 0 && rates[student] > rates[previousStudent]) {
        numberOfCandiesToStudent++;
      } else if (previousStudent >= 0 && rates[student] <= rates[previousStudent]) {
        numberOfCandiesToStudent = calculateNumberOfCandiesToStudentRecursively(numberOfCandiesToStudent, numberOfStudents, nextStudent, student, rates);
      } else if (nextStudent < numberOfStudents && rates[student] > rates[nextStudent]) {
        numberOfCandiesToStudent++;
      }

      System.out.println("rate -> " + rates[student] + ", candies -> " + numberOfCandiesToStudent);
      candiesToBuy += numberOfCandiesToStudent;
    }

    System.out.println(candiesToBuy);
  }

  private static int calculateNumberOfCandiesToStudentRecursively(int numberOfCandiesToStudent, int numberOfStudents, int nextStudent, int student, int[] rates) {
    if (nextStudent < numberOfStudents && rates[student] > rates[nextStudent]) {
      return 1 + calculateNumberOfCandiesToStudentRecursively(numberOfCandiesToStudent, numberOfStudents, nextStudent + 1, nextStudent, rates);
    } else if (numberOfCandiesToStudent > 0) {
      return 1;
    } else {
      return 1 + Math.abs(numberOfCandiesToStudent);
    }
  }

}
