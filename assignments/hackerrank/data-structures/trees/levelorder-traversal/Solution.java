import java.io.*;
import java.util.*;

public class Solution {

    // Level order traversal
    // ---
    // Level 1:        3
    //               /   \
    // Level 2:     5     2
    //             / \    /
    // Level 3:   1   4  6
    //
    // The correct output is 3 5 2 1 4 6

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
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

        solution.LevelOrder(root);
        System.out.println();
    }

    // Hackerrank solution starts here.
    /*

     class Node
        int data;
        Node left;
        Node right;
    */
    void LevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (true) {
            int currentLevelSize = nodes.size();
            if (currentLevelSize == 0) {
                break;
            }

            while (currentLevelSize > 0) {
                Node node = nodes.remove();
                System.out.format("%d ", node.data);

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }

                currentLevelSize--;
            }
        }
    }

}
