package student;

public class BiggestCardAI extends AI {

    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card biggest = super.getPlay(hand, cardPile);
        for (int i = 0; i < hand.getSize(); i++) {
            Card play;
            if (cardPile.canPlay(hand.get(i))) {
                play = hand.get(i);

                if (biggest.getRankNum() <= play.getRankNum()) {
                    biggest = hand.get(i);
                }
            }
        }
        return biggest;
    }

    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
