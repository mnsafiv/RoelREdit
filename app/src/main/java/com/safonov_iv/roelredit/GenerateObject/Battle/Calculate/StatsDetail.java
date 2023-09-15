package com.safonov_iv.roelredit.GenerateObject.Battle.Calculate;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class StatsDetail implements Cloneable, Serializable {
    private int health;
    private int damagePhysical;
    private int damageMagic;
    private int damagePure;
    private int defencePhysical;
    private int defenceMagic;
    private int activePoint;
    private int skillPoint;
    private int movePoint;
    private int skillDistance;
    private int moveCost;
    private int skillCost;
    private int moveSpeed;
    private int skillCast;

    public int getActivePoint() {
        return activePoint;
    }

    public void setActivePoint(int activePoint) {
        this.activePoint = activePoint;
    }

    public int getMovePoint() {
        return movePoint;
    }

    public void setMovePoint(int movePoint) {
        this.movePoint = movePoint;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }

    public int getMoveCost() {
        return moveCost;
    }

    public int getSkillDistance() {
        return skillDistance;
    }

    public void setSkillDistance(int skillDistance) {
        this.skillDistance = skillDistance;
    }

    public void setMoveCost(int moveCost) {
        this.moveCost = moveCost;
    }

    public int getSkillCost() {
        return skillCost;
    }

    public void setSkillCost(int skillCost) {
        this.skillCost = skillCost;
    }

    public int getDamagePhysical() {
        return damagePhysical;
    }

    public void setDamagePhysical(int damagePhysical) {
        this.damagePhysical = damagePhysical;
    }

    public int getDamageMagic() {
        return damageMagic;
    }

    public void setDamageMagic(int damageMagic) {
        this.damageMagic = damageMagic;
    }

    public int getDefencePhysical() {
        return defencePhysical;
    }

    public void setDefencePhysical(int defencePhysical) {
        this.defencePhysical = defencePhysical;
    }

    public int getDefenceMagic() {
        return defenceMagic;
    }

    public void setDefenceMagic(int defenceMagic) {
        this.defenceMagic = defenceMagic;
    }

    public int getDamagePure() {
        return damagePure;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamagePure(int damagePure) {
        this.damagePure = damagePure;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getSkillCast() {
        return skillCast;
    }

    public void setSkillCast(int skillCast) {
        this.skillCast = skillCast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatsDetail)) return false;
        StatsDetail that = (StatsDetail) o;
        return health == that.health && damagePhysical == that.damagePhysical && damageMagic == that.damageMagic && damagePure == that.damagePure && defencePhysical == that.defencePhysical && defenceMagic == that.defenceMagic && activePoint == that.activePoint && skillPoint == that.skillPoint && movePoint == that.movePoint && skillDistance == that.skillDistance && moveCost == that.moveCost && skillCost == that.skillCost && moveSpeed == that.moveSpeed && skillCast == that.skillCast;
    }

    @Override
    public int hashCode() {
        return Objects.hash(health, damagePhysical, damageMagic, damagePure, defencePhysical, defenceMagic, activePoint, skillPoint, movePoint, skillDistance, moveCost, skillCost, moveSpeed, skillCast);
    }

    @NonNull
    @NotNull
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public int getProgressExp() {
        return health/10+(damageMagic+damagePhysical+defencePhysical+defenceMagic)/3;
    }
}
