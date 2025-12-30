package student;

public class CardPile {

    /**
     * top card that players' cards are compared to.
     */
    private Card topCard;

    /**
     * number of cards players have played.
     */
    private int size;

    /**
     * constructor by defining topCard.
     * @param topCardX topcard
     */
    public CardPile(Card topCardX) {
        topCard = topCardX;
        size = 1;
    }

    /**
     * checks if a card can legally be played.
     * @param card card being checked
     * @return true if playable
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        } else if (card.getSuitName().equals(topCard.getSuitName())) {
            return true;
        } else {
            return card.getRankNum() >= topCard.getRankNum();
        }
    }


    /**
     * checks if a card can legally be played, replaces top card and updates size.
     * @param card card being played
     */
    public void play(Card card) {
        if (canPlay(card)) {
            topCard = card;
            size++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    /**
     * returns number of cards players have played.
     * @return int cards played
     */
    public int getNumCards() {
        return size;
    }

    /**
     * returns top card variable.
     * @return card variable
     */
    public Card getTopCard() {
        return topCard;
    }



}
