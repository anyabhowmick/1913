package student;

public class SmallestCardAI extends AI {
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card smallest = super.getPlay(hand, cardPile); //first playable card

        for (int i = 0; i < hand.getSize(); i++) {
            Card play;
            if (cardPile.canPlay(hand.get(i))) {
                play = hand.get(i);

                if (smallest.getRankNum() >= play.getRankNum()) {
                    smallest = hand.get(i);
                }
            }
        }
        return smallest;
    }

    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}
