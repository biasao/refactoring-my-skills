import java.io.*;
import java.util.*;

public class Solution {

    /*
      Merge two linked lists
      head pointer input could be NULL as well for empty list
      Node is defined as
      class Node {
         int data;
         Node next;
      }
    */

    Node MergeLists(Node headA, Node headB) {
        if (headA == null && headB == null) {
            return null;
        }

        if (headA == null) {
            return headB;
        }

        if (headB == null) {
            return headA;
        }

        Node currentA = headA;
        Node currentB = headB;
        Node newHead = null;
        if (currentA.data < currentB.data) {
            newHead = currentA;
            currentA = currentA.next;
        } else {
            newHead = currentB;
            currentB = currentB.next;
        }

        Node current = newHead;
        while (currentA != null && currentB != null) {
            if (currentA.data < currentB.data) {
                current.next = currentA;
                currentA = currentA.next;
            } else {
                current.next = currentB;
                currentB = currentB.next;
            }

            current = current.next;
        }

        current.next = currentA == null ? currentB : currentA;

        return newHead;
    }

}
