package com.safonov_iv.roelredit.GenerateObject.Battle.PersonData;


import com.safonov_iv.roelredit.GenerateObject.Battle.Calculate.CalculateStats;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.CharacterTierType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
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
        CalculateStats.getInstance().updateFromLevel(this);
    }

    public boolean addProgress(int expProgress) {
        totalExp+=expProgress;

        System.out.println();
        CalculateStats.getInstance().updateFromExp(this);
        System.out.println();
        return true;
    }
}
