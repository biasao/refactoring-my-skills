import java.io.*;
import java.util.*;

public class Solution {

    /*
      Insert Node at a given position in a linked list
      head can be NULL
      First element in the linked list is at position 0
      Node is defined as
      class Node {
         int data;
         Node next;
      }
    */


    Node InsertNth(Node head, int data, int position) {
        if (position == 0 || head == null) {
            Node node = new Node();
            node.data = data;
            node.next = head;

            return node;
        }

        int i = 1;
        Node current = head;
        while (i < position) {
            current = current.next;
            i++;
        }

        Node node = new Node();
        node.data = data;
        node.next = current.next;
        current.next = node;

        return head;
    }

}
