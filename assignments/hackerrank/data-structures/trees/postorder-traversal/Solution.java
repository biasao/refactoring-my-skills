import java.io.*;
import java.util.*;

public class Solution {

    // Post-order
    //       3
    //    /    \
    //   5     2
    //  / \   /
    // 1  4  6
    // The correct post-order traversal is 1 4 5 6 2 3

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

        solution.postOrder(root);
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
    void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.format("%d ", node.data);
    }

}
