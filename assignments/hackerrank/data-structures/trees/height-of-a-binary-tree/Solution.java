import java.io.*;
import java.util.*;

public class Solution {

    // In-order
    //       3
    //    /    \
    //   2     5
    //  /     / \
    // 1     4   6
    //            \
    //             7
    // The correct highest branch has height of 3. The branch is 3 5 6 7.

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
        Node root = new Node(3,
                        new Node(2,
                            new Node(1,
                                null,
                                null),
                            null),
                        new Node(5,
                            new Node(4,
                                null,
                                null),
                            new Node(6,
                                null,
                                new Node(7,
                                    null,
                                    null))));


        System.out.println(height(root));
    }

    // Hackerrank solution starts here.
    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    static int height(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 0;
        }

        int heightLeft = 1 + height(node.left);
        int heightRight = 1 + height(node.right);

        return heightLeft > heightRight ? heightLeft : heightRight;
    }

}
