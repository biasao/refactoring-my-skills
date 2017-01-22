import java.io.*;
import java.util.*;

public class Solution {

  private static final boolean DEBUG = false;
  private static Memo MEMO = null;

  private static class Memo {
    private int[] memo = null;

    public Memo(int numberOfStudents) {
      memo = new int[numberOfStudents + 1];
    }

    public boolean isMemoized(int student) {
      return memo[student] != 0;
    }

    public void memoize(int student, int value) {
      memo[student] = value;
    }

    public int getMemoized(int student) {
      return memo[student];
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfStudents = scanner.nextInt();
    int[] rates = new int[numberOfStudents];
    MEMO = new Memo(numberOfStudents);

    for (int i = 0; i < numberOfStudents; i++) {
      rates[i] = scanner.nextInt();
    }

    long candiesToBuy = 0;
    int numberOfCandiesToStudent = 1;
    for (int student = 0; student < numberOfStudents; student++) {
      int previousStudent = student - 1;
      int nextStudent = student + 1;
      debug("rate -> " + rates[student]);
      numberOfCandiesToStudent = MEMO.isMemoized(student)
                                ? MEMO.getMemoized(student)
                                : calculateNumberOfCandiesToStudentRecursively(
                                      numberOfCandiesToStudent,
                                      numberOfStudents,
                                      previousStudent,
                                      nextStudent,
                                      student,
                                      rates);

      debug("rate -> " + rates[student] + ", candies -> " + numberOfCandiesToStudent);
      debug("----------------------------------------");
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
      debug("lower boundary");
      return rates[student] <= rates[nextStudent] ? 1 : 1 + calculateNumberOfCandiesToStudentRecursively(
                    numberOfCandiesToStudent,
                    numberOfStudents,
                    student,
                    nextStudent + 1,
                    nextStudent,
                    rates);
    }

    // higher boundary
    if (nextStudent >= numberOfStudents) {
      debug("higher boundary");
      int value = rates[student] <= rates[previousStudent] ? 1 : numberOfCandiesToStudent + 1;
      MEMO.memoize(student, value);

      return value;
    }

    // valley or equal
    if (rates[student] <= rates[previousStudent] && rates[student] <= rates[nextStudent]) {
      debug("valley or equal");
      int value = 1;
      MEMO.memoize(student, value);

      return value;
    }

    // climbing up
    if (rates[student] >= rates[previousStudent] && rates[student] <= rates[nextStudent]) {
      debug("climbing up");
      numberOfCandiesToStudent += 1;
      int value = numberOfCandiesToStudent;
      MEMO.memoize(student, value);

      return value;
    }

    // climbing down
    if (rates[student] <= rates[previousStudent] && rates[student] >= rates[nextStudent]) {
      debug("climbing down");
      numberOfCandiesToStudent -= 1;
      int value = 1 + calculateNumberOfCandiesToStudentRecursively(
                    numberOfCandiesToStudent,
                    numberOfStudents,
                    student,
                    nextStudent + 1,
                    nextStudent,
                    rates);
      MEMO.memoize(student, value);
      return value;
    }

    // hill
    debug("hill");
    int candiesForNext = calculateNumberOfCandiesToStudentRecursively(
                  numberOfCandiesToStudent,
                  numberOfStudents,
                  student,
                  nextStudent + 1,
                  nextStudent,
                  rates);
    debug("candiesForNext -> " + candiesForNext + ", numberOfCandiesToStudent -> "+ numberOfCandiesToStudent);
    int value = candiesForNext > numberOfCandiesToStudent ? ++candiesForNext : ++numberOfCandiesToStudent;
    MEMO.memoize(student, value);

    return value;
  }

  private static void debug(String message) {
    if (DEBUG) {
      System.out.println(message);
    }
  }

}
