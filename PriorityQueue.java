/**
 * 
 * This class is a priority queue that inserts elements at random into the queue
 * such that the queue contains highest element at the end sorted List.
 * 
 * This class traverses the Huffman tree in preorder to write the tree, it's
 * preorder traversal order, and the code of each letter to the output file.
 * 
 * @version 18 April 2016
 * @author Eric Vogel
 *
 */
public class PriorityQueue {
    private Node first;

    /**
     * Priority queue constructor.
     */
    public PriorityQueue() {
        first = null;
    }

    /**
     * Checks to see if the priority queue is empty.
     * 
     * @return return the node if it is empty.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 
     * Method to insert into the priority queue.
     * 
     * @param k: node being inserted
     */
    public void insert(Node k) {
        Node previous = null;
        Node current = first;
        // If the node being inserted has a higher value.
        while (current != null && k.value > current.value) {
            previous = current;
            current = current.next;
        }
        // If the node being inserted has same value.
        if (current != null && k.value == current.value) {
            // If the node being inserted has more letters.
            if (k.letter.length() > current.letter.length()) {
                previous = current;
                current = current.next;
            }
            // If the node being inserted has same value and same number of
            // letters.
            if (k.value == current.value
                    && k.letter.length() == current.letter.length()) {
                // If the node being inserted has is higher alphabetically.
                if (k.letter.compareTo(current.letter) > 0) {
                    previous = current;
                    current = current.next;
                }
            }
        }
        if (previous == null)
            first = k;
        else
            previous.next = k;
        k.next = current;
    }

    /**
     * 
     * Method to remove from the priority queue.
     * 
     * @return returns the highest priority node.
     */
    public Node pop() {
        Node temp = first;
        first = first.next;
        return temp;
    }
}
