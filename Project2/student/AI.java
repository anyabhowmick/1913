package student;

public class AI {

    /**
     * finds the first playable card in the hand, returns it.
     * @param hand set of cards
     * @param cardPile card that the hand's cards are compared to
     * @return playable card
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    /**
     * prints "name".
     * @return String- ID of player
     */
    public String toString() {
        return "Random Card AI";
    }
}
