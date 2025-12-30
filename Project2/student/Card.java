package student;

public class Card {

    /**
     * number on card.
     */
    private final int rank;

    /**
     * int representing suit (spades, etc).
     */
    private final int suit;


    /**
     * set with all ranks in string form.
     */
    private static final String[] RANKSET =  {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
    "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    /**
     * set with suits in string form.
     */
    private static final String[] SUITSET = {"Spades", "Hearts", "Clubs", "Diamonds"};

    /**
     * creates card with given parameters.
     * @param rankX rank
     * @param suitX suit
     */
    public Card(int rankX, int suitX) {
        if (rankX <= 0 || rankX >= 14 || suitX > 4 || suitX < 1) {
            rank = 1;
            suit = 1;
            System.out.println("Invalid Card");
        } else {
            rank = rankX;
            suit = suitX;
        }

    }

    /**
     * returns the number representing rank.
     * @return int rank
     */
    public int getRankNum() {
        return rank;
    }

    /**
     * returns suit STRING.
     * @return string suit
     */
    public String getSuitName() {
        return SUITSET[suit - 1];
    }

    /**
     * returns rank name (string).
     * @return string rank
     */
    public String getRankName() {
        return RANKSET[rank - 1];
    }

    /**
     * string format with suit and rank.
     * @return string
     */
    @Override
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    /**
     * compares an onject to a card object, compares them.
     * @param obj compared to card variable
     * @return boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof Card) {
            Card objCard = (Card) obj;
            return (this.getSuitName().equals(objCard.getSuitName()) && this.rank == objCard.rank);
        } else {
            return false;
        }
    }
}
