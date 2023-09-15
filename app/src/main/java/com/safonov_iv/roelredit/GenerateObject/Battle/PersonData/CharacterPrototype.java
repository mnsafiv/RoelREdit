package com.safonov_iv.roelredit.GenerateObject.Battle.PersonData;


import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.ArmorType;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.AttackType;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.CharacterTierType;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.JobType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CharacterPrototype {
    private final int ICON_ID;
    private final AttackType attackType;
    private final ArmorType armorType;
    private final JobType jobType;
    private final CharacterTierType characterTier;
    private final List<CharacterSkill> skills;
    private final Stats baseStats;
    private final Stats increaseStats;


    public CharacterPrototype(AttackType attackType, int icon_id, ArmorType armorType, JobType jobType, Set<CharacterSkill> skills, CharacterTierType characterTier, Stats baseStats, Stats increaseStats) {
        this.attackType = attackType;
        this.ICON_ID = icon_id;
        this.armorType = armorType;
        this.jobType = jobType;
        this.skills = new ArrayList<>(skills);
        this.characterTier = characterTier;
        this.baseStats = baseStats;
        this.increaseStats = increaseStats;
    }

    public CharacterModel getCharacterModel(String key, int level) {
        CharacterStats stats = getStats(level);
        stats.setAttackType(attackType);
        stats.setArmorType(armorType);
        stats.setJobType(jobType);
        stats.setCharacterTier(characterTier);
        return new CharacterModel(ICON_ID, this, key, level);
    }

    private CharacterStats getStats(int level) {
        CharacterStats stats = new CharacterStats();
        stats.setHp((int) (baseStats.hp + level * increaseStats.hp));
        stats.setDamage((int) (baseStats.atk + level * increaseStats.atk));
        stats.setDefence((int) (baseStats.def + level * increaseStats.def));
        stats.setSpeed((int) (baseStats.speed + level * increaseStats.speed));
        return stats;
    }

    public List<CharacterSkill> getSkills() {
        return skills;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public Stats getIncreaseStats() {
        return increaseStats;
    }

    public int getICON_ID() {
        return ICON_ID;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public JobType getJobType() {
        return jobType;
    }

    public CharacterTierType getCharacterTier() {
        return characterTier;
    }
}