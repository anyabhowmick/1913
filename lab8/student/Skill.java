package student;

public class Skill {

    /**
     * skill name.
     */
    private String name;

    /**
     * strength value.
     */
    private int strength;

    /**
     * max times skill can be used.
     */
    private int usageLimit;

    /**
     * times the skill has already been used.
     */
    private int usageLeft;

    /**
     * constructor for skill.
     * @param nameX skill name
     * @param strengthX strength value- int
     * @param usageLimitX max times the skill can be used- int
     */
    public Skill(String nameX, int strengthX, int usageLimitX) {
        name = nameX;
        strength = strengthX;
        usageLimit = usageLimitX;
        usageLeft = usageLimitX;
    }

    /**
     * gets name.
     * @return return name (string)
     */
    public String getName() {
        return name;
    }

    /**
     * gets strength.
     * @return strength (int)
     */
    public int getStrength() {
        return strength;
    }

    /**
     * gets usage limit.
     * @return usage limit (int)
     */
    public int getUsageLimit() {
        return usageLimit;
    }

    /**
     * gets usages left.
     * @return usages left (int)
     */
    public int getUsageLeft() {
        return usageLeft;
    }


    /**
     * resets usages left to the max.
     */
    public void refresh() {
        usageLeft = usageLimit;
    }

    /**
     * to string, prints name & fraction of usages left.
     * @return string
     */
    public String toString() {
        return name + " " + usageLeft + "/" + usageLimit;
    }

    /**
     * changes health value of attacked CodeMonster.
     * @param me CodeMonster doing the attacking
     * @param foe CodeMonster being attacked
     */
    public void applyChanges(CodeMonster me, CodeMonster foe) {
        foe.adjustHealth(strength * -1);
    }

    /**
     * checks if a skill CAN be used (has not exceeded usageLimit).
     * @param me CodeMonster attacking
     * @param foe CodeMonster being attacked
     */
    public void useSkill(CodeMonster me, CodeMonster foe) {
        if (usageLeft > 0) {
            usageLeft -= 1;
            applyChanges(me, foe);
        }
    }
}
