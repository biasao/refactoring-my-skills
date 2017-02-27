import java.io.*;
import java.util.*;

public class Solution {

    // Lowest Common Ancestor
    //        4
    //      /   \
    //     2     7
    //    / \   /
    //   1   3 6
    // LCA for v1 = 1 and v2 = 7 is 4.

    // 8
    // 8 4 9 1 2 3 6 5
    // 1 2
    //

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left, Node right) {
            this(data);
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int v1 = 1;
        int v2 = 7;
        Node root = new Node(4,
                        new Node(2,
                            new Node(1),
                            new Node(3)),
                        new Node(7,
                            new Node(6),
                            null));

        System.out.println(lca(root, v1, v2).data);

        v1 = 1;
        v2 = 2;
        root = new Node(8,
                    new Node(4,
                        new Node(1,
                            null,
                            new Node(2,
                                null,
                                new Node(3))),
                        new Node(6,
                            new Node(5),
                            null)),
                    new Node(9));

        System.out.println(lca(root, v1, v2).data);
    }

    // Hackerrank solution starts here.
    /* Node is defined as :
        class Node
           int data;
           Node left;
           Node right;
   */

   static Node lca(Node root, int v1, int v2) {
       List<Node> pathV1 = new ArrayList<>();
       Node current = root;

       // It is expected that all values are on the binary search tree.
       while (true) {
           if (v1 == current.data) {
                break;
           }

           pathV1.add(current);
           current = v1 <= current.data ? current.left : current.right;
       }

       current = root;

       for (int i = 1; i < pathV1.size(); i++) {
           if (v2 == current.data) {
               break;
           }

           current = v2 <= current.data ? current.left : current.right;

           Node nodePathV1 = pathV1.get(i);
           if (current != nodePathV1) {
               return pathV1.get(i - 1);
           }
       }

       return current;
   }

}
