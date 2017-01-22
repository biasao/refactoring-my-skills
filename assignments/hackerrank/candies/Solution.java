import java.io.*;
import java.util.*;

public class Solution {

  private static final boolean DEBUG = false;

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
      //debug("rate -> " + rates[student]);
      numberOfCandiesToStudent = calculateNumberOfCandiesToStudentRecursively(
                                    numberOfCandiesToStudent,
                                    numberOfStudents,
                                    previousStudent,
                                    nextStudent,
                                    student,
                                    rates);

      debug("rate -> " + rates[student] + ", candies -> " + numberOfCandiesToStudent);
      //debug("----------------------------------------");
      candiesToBuy += numberOfCandiesToStudent;
    }

    System.out.println(candiesToBuy);
  }

  private static int calculateNumberOfCandiesToStudentRecursively(
      int numberOfCandiesToStudent,
      int numberOfStudents,
      int previousStudent,
      int nextStudent,
      int student,
      int[] rates) {
    // lower boundary
    if (previousStudent < 0) {
      //debug("lower boundary");
      return rates[student] <= rates[nextStudent] ? 1 : 2;
    }

    // higher boundary
    if (nextStudent >= numberOfStudents) {
      //debug("higher boundary");
      return rates[student] <= rates[previousStudent] ? 1 : numberOfCandiesToStudent + 1;
    }

    // valley
    if (rates[student] <= rates[previousStudent] && rates[student] < rates[nextStudent]) {
      //debug("valley");
      return 1;
    }

    // equal
    if (rates[student] <= rates[previousStudent] && rates[student] == rates[nextStudent]) {
      //debug("equal");
      return 1;
    }

    // climbing up
    if (rates[student] > rates[previousStudent] && rates[student] < rates[nextStudent]) {
      //debug("climbing up");
      numberOfCandiesToStudent += 1;
      return numberOfCandiesToStudent;
    }

    // climbing down
    if (rates[student] <= rates[previousStudent] && rates[student] >= rates[nextStudent]) {
      //debug("climbing down");
      numberOfCandiesToStudent -= 1;
      return 1 + calculateNumberOfCandiesToStudentRecursively(
                    numberOfCandiesToStudent,
                    numberOfStudents,
                    student,
                    nextStudent + 1,
                    nextStudent,
                    rates);
    }

    // hill
    //debug("hill");
    int candiesForNext = calculateNumberOfCandiesToStudentRecursively(
                  numberOfCandiesToStudent,
                  numberOfStudents,
                  student,
                  nextStudent + 1,
                  nextStudent,
                  rates);
    //debug("candiesForNext -> " + candiesForNext + ", numberOfCandiesToStudent -> "+ numberOfCandiesToStudent);
    return candiesForNext > numberOfCandiesToStudent ? ++candiesForNext : ++numberOfCandiesToStudent;
  }

  private static void debug(String message) {
    if (DEBUG) {
      System.out.println(message);
    }
  }

}
