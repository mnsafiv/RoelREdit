package com.safonov_iv.roelredit.GenerateObject.Battle.PersonData;


import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.CharacterTierType;
import com.safonov_iv.roelredit.GenerateObject.GenerateObjectAccess;

import java.io.Serializable;
import java.util.Objects;

public class CharacterProgress implements Serializable {
    private int level;
    private int totalExp;
    private int progressExp;
    private int requireExp;


    private CharacterTierType characterTier;

    //bonus exp
    private double multiplierProgress;


    public CharacterProgress(int level, int progressExp, CharacterTierType characterTier) {
        this.level = level;
        this.characterTier = characterTier;
        this.progressExp = progressExp;
        GenerateObjectAccess.calculateStats.updateFromLevel(this);
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacterProgress)) return false;
        CharacterProgress that = (CharacterProgress) o;
        return level == that.level && totalExp == that.totalExp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, totalExp);
    }

    public boolean addProgress(int expProgress) {
        totalExp+=expProgress;

        System.out.println();
        GenerateObjectAccess.calculateStats.updateFromExp(this);
        System.out.println();
        return true;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(int totalExp) {
        this.totalExp = totalExp;
    }

    public int getProgressExp() {
        return progressExp;
    }

    public void setProgressExp(int progressExp) {
        this.progressExp = progressExp;
    }

    public int getRequireExp() {
        return requireExp;
    }

    public void setRequireExp(int requireExp) {
        this.requireExp = requireExp;
    }

    public CharacterTierType getCharacterTier() {
        return characterTier;
    }

    public void setCharacterTier(CharacterTierType characterTier) {
        this.characterTier = characterTier;
    }

    public double getMultiplierProgress() {
        return multiplierProgress;
    }

    public void setMultiplierProgress(double multiplierProgress) {
        this.multiplierProgress = multiplierProgress;
    }
}
