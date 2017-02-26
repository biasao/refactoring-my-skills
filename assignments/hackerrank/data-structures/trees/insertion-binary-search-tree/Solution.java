import java.io.*;
import java.util.*;

public class Solution {

    // Expected tree after insertion. I'll use pre-order to print/validate the tree.
    //      4
    //    /   \
    //   2     7
    //  / \   /
    // 1   3 6
    // Expected output after insertion -> 4 2 1 3 7 6

    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.format("%d ", root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(4,
                        new Node(2,
                            new Node(1,
                                null,
                                null),
                            new Node(3,
                                null,
                                null)),
                        new Node(7,
                            null,
                            null));

        root = Insert(root, 6);
        preOrder(root);
        System.out.println();
    }

    // Hackerrank solution starts here.
    /* Node is defined as :
        class Node
            int data;
            Node left;
            Node right;

    */

   static Node Insert(Node node, int value) {
       Node newNode = new Node();
       newNode.data = value;

       if (node == null) {
           return newNode;
       }

       if (value <= node.data) {
           node.left = Insert(node.left, value);
       } else {
           node.right = Insert(node.right, value);
       }

       return node;
   }

}
