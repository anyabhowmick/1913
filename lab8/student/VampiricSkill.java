package student;

public class VampiricSkill extends Skill{
    public VampiricSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }

    @Override
    public void applyChanges(CodeMonster me, CodeMonster foe) {
        super.applyChanges(me, foe);
        me.adjustHealth(getStrength());
    }

}
