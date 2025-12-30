package student;
//Anya Bhowmick

import provided.BinarySequence;

public class HuffmanCodeTree {

    /**
     * start of the tree.
     */
    private HuffmanNode root;

    /**
     * constructor.
     * @param rootX start of the tree.
     */
    public HuffmanCodeTree(HuffmanNode rootX) {
        root = rootX;
    }

    /**
     * constructor that creates a tree based off a Huffman Code Book.
     * @param codebook data the tree is based off of.
     */
    public HuffmanCodeTree(HuffmanCodeBook codebook) {
        root = new HuffmanNode(null);
        for (int i = 0; i < codebook.getCurrentSize(); i++) {
            put(codebook.getCodes()[i], codebook.getChars()[i]);
        }
    }

    /**
     * adds data to a tree.
     * @param seq "steps" (ones and zeroes) to get to the letter.
     * @param letter the letter
     */
    public void put(BinarySequence seq, char letter) {
        int length = seq.size();

        HuffmanNode curNode = root;
        for (int i = 0; i < length; i++) {
            if (!seq.get(i)) {
                if (!curNode.isValidNode()) {
                    curNode.setZero(new HuffmanNode(null));
                }
                curNode = curNode.getZero();
            } else {
                if (!curNode.isValidNode()) {
                    curNode.setOne(new HuffmanNode(null));
                }
                curNode = curNode.getOne();
            }
        }
        curNode.setData(letter);
    }


    /**
     * decodes a binary sequence based off a given codebook and tree.
     * @param s the binary sequence being decoded.
     * @return decoded version
     */
    public String decode(BinarySequence s) {
        HuffmanNode node = root;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.size(); i++) {
            if (node.isLeaf()) {
                output.append(node.getData());
                node = root;
            }
            if (s.get(i)) {
                node = node.getOne();
            } else {
                node = node.getZero();
            }
        }

        return output.toString();
    }

    /**
     * checks if a tree is valid.
     * @return true if valid.
     */
    public boolean isValid() {
        return root.isValidTree();
    }

}
