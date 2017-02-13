import java.io.*;
import java.util.*;

public class Solution {

    /*
      Delete Node at a given position in a linked list
      head pointer input could be NULL as well for empty list
      Node is defined as
      class Node {
         int data;
         Node next;
      }
    */
        // This is a "method-only" submission.
        // You only need to complete this method.

    Node Delete(Node head, int position) {
        if (head == null) {
            return null;
        }

        if (position == 0) {
            return head.next;
        }

        int i = 1;
        Node current = head;

        while (i < position) {
            current = current.next;
            i++;
        }

        current.next = current.next.next;
        return head;
    }


}
