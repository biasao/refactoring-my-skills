import java.io.*;
import java.util.*;

public class Solution {

  static class Node {
     int data;
     Node next;
     Node prev;

     public String toString() {
       return String.valueOf(data);
     }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    Node head = new Node();
    head.data = 1;

    Node next2 = new Node();
    next2.data = 2;

    Node next3 = new Node();
    next3.data = 3;

    head.next = next2;
    next2.prev = head;
    next2.next = next3;
    next3.prev = next2;

    Node newHead = solution.Reverse(head);
    Node current = newHead;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }

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
  Node Reverse(Node head) {
    Node current = head;
    Node newHead = null;

    while (current != null) {
      Node prev = current.prev;
      Node next = current.next;

      current.prev = next;
      current.next = prev;

      newHead = current;
      current = next;
    }

    return newHead;
  }

}
