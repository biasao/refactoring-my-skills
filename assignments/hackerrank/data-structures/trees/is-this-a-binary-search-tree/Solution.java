import java.io.*;
import java.util.*;

public class Solution {

    // Given binary tree
    //       3
    //     /  \
    //    /    \
    //   5      2
    //  / \    / \
    // 1  4   6  null
    // It is not a binary search tree because:
    // - 5 is greater than 3 and is on the left
    // - 2 is less than 3 and is on the right

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
                    new Node(2,
                        new Node(1, null, null),
                        new Node(4, null, null)),
                    new Node(6,
                        new Node(5, null, null),
                        new Node(7, null, null)));
        System.out.println(solution.checkBST(root));

        root = new Node(4,
                    new Node(2,
                        new Node(1, null, null),
                        new Node(3, null, null)),
                    new Node(6,
                        new Node(5, null, null),
                        new Node(7, null, null)));
        System.out.println(solution.checkBST(root));

        // 3
        // 1 2 3 4 5 6 7 8 9 10 11 13 12 14 15

        root = new Node(8,
                    new Node(4,
                        new Node(2,
                            new Node(1, null, null),
                            new Node(3, null, null)),
                        new Node(6,
                            new Node(5, null, null),
                            new Node(7, null, null))),
                    new Node(13,
                        new Node(10,
                            new Node(9, null, null),
                            new Node(11, null, null)),
                        new Node(14,
                            new Node(12, null, null),
                            new Node(15, null, null))));
        System.out.println(solution.checkBST(root));
    }

    // Hackerrank solution starts here.
    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.
    The Node class is defined as follows:
        class Node {
            int data;
            Node left;
            Node right;
         }
    */
    boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }

        return checkBSTLeft(root, root.left) && checkBSTRight(root, root.right);
    }

    boolean checkBSTLeft(Node root, Node node) {
        if (node == null) {
            return true;
        }

        // It is not clear whether duplicates are allowed on the binary search tree.
        // I'm considering that duplicates aren't allowed.
        boolean canBeBST = node.data < root.data
                            && (node.left == null
                                || node.left.data < node.data)
                            && (node.right == null
                                || (node.right.data > node.data && node.right.data < root.data));

        return canBeBST
                && checkBSTLeft(root, node.left)
                && checkBSTLeft(root, node.right);
    }

    boolean checkBSTRight(Node root, Node node) {
        if (node == null) {
            return true;
        }

        // It is not clear whether duplicates are allowed on the binary search tree.
        // I'm considering that duplicates aren't allowed.
        boolean canBeBST = node.data > root.data
                            && (node.left == null
                                || (node.left.data < node.data && node.left.data > root.data))
                            && (node.right == null
                                || node.right.data > node.data);

        return canBeBST
                && checkBSTRight(root, node.left)
                && checkBSTRight(node, node.right);
    }

}
