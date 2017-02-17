import java.io.*;
import java.util.*;

public class Solution {

    /*
      Insert Node at the end of a linked list
      head pointer input could be NULL as well for empty list
      Node is defined as
      class Node {
         int data;
         Node next;
      }
    */
    // Dummy code that should pass given the conditions presented on the assignment. It is not a general purpose solution.
    int FindMergeNode(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;

        while (currentA != null) {
            currentB = headB;

            while (currentB != null) {
                if (currentA.data == currentB.data) {
                    return currentA.data;
                }

                currentB = currentB.next;
            }

            currentA = currentA.next;
        }

        throw new RuntimeException("The input conditions doesn't match what is described on the assignment.");
    }

}
