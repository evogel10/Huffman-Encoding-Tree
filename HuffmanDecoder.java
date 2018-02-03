/**
 * 
 * This class is used to decode a string message from an input file.
 * 
 * @version 18 April 2016
 * @author Eric Vogel
 *
 */
public class HuffmanDecoder {

    private String letterCode = ""; // String of the building letter code.
    private String decodeCode = ""; // String of the letter for one letter code.
    private String message = ""; // String that contains the decoded message

    int j = 0; // Keeps track of how long the message is.
    int k = 0; // Keeps track of the previous message.

    /**
     * 
     * This method reads the string message one char at a time and passes the
     * code to the decoder method to get the letter.
     * 
     * @param line: string message being decoded.
     * @param root: root of the Huffman tree.
     * @return returns the decoded message.
     */
    public String stringToDecodeReader(String line, Node root) {
        k = 0;
        k = message.length();
        // Reads chars one at a time as long as there are numbers to read from
        // the string.
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            // Turns the char into a string.
            String s = String.valueOf(c);

            letterCode = letterCode + s;
            // Adds to the encoded message for each letter in the string.
            message = message + decoder(root, letterCode);

            if (message.length() != j) {
                letterCode = "";
                decodeCode = "";
                ++j;
            }

        }
        // String of the message removing the previous message.
        String message2 = message.substring(k);
        // Returns a string of the entire encoded message
        return message2;
    }

    /**
     * 
     * This method recursively traverses the Huffman tree and compares the code
     * to the leaves of the tree to try and find the corresponding code.
     * 
     * @param root: root of the Huffman tree.
     * @param letterCode: the code to be compared to the leaves.
     * @return returns the letter of the code.
     */
    public String decoder(Node root, String letterCode) {

        // At the end of the traversal the program returns the code.
        if (root.left == null || root.right == null) {
            if (root.code.equals(letterCode)) {
                decodeCode = root.letter;
            }
            // Recursively traverses the tree in preoder to look for the letter
            // code in the tree.
        } else {
            if (root.left != null) {
                decoder(root.left, letterCode);
            }
            if (root.right != null) {
                decoder(root.right, letterCode);
            }
        }
        // Returns the letter of the node.
        return decodeCode;
    }

}
