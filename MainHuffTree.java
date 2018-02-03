import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 
 * This class receives input from two files. The first file contains a Huffman
 * frequency table, the second contains strings to either encode or decode.
 * After receiving the files, the program writes to an output file the Huffman
 * Encoding tree created from the frequency table provided, an preorder
 * traversal of the tree, and the code for each letter in the frequency table.
 * Next the program writes to the output file the encoded or decoded string from
 * the second input file.
 * 
 * @version 18 April 2016
 * @author Eric Vogel
 *
 */
public class MainHuffTree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Prompts the User for the input file containing the frequency table.
        System.out.print("Please Enter input File Name containing "
                + "Frequency Table: ");
        String frequencyTableFile = sc.next();
        // Prompts the User for the input file containing the strings to encode
        // or decode.
        System.out.print("Please Enter input File Name containing the "
                + "Strings to encode/decode: ");
        String encodeDecodeFile = sc.next();
        // Prompts the User for the output file.
        System.out.print("Please Enter output File Name: ");
        String outputFileName = sc.next();
        sc.close();

        try {
            // FileReader reads text file in containing the frequency table.
            FileReader fileReader = new FileReader(frequencyTableFile);
            // FileReader reads text file in containing the strings to encode or
            // decode.
            FileReader fileReader2 = new FileReader(encodeDecodeFile);
            // FileWriter writes the text files into the output file.
            FileWriter fileWriter = new FileWriter(outputFileName);

            // Reads text from a character-input stream.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            // Writes text to a character-output stream.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Created a HuffmanTree object to read frequency table input into a
            // priority queue.
            HuffmanTree huffTree = new HuffmanTree();
            // Created a PreOrderTraversalGenerator object to create a binary
            // tree to traverse in preorder.
            PreOrderTraversalGenerator preOrder = new PreOrderTraversalGenerator();
            // Created a HuffmanEncoder object to encode the strings from the
            // text file.
            HuffmanEncoder encoder = new HuffmanEncoder();

            HuffmanDecoder decoder = new HuffmanDecoder();

            // Made an array list of strings an integers to store the letters
            // and their frequencies.
            ArrayList<String> letters = new ArrayList<String>();
            ArrayList<Integer> values = new ArrayList<Integer>();

            // While the file still is not empty, the program will continue to
            // read it.
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    // The letters and values are split by the delimiter "-" and
                    // stored in an array.
                    String[] feqTableElements = line.split("-");

                    // Elements of the array String[] are passed into either the
                    // array lists letters or values.
                    letters.add(feqTableElements[0]);
                    values.add(Integer.parseInt(feqTableElements[1]));
                }
            }
            // letters and values are passed into two separate arrays with sizes
            // corresponding the the size of the array lists.
            Integer[] frequencies = values.toArray(new Integer[values.size()]);
            String[] text = letters.toArray(new String[letters.size()]);

            // Root of the Huffman tree is as well as all of the nodes in the
            // tree.
            Node root = huffTree.makeHuffmanTree(frequencies, text);
            bufferedWriter.write("\nFor the Huffman Encoding Tree below:\n"
                    + "R - Right Child\nL - Left Child\n");
            bufferedWriter.write("Root-");
            // Writes to the output file the Huffman tree.
            bufferedWriter.write(preOrder.printHuffmanTree(root, ""));
            // Writes to the output file the preorder traversal of the tree.
            bufferedWriter.write(preOrder.preorderTree());
            bufferedWriter.write("\nThe code is:\n");
            // Writes to the output file the code of each letter.
            bufferedWriter.write(preOrder.printPreOrderCode(root));

            // While the file still is not empty, the program will continue to
            // read it.
            while (bufferedReader2.ready()) {
                String line = bufferedReader2.readLine();
                if (line != null) {
                    bufferedWriter.write("\nMessage: " + line + "\n");
                    // Removes the while space from the strings.
                    line = line.replaceAll("\\W", "");
                    // If the string only has letters, the program will encode
                    // it.
                    if (Pattern.matches("[a-zA-Z]+", line)) {
                        bufferedWriter.write("Encoded Message: ");
                        bufferedWriter.write(encoder.stringToEncodeReader(line,
                                root) + "\n");
                    } else if (Pattern.matches("[0-1]+", line)) {
                         bufferedWriter.write("Decoded Message: ");
                         bufferedWriter.write(decoder.stringToDecodeReader(line,
                         root) + "\n");
                    } else {
                        bufferedWriter.write("Invalid Message!" + "\n");
                    }
                }
            }

            // Closes files.
            bufferedReader.close();
            bufferedReader2.close();
            bufferedWriter.close();

            // Used if the input file can't opened.
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file.");

            // Used if there is an error reading the input file.
        } catch (IOException ex) {
            System.out.println("Error reading file.");

        }
    }
}
