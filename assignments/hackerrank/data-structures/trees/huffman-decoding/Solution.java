import java.io.*;
import java.util.*;

public class Solution {

    // Huffman decoding
    //          {ϕ,5}
    //       0 /     \ 1
    //      {ϕ,2}   {A,3}
    //    0/   \1
    // {B,1}  {C,1}
    // 1001011 = ABACA

    static class Node {
        int frequency;
        char data;
        Node left;
        Node right;

        Node(int frequency, char data, Node left, Node right) {
            this.frequency = frequency;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String encoded = "1001011";
        Node root = new Node(5, '\u0000',
                        new Node(2, '\u0000',
                            new Node(1, 'B',
                                null,
                                null),
                            new Node(1, 'C',
                                null,
                                null)),
                        new Node(3, 'A',
                            null,
                            null));

        solution.decode(encoded, root);
    }

    // Hackerrank solution starts here.
    /*
    class Node
       public int frequency; // the frequency of this tree
       public char data;
       public Node left, right;
    */

    void decode(String encoded, Node root) {
        StringBuilder decoded = new StringBuilder();
        Node current = root;
        char[] encodedCharArray = encoded.toCharArray();
        for (int i = 0; i < encodedCharArray.length; i++) {
            char c = encodedCharArray[i];
            Node node = c == '0' ? current.left : current.right;

            if (node.data == '\u0000') {
                current = node;
            } else {
                decoded.append(node.data);
                current = root;
            }
        }

        System.out.println(decoded.toString());
    }

}
