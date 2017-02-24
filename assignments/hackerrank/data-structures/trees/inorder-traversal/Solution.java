import java.io.*;
import java.util.*;

public class Solution {
    // In-order
    //       3
    //    /    \
    //   5     2
    //  / \   /
    // 1  4  6
    // The correct in-order traversal is 1 5 4 3 6 2

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Node root = new Node(3,
                        new Node(5,
                            new Node(1,
                                null,
                                null),
                            new Node(4,
                                null,
                                null)),
                        new Node(2,
                            new Node(6,
                                null,
                                null),
                            null));

        solution.inOrder(root);
        System.out.println();
    }

    // Hackerrank solution goes here.
    /* you only have to complete the function given below.
    Node is defined as

    class Node {
        int data;
        Node left;
        Node right;
    }

    */

    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.format("%d ", node.data);
        inOrder(node.right);
    }
}
