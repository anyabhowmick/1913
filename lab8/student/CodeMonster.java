package student;

import static java.time.zone.ZoneRulesProvider.refresh;

public class CodeMonster {
    private String name;
    private int HP;
    private int maxHP;
    private Skill[] moves;
    private int moveIndex;
    private double speedScore;
    private double nextTurnTime;

    public CodeMonster(int maxHPx, double speedScr, String nameX, Skill[] movesX) {
        maxHP = maxHPx;
        HP = maxHP;
        speedScore = speedScr;
        nextTurnTime = speedScr;
        name = nameX;
        moves = movesX;
        moveIndex = 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return HP;
    }

    public int getMaxHp() {
        return maxHP;
    }

    public Skill[] getMoves() {
        return moves;
    }

    public double getSpeedScore() {
        return speedScore;
    }

    public double getNextTurnTime() {
        return nextTurnTime;
    }

    public boolean isAlive() {
        return HP > 0;
    }

    public void setNextTurnTime(double nxtTurnTime) {
        nextTurnTime = nxtTurnTime;
    }

    public String toString() {
        return name + " " + HP + "/" + maxHP;
    }


    public void adjustHealth(int amount) {
        if ((amount + HP) > maxHP) {
            HP = maxHP;
        } else if ((HP + amount) < 0) {
            HP = 0;
        } else {
            HP += amount;
        }
    }

    public Skill takeTurn() {
        nextTurnTime += speedScore;
        moveIndex++;
        if (moveIndex >= moves.length) {
            moveIndex = 0;
            return moves[moves.length - 1];
        }
        return moves[moveIndex - 1];
    }

    public void prepForBattle() {
        HP = maxHP;
        nextTurnTime = speedScore;
        moveIndex = 0;
        for (Skill move : moves) {
            move.refresh();
        }
    }


}
