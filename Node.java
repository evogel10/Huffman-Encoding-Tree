/**
 * 
 * This class creates a node object to be used to store information of the
 * frequency table, create the Huffman tree, and store additinal information.
 * 
 * @version 18 April 2016
 * @author Eric Vogel
 *
 */
public class Node implements Comparable<Node> {
    Node left;
    Node right;
    Node parent;
    Node next;
    String letter;
    int value;
    String code = "";

    /**
     * 
     * Node constructor with the letter and value as parameters.
     * 
     * @param letter
     * @param value
     */
    public Node(String letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    /**
     * 
     * Node constructor with the value as a parameter.
     * 
     * @param letter
     * @param value
     */
    public Node(int value) {
        letter = "";
        this.value = value;
    }

    /**
     * 
     * This method displays the letter and value of the node.
     * 
     * @return returns a string of the information.
     */
    public String displayNode() {
        return letter + ":" + value + " ";
    }

    /**
     * 
     * This method displays the letter node.
     * 
     * @return returns a string of the information.
     */
    public String displayLetter() {
        return letter;
    }

    /**
     * 
     * This method displays the code of the node.
     * 
     * @return returns a string of the information.
     */
    public String displayCode() {

        return code;
    }

    /**
     * 
     * This method compares the value of one node to another.
     * 
     * @return returns -1 if greater, 1 if less, and 0 if equal.
     * 
     */
    public int compareTo(Node n) {
        if (value < n.value) {
            return -1;
        } else if (value > n.value) {
            return 1;
        }
        return 0;
    }
}