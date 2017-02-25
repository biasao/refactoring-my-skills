import java.io.*;
import java.util.*;

public class Solution {

    // Tree
    //      3
    //    /   \
    //   5     2
    //  / \   / \
    // 1   4 6   7
    // \       /
    //  9     8
    // Top View : 1 -> 5 -> 3 -> 2 -> 7

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
                                new Node(9,
                                    null,
                                    null)),
                            new Node(4,
                                null,
                                null)),
                        new Node(2,
                            new Node(6,
                                null,
                                null),
                            new Node(7,
                                new Node(8,
                                    null,
                                    null),
                                null)));

        solution.top_view(root);
        System.out.println();
    }

    // Hackerrank solution starts here.
    /*
       class Node
           int data;
           Node left;
           Node right;
    */
    void top_view(Node root)
    {
        if (root == null) {
            return;
        }

        Deque<Node> leftStack = new LinkedList<>();
        Deque<Node> rightStack = new LinkedList<>();

        Node current = root.left;
        while (current != null) {
            leftStack.addLast(current);
            current = current.left;
        }

        current = root.right;
        while (current != null) {
            rightStack.addLast(current);
            current = current.right;
        }

        while (leftStack.size() > 0) {
            Node node = leftStack.removeLast();
            System.out.format("%d ", node.data);
        }

        System.out.format("%d ", root.data);

        while (rightStack.size() > 0) {
            Node node = rightStack.removeFirst();
            System.out.format("%d ", node.data);
        }
    }

}
