package com.safonov_iv.roelredit.GenerateObject.Battle.PersonData;

import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.ArmorType;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.AttackType;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.CharacterTierType;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.JobType;

import java.io.Serializable;
import java.util.Objects;

public class CharacterStats implements Cloneable, Serializable {

    private int hp;
    private int damage;
    private int speed;
    private int defence;

	private ArmorType armorType;
	private AttackType attackType;
	private JobType jobType;
	private CharacterTierType characterTier;




	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}




	public ArmorType getArmorType() {
		return armorType;
	}

	public void setArmorType(ArmorType armorType) {
		this.armorType = armorType;
	}

	public AttackType getAttackType() {
		return attackType;
	}

	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public CharacterTierType getCharacterTier() {
		return characterTier;
	}

	public void setCharacterTier(CharacterTierType characterTier) {
		this.characterTier = characterTier;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CharacterStats)) return false;
		CharacterStats that = (CharacterStats) o;
		return hp == that.hp && damage == that.damage && speed == that.speed && defence == that.defence && armorType == that.armorType && attackType == that.attackType && jobType == that.jobType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hp, damage, speed, defence, armorType, attackType, jobType);
	}
}
