package student;

public class UnoWarMatch {

    /**
     * player 1.
     */
    private AI ai1;

    /**
     * player 2.
     */
    private AI ai2;

    /**
     * constructor, game played with two AIs.
     * @param ai1X player 1
     * @param ai2X player 2
     */
    public UnoWarMatch(AI ai1X, AI ai2X) {
        ai1 = ai1X;
        ai2 = ai2X;
    }

    /**
     * plays the game with two AIs.
     * @return true if AI won the tournament, false if otherwise
     */
    public boolean playGame() {
        int point1 = 0; //ONLY points for AI1
        int point2 = 0;

        AI first = ai1;
        AI sec = ai2;
        boolean tournamentDone = false;

        while (!tournamentDone) {
            Deck deck = new Deck();
            Hand hand1 = new Hand(deck, 5);
            Hand hand2 = new Hand(deck, 5);
            CardPile cPile = new CardPile(deck.draw());
            // top card is the first card AFTER assigning hands

            boolean roundDone = false;
            while (!roundDone) {
                Card firstPlay = first.getPlay(hand1, cPile);
                if (firstPlay == null) {
                    first = ai2;
                    sec = ai1;
                    point2++;
                    roundDone = true;
                } else {
                    cPile.play(firstPlay);
                    hand1.remove(firstPlay);
                }

                Card secPlay = sec.getPlay(hand2, cPile);
                if (secPlay == null) {
                    first = ai1;
                    sec = ai2;
                    point1++;
                    roundDone = true;
                } else {
                    cPile.play(secPlay);
                    hand2.remove(secPlay);
                }
                if (deck.isEmpty()) {
                    deck = new Deck();
                }
            }


            if (point1 == 10 || point2 == 10) {
                tournamentDone = true;
            }

        }

        return point1 == 10;
    }


    /**
     * returns the number of times ai1 wins in nTrials trials.
     * @param nTrials number of trials
     * @return decimal representing win rate
     */
    public double winRate(int nTrials) {
        int ai1Wins = 0;
        for (int i = 0; i < nTrials; i++) {
            if (playGame()) {
                ai1Wins++;
            }
        }
        return (double) ai1Wins / nTrials;
    }
}
