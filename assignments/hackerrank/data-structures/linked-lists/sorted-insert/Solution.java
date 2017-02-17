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
         Node prev;
      }
    */

    Node SortedInsert(Node head,int data) {
        if (head == null) {
            Node newHead = new Node();
            newHead.data = data;

            return newHead;
        }

        if (data <= head.data) {
            Node newHead = new Node();
            newHead.data = data;
            newHead.next = head;
            head.prev = newHead;

            return newHead;
        }

        Node current = head;
        while (current != null) {
            if (data >= current.data && current.next != null && data <= current.next.data) {
                Node newNode = new Node();
                newNode.data = data;
                newNode.prev = current;
                newNode.next = current.next;
                current.next = newNode;
                newNode.next.prev = newNode;

                return head;
            }

            if (data >= current.data && current.next == null) {
                Node newNode = new Node();
                newNode.data = data;
                newNode.prev = current;
                current.next = newNode;

                return head;
            }

            current = current.next;
        }

        return head;
    }

}
