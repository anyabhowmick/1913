package student;
//Anya Bhowmick

import provided.BinarySequence;

// you may implement any interface you want here
public class HuffmanCodeBook {

    /**
     * list of characters in the codebook.
     */
    private char[] chars = new char[10];
    /**
     * list of corresponding codes in the book.
     */
    private BinarySequence[] codes = new BinarySequence[10];

    /**
     * number of actual codes in the code book.
     */
    private int curSize;

    /**
     * max number of codes before resizing to fit more.
     */
    private int maxSize;

    /**
     * empty constructor.
     */
    public HuffmanCodeBook() {
        curSize = 0;
        maxSize = 10;
    }

    /**
     * adds and sorts a code and its letter into the book.
     * @param c the letter
     * @param seq the code
     */
    public void addSequence(char c, BinarySequence seq) {
        curSize++;
        if (curSize >= maxSize) {
            char[] biggerChar = new char[maxSize * 2];
            BinarySequence[] biggerBS = new BinarySequence[maxSize * 2];
            for (int i = 0; i < maxSize; i++) {
                biggerChar[i] = chars[i];
                biggerBS[i] = codes[i];
            }
            chars = biggerChar;
            codes = biggerBS;
            maxSize *= 2;
        }
        chars[curSize - 1] = c;
        codes[curSize - 1] = seq;
        int leftNum = curSize - 2;
        while (leftNum >= 0 && chars[leftNum] > c) {
            char temp = chars[leftNum];
            chars[leftNum] = c;
            chars[leftNum + 1] = temp;

            BinarySequence tempBS = codes[leftNum];
            codes[leftNum] = seq;
            codes[leftNum + 1] = tempBS;

            leftNum--;
        }
    }

    /**
     * checks if the given letter is in the codebook.
     * @param letter the letter being searched for.
     * @return true if found
     */
    public boolean contains(char letter) {
        int left = 0;
        int right = curSize - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (chars[mid] == letter) {
                return true;
            } else if (chars[mid] > letter) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }


    /**
     * checks if a string of letters are all in the codebook.
     * @param letters string of letters being searched for
     * @return true if all are found
     */
    public boolean containsAll(String letters) {
        char[] split = letters.toCharArray();
        for (char c : split) {
            if (!contains(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * given a character, it finds the corresponding sequence.
     * @param c the character
     * @return the corresponding sequence
     */
    public BinarySequence getSequence(char c) {
        int left = 0;
        int right = chars.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (chars[mid] == c) {
                return codes[mid];
            } else if (chars[mid] > c) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }

    public char[] getChars() {
        return chars;
    }

    public BinarySequence[] getCodes() {
        return codes;
    }

    public int getCurrentSize() {
        return curSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    /**
     * given a string, it translates it based off the codebook.
     * @param s string being coded using binary sequences
     * @return the binary sequence translation
     */
    public BinarySequence encode(String s) {
        BinarySequence output = new BinarySequence("");
        char[] split = s.toCharArray();
        for (char c : split) {
            output.append(getSequence(c));
        }
        return output;
    }


}
