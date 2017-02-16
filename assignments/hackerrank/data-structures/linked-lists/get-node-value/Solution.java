import java.io.*;
import java.util.*;

public class Solution {

    /*
      Get Nth element from the end in a linked list of integers
      Number of elements in the list will always be greater than N.
      Node is defined as
      class Node {
         int data;
         Node next;
      }
    */

    int GetNode(Node head,int n) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        current = head;
        for (int i = count - 1; i > n; i--) {
            current = current.next;
        }

        return current.data;
    }

}
