/**
 * 
 * This class is used to encode a string message from an input file.
 * 
 * @version 18 April 2016
 * @author Eric Vogel
 *
 */
public class HuffmanEncoder {

    private String encoded = ""; // String of the entire encoded message.
    private String oneLetterCode = ""; // String of the code of one letter.

    /**
     * This method reads the string of the message to encode one char at a time
     * and passes the letter to the method encoder to get the code.
     * 
     * @param line: string message being encoded.
     * @param root: root of the Huffman tree.
     * @return returns the entire encoded message.
     */
    public String stringToEncodeReader(String line, Node root) {

        encoded = "";
        // Reads chars one at a time as long as there are letters to read from
        // the string.
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            // Turns the char into an upper case string.
            String s = String.valueOf(c).toUpperCase();

            // Adds to the encoded message for each letter in the string.
            encoded = encoded + encoder(root, s);
        }

        // Returns a string of the entire encoded message
        return encoded;
    }

    /**
     * 
     * This method recursively traverses the Huffman tree and compares the
     * letter to each node. If the is a match, the code is returned to the
     * stringToEncodeReader to write to the output file.
     * 
     * @param root: root node of Huffman tree.
     * @param s: letter from message.
     * @return returns the code of the letter.
     */
    public String encoder(Node root, String s) {
        // At the end of the traversal the program returns the code.
        if (root.left == null || root.right == null) {
            return oneLetterCode;
            // Recursively traverses the tree in preoder to look for the letter
            // in the tree.
        } else {
            if (root.left != null) {
                // If the letter matches the letter of the node.
                if (root.left.letter.equals(s)) {
                    oneLetterCode = root.left.code;
                } else {
                    encoder(root.left, s);
                }
            }
            if (root.right != null) {
                // If the letter matches the letter of the node.
                if (root.right.letter.equals(s)) {
                    oneLetterCode = root.right.code;
                } else {
                    encoder(root.right, s);
                }
            }
        }
        // Returns the code of the letter.
        return oneLetterCode;
    }

}
