import java.io.*;
import java.util.*;

public class Solution {

    /*
    Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

    A Node is defined as:
        class Node {
            int data;
            Node next;
        }
    */

    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node current = head;
        final int maxIterations = 100;
        int iterations = 0;

        while (current != null) {
            Node other = current.next;
            iterations++;
            if (iterations > maxIterations) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

}
