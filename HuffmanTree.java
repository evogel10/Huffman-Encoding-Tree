/**
 * 
 * This class reads an array of letters and an array of values and passes the
 * information into nodes. The nodes are then stored in a priority queue. The
 * least 2 nodes are then taken out, combined to create a parent node, and the
 * combined node is put back into the queue. This is done until the root node is
 * found and returned.
 * 
 * @version 18 April 2016
 * @author Eric Vogel
 *
 */
public class HuffmanTree {
    // Returns root node to pass to printFromPreOrder

    /**
     * 
     * This method takes into two arrays of letters and values and creates the
     * nodes of a Huffman encoding tree.
     * 
     * @param values: frequency of each letter
     * @param letters: letters of the frequency table
     * @return root node of tree
     */
    public Node makeHuffmanTree(Integer values[], String letters[]) {
//        PriorityQueue<Node> queue = new PriorityQueue<Node>();
//        // Each letter and value is passed into a node.
//        for (int i = 0; i < letters.length; i++) {
//            // New node is created from each letter and value.
//            Node n = new Node(letters[i], values[i]);
//            queue.add(n);
        
        PriorityQueue queue = new PriorityQueue();
        // Each letter and value is passed into a node.
        for (int i = 0; i < letters.length; i++) {
            // New node is created from each letter and value.
            Node n = new Node(letters[i], values[i]);
            queue.insert(n);
        }
        Node root = null;
        // Loops through all the nodes in the queue.
        for (int i = 0; i < letters.length - 1; i++) {
            
            Node least2 = queue.pop();
            Node least1 = queue.pop();
            Node combined = new Node(least1.letter + least2.letter,
                    least1.value + least2.value);
            combined.right = least1;
            combined.left = least2;
            least1.parent = combined;
            least2.parent = combined;
            queue.insert(combined);
            // The root is replaced each time until the last node of the queue
            // is taken off.
            root = combined;

        }
        return root;
    }
}