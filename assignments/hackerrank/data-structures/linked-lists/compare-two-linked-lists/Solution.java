import java.io.*;
import java.util.*;

public class Solution {

    /*
      Compare two linked lists A and B
      Return 1 if they are identical and 0 if they are not.
      Node is defined as
      class Node {
         int data;
         Node next;
      }
    */
    int CompareLists(Node headA, Node headB) {
        if ((headA == null && headB != null) || (headA != null && headB == null)) {
            return 0;
        }

        if (headA == null && headB == null) {
            return 1;
        }

        Node currentA = headA;
        Node currentB = headB;
        while (currentA != null) {
            if (currentB == null) {
                return 0;
            }

            if (currentA.data != currentB.data) {
                return 0;
            }

            currentA = currentA.next;
            currentB = currentB.next == null ? null : currentB.next;
        }

        return currentA == null && currentB == null ? 1 : 0;
    }

}
