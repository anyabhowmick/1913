package student;

public class Battle {

    public static void doOneTurn(CodeMonster one, CodeMonster two) {
        CodeMonster myTurn = null;
        CodeMonster notMyTurn = null;
        if (one.getNextTurnTime() <= two.getNextTurnTime()) {
            myTurn = one;
            notMyTurn = two;
        } else if (one.getNextTurnTime() > two.getNextTurnTime()) {
            myTurn = two;
            notMyTurn = one;
        }

        assert myTurn != null;
        Skill usedSkill = myTurn.takeTurn();
        System.out.println(myTurn + " uses iteration " + usedSkill
                + " on " + notMyTurn);
        usedSkill.useSkill(myTurn, notMyTurn);


    }

    public static CodeMonster battle(CodeMonster one, CodeMonster two) {
        one.prepForBattle();
        two.prepForBattle();
        CodeMonster winner = null;

        System.out.println(one + " vs. " + two);
        boolean isDone = false;
        while (!isDone) {
            doOneTurn(one, two);
            if (one.getHp() <= 0) {
                System.out.println(two + " wins!");
                winner = two;
                isDone = true;
            } else if (two.getHp() <= 0) {
                System.out.println(one + " wins!");
                winner = one;
                isDone = true;
            }
        }

        return winner;
    }

}
