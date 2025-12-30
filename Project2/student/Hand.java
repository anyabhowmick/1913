package student;

public class Hand {

    /**
     * deck from which the hand is created.
     */
    private Deck deck;

    /**
     * size of the hand.
     */
    private int size;

    /**
     * hand.
     */
    private Card[] hand;

    /**
     * constructor, creates a hand from the given deck.
     * @param deckX deck from which the hand is created
     * @param sizeX size of hand
     */
    public Hand(Deck deckX, int sizeX) {
        deck = deckX;
        size = sizeX;
        hand = new Card[size];

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                hand[i] = deck.draw();
            }
        }
    }

    /**
     * returns the size of the hand.
     * @return int size
     */
    public int getSize() {
        return size;
    }

    /**
     * returns card at given index i if it's a valid index.
     * @param i index of card being retrieved
     * @return card at index i
     */
    public Card get(int i) {
        if (i < size && i >= 0) {
            return hand[i];
        } else {
            System.out.println("Invalid hand index!");
            return hand[0];
        }
    }

    /**
     * removes the given card from the hand.
     * @param card card being removed.
     * @return false if card isn't found, true if otherwise
     */
    public boolean remove(Card card) {
        for (int i = 0; i < size; i++) {
            if (hand[i].equals(card)) {
                hand[i] = deck.draw();
                return true;
            }
        }
        return false;
    }

}
