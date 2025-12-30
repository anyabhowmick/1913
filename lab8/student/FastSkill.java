package student;

public class FastSkill extends Skill{

    public FastSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }

    @Override
    public void applyChanges(CodeMonster me, CodeMonster foe) {
        super.applyChanges(me, foe);
        me.setNextTurnTime(me.getNextTurnTime() - me.getSpeedScore());
    }



}
