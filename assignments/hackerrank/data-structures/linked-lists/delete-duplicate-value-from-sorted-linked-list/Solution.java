import java.io.*;
import java.util.*;

public class Solution {

    /*
    Node is defined as
      class Node {
         int data;
         Node next;
      }
    */

    Node RemoveDuplicates(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.next != null && current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

}
