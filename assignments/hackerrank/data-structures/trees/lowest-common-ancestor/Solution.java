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

        @Override
        public String toString() {
            return String.valueOf(data);
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

        v1 = 1;
        v2 = 2;
        root = new Node(4,
                    new Node(2,
                        new Node(1),
                        new Node(3)),
                    new Node(6,
                        new Node(5),
                        new Node(8,
                            null,
                            new Node(9))));

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
       List<Node> pathV1 = findAncestors(root, v1);
       List<Node> pathV2 = findAncestors(root, v2);

       int pathV1Size = pathV1.size();
       int pathV2Size = pathV2.size();
       int greatestPathSize = pathV1Size > pathV2Size ? pathV1Size : pathV2Size;
       Node ancestor = root;

       for (int i = 1; i < greatestPathSize; i++) {
           if (i >= pathV1Size || i >= pathV2Size || (pathV1.get(i) != pathV2.get(i))) {
               return ancestor;
           }

           ancestor = pathV1.get(i);
       }

       return ancestor;
   }

   static List<Node> findAncestors(Node root, int value) {
       List<Node> path = new ArrayList<>();
       Node current = root;

       while (true) {
           path.add(current);

           if (value == current.data) {
                break;
           }

           current = value <= current.data ? current.left : current.right;
       }

       return path;
   }

}
