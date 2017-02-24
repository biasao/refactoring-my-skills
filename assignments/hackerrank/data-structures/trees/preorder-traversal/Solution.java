import java.io.*;
import java.util.*;

public class Solution {

    // Pre-order
    //       3
    //    /    \
    //   5     2
    //  / \   /
    // 1  4  6
    // The correct pre-order traversal is 3 5 1 4 2 6

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
                                null, null),
                            new Node(4,
                                null, null)),
                        new Node(2,
                            new Node(6, null, null), null));

        solution.preOrder(root);
        System.out.println();
    }

    // Hackerrank solution starts here
    /* you only have to complete the function given below.
    Node is defined as

    class Node {
        int data;
        Node left;
        Node right;
    }

    */

    void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.format("%d ", root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
}
