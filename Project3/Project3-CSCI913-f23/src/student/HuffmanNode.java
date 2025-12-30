package student;
//Anya Bhowmick

public class HuffmanNode {

    /**
     * node one (right side).
     */
    private HuffmanNode one;

    /**
     * node zero (left side).
     */
    private HuffmanNode zero;

    /**
     * data in node.
     */
    private Character data;

    /**
     * constructor.
     * @param zeroX child zero
     * @param oneX child one
     */
    public HuffmanNode(HuffmanNode zeroX, HuffmanNode oneX) {
        zero = zeroX;
        one = oneX;
        data = null;
    }

    /**
     * constructor with data parameter.
     * @param dataX data
     */
    public HuffmanNode(Character dataX) {
        zero = null;
        one = null;
        data = dataX;
    }

    public HuffmanNode getOne() {
        return one;
    }

    public void setOne(HuffmanNode one) {
        this.one = one;
    }

    public HuffmanNode getZero() {
        return zero;
    }

    public void setZero(HuffmanNode zero) {
        this.zero = zero;
    }

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    /**
     * checks if a node is a leaf (data, no children).
     * @return true if leaf
     */
    public boolean isLeaf() {
        return one == null && zero == null && data != null;
    }

    /**
     * checks if a node is valid (leaf or inner node).
     * @return true if valid
     */
    public boolean isValidNode() {
        return (data != null && zero == null && one == null) || (data == null && zero != null && one != null);
    }

    /**
     * checks if a tree is valid.
     * @return true if valid.
     */
    public boolean isValidTree() {
        if (!isValidNode()) {
            return false;
        } else if (isLeaf()) {
            return true;
        }

        return one.isValidTree() && zero.isValidTree();

    }


}