/**
 * 
 * This class traverses the Huffman tree in preorder to write the tree, it's
 * preorder traversal order, and the code of each letter to the output file.
 * 
 * @version 18 April 2016
 * @author Eric Vogel
 *
 */
public class PreOrderTraversalGenerator {

    private String preorder = "";
    private String tree = "";
    private String code = "";

    /**
     * 
     * This method recursively traverses the Huffman tree in preorder to write
     * the tree and it preorder order to the output file.
     * 
     * @param n: root of the Huffman tree.
     * @param spaceLR: a black space initially passed in and is replaced by L or
     *            R depending if the the tree goes left or right.
     * @return returns the text of the Huffman tree.
     */
    public String printHuffmanTree(Node n, String spaceLR) {

        // If there is a letter the program will run.
        if (n.letter != "") {
            // String for the Huffman tree.
            tree = tree + spaceLR + n.value + ":" + n.letter + "\n";
        }

        // Recursively traverses the tree in preorder.
        if (n.left != null) {
            printHuffmanTree(n.left, spaceLR + "--L--");
        }
        if (n.right != null) {
            printHuffmanTree(n.right, spaceLR + "--R--");
        }
        // String for the preorder
        preorder = n.displayNode() + "\n" + preorder;

        // Returns string for the Huffman tree.
        return tree;
    }

    /**
     * 
     * This method recursively traverses the Huffman tree in preorder to assign
     * the code for each node and writes the code for each letter to the output
     * file.
     * 
     * @param root
     * @return
     */
    public String printPreOrderCode(Node root) {
        // At the end of the traversal the program writes the code of the
        // letter to the output file.
        if (root.left == null || root.right == null) {
            code = code + root.letter + ": " + root.code + "\n";
            // Recursively traverses the tree in preoder to assign the code for
            // each node.
        } else {
            if (root.left != null) {
                // Assigns 0 for left children.
                root.left.code = root.code + "0";
                printPreOrderCode(root.left);
            }
            if (root.right != null) {
                // Assigns 1 for right children.
                root.right.code = root.code + "1";
                printPreOrderCode(root.right);
            }
        }
        // Returns the code for each letter in a string.
        return code;
    }

    /**
     * This method returns the preorder travrsal for the Huffman tree obtained
     * from the method printHuffmanTree which was used to write the tree to the
     * file.
     * 
     * @return returns a string of the preorder traversal order.
     */
    public String preorderTree() {
        return "\nThe tree is preorder is: " + "\n" + preorder;
    }

    public void test(Node n) {
        System.out.println(n.code);
    }

}
