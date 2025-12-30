package student;

public class Tournament {
    /**
     * plays 9 games of UnoWar, with each AI type taking turns playing player1 and 2.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        AI randAI = new AI();
        SmallestCardAI smallCard = new SmallestCardAI();
        BiggestCardAI bigCard = new BiggestCardAI();
        int numTrials = 1000;

        /**UnoWarMatch randRand = new UnoWarMatch(randAI, randAI);
        System.out.print(randAI + " vs. " + randAI);
        randRand.playGame();
        System.out.println(" winRate: " + randRand.winRate(numTrials));

        UnoWarMatch randSmall = new UnoWarMatch(randAI, smallCard);
        System.out.print(randAI + " vs. " + smallCard);
        randSmall.playGame();
        System.out.println(" winRate: " + randSmall.winRate(numTrials));

        UnoWarMatch randBig = new UnoWarMatch(randAI, bigCard);
        System.out.print(randAI + " vs. " + bigCard);
        randBig.playGame();
        System.out.println(" winRate: " + randBig.winRate(numTrials));



        UnoWarMatch smallRand = new UnoWarMatch(smallCard, randAI);
        System.out.print(smallCard + " vs. " + randAI);
        smallRand.playGame();
        System.out.println(" winRate: " + smallRand.winRate(numTrials));

        UnoWarMatch smallSmall = new UnoWarMatch(smallCard, smallCard);
        System.out.print(smallCard + " vs. " + smallCard);
        smallSmall.playGame();
        System.out.println(" winRate: " + smallSmall.winRate(numTrials));

        UnoWarMatch smallBig = new UnoWarMatch(smallCard, bigCard);
        System.out.print(smallCard + " vs. " + bigCard);
        smallBig.playGame();
        System.out.println(" winRate: " + smallBig.winRate(numTrials));



        UnoWarMatch bigRand = new UnoWarMatch(bigCard, randAI);
        System.out.print(bigCard + " vs. " + randAI);
        bigRand.playGame();
        System.out.println(" winRate: " + bigRand.winRate(numTrials));

        UnoWarMatch bigSmall = new UnoWarMatch(bigCard, smallCard);
        System.out.print(bigCard + " vs. " + smallCard);
        bigSmall.playGame();
        System.out.println(" winRate: " + bigSmall.winRate(numTrials));

        UnoWarMatch bigBig = new UnoWarMatch(bigCard, bigCard);
        System.out.print(bigCard + " vs. " + bigCard);
        bigBig.playGame();
        System.out.println(" winRate: " + bigBig.winRate(numTrials));
        */



    }
}


