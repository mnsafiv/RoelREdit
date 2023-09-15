package com.safonov_iv.roelredit.GenerateObject.Battle.PersonData;


import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.ObjectType;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.SkillBehaviorAfterCollide;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.SkillCollision;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.SkillMoment;

import java.io.Serializable;
import java.util.Objects;

public class CharacterSkill implements Cloneable, Serializable {
    private long id;

    private int skill_id;
    private int multiplier;
    private int skillCostPoint;
    private int chargeStartCapacity;
    private int chargeCurrentCapacity;
    private int chargeCapacity;
    private int chargeRound;

    private int area_id;
    private SkillArea area;
    private ObjectType objectType;
    private SkillCollision skillCollision;
    private SkillMoment skillMoment;
    private SkillBehaviorAfterCollide skillBehaviorAfterCollide;
    private String skillName;
    private String skillDescription;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getSkillCostPoint() {
        return skillCostPoint;
    }

    public void setSkillCostTimes(int skillCostPoint) {
        this.skillCostPoint = skillCostPoint;
    }


    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public SkillArea getSkillArea() {
        return area;
    }

    public void setArea(SkillArea area) {
        this.area = area;
    }

    public ObjectType getSkillType() {
        return objectType;
    }

    public void setSkillType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public SkillCollision getSkillCollision() {
        return skillCollision;
    }

    public void setSkillCollision(SkillCollision skillCollision) {
        this.skillCollision = skillCollision;
    }

    public int getChargeCurrentCapacity() {
        return chargeCurrentCapacity;
    }

    public void setChargeCurrentCapacity(int chargeCurrentCapacity) {
        this.chargeCurrentCapacity = chargeCurrentCapacity;
    }

    public SkillMoment getSkillMoment() {
        return skillMoment;
    }

    public int getChargeStartCapacity() {
        return chargeStartCapacity;
    }

    public void setChargeStartCapacity(int chargeStartCapacity) {
        this.chargeStartCapacity = chargeStartCapacity;
    }

    public int getChargeCapacity() {
        return chargeCapacity;
    }

    public void setChargeCapacity(int chargeCapacity) {
        this.chargeCapacity = chargeCapacity;
    }

    public int getChargeRound() {
        return chargeRound;
    }

    public void setChargeRound(int chargeRound) {
        this.chargeRound = chargeRound;
    }

    public void setSkillMoment(SkillMoment skillMoment) {
        this.skillMoment = skillMoment;
    }

    public SkillBehaviorAfterCollide getSkillBehaviorAfterCollision() {
        return skillBehaviorAfterCollide;
    }

    public void setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide skillBehaviorAfterCollide) {
        this.skillBehaviorAfterCollide = skillBehaviorAfterCollide;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public CharacterSkill() {
    }





    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean decreaseCharge() {
        if(chargeCurrentCapacity<=0){
            return false;
        }
        chargeCurrentCapacity--;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterSkill)) return false;
        CharacterSkill that = (CharacterSkill) o;
        return id == that.id && skill_id == that.skill_id && multiplier == that.multiplier && skillCostPoint == that.skillCostPoint && chargeStartCapacity == that.chargeStartCapacity && chargeCurrentCapacity == that.chargeCurrentCapacity && chargeCapacity == that.chargeCapacity && chargeRound == that.chargeRound && area_id == that.area_id && Objects.equals(area, that.area) && objectType == that.objectType && skillCollision == that.skillCollision && skillMoment == that.skillMoment && skillBehaviorAfterCollide == that.skillBehaviorAfterCollide && Objects.equals(skillName, that.skillName) && Objects.equals(skillDescription, that.skillDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill_id, multiplier, skillCostPoint, chargeStartCapacity, chargeCurrentCapacity, chargeCapacity, chargeRound, area_id, area, objectType, skillCollision, skillMoment, skillBehaviorAfterCollide, skillName, skillDescription);
    }
}
