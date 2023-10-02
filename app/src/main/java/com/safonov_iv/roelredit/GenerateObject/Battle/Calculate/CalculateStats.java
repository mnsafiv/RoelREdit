package com.safonov_iv.roelredit.GenerateObject.Battle.Calculate;


import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.CharacterTierType;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterProgress;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterPrototype;
import org.jetbrains.annotations.NotNull;

public class CalculateStats {
    private static CalculateStats calculateStats;
    private CalculateStats() {

    }

    public static CalculateStats getInstance() {
        if(calculateStats==null){
            calculateStats=new CalculateStats();
        }
        return calculateStats;
    }

    public StatsDetail getStats(@NotNull CharacterPrototype stats, int level) {

        StatsDetail statsDetail = new StatsDetail();

        int hp = (int) (stats.getBaseStats().getHp() + stats.getIncreaseStats().getHp() * level);
        int atk = (int) (stats.getBaseStats().getAtk() + stats.getIncreaseStats().getAtk() * level);
        int def = (int) (stats.getBaseStats().getDef() + stats.getIncreaseStats().getDef() * level);
        int spd = (int) (stats.getBaseStats().getSpeed() + stats.getIncreaseStats().getSpeed() * level);


        double moveCost = 10;
        double skillCost = 10;

        double multiplierPureAttack = 0;
        double multiplierPhysicalAttack = 1;
        double multiplierMagicAttack = 1;

        double multiplierPhysicalDefence = 1;
        double multiplierMagicDefence = 1;
        double skillDistanceBonus = 0;

        switch (stats.getAttackType()) {
            case Pure:
                multiplierPureAttack = 1;
                moveCost--;
                skillCost--;
                break;
            case Physical:
                multiplierMagicAttack /= 2;
                multiplierPhysicalAttack *= 2;
                moveCost -= 2;
                skillCost += 2;
                break;
            case Magic:
                multiplierMagicAttack *= 2;
                multiplierPhysicalAttack /= 2;
                moveCost += 2;
                skillCost -= 2;
                break;
        }

        switch (stats.getArmorType()) {
            case Heavy:
                multiplierPhysicalDefence *= 2;
                multiplierMagicDefence /= 2;
                break;
            case Medium:

                break;
            case Light:
                multiplierPhysicalDefence /= 2;
                multiplierMagicDefence *= 2;
                break;
        }

        switch (stats.getJobType()) {
            case Warrior:
                multiplierPhysicalAttack += 1.0;
                multiplierPhysicalDefence += 0.3;
                multiplierMagicDefence += 0.2;
                moveCost -= 2;
                break;
            case Mage:
                multiplierMagicAttack += 1.0;
                multiplierPhysicalDefence += 0.1;
                multiplierMagicDefence += 0.2;
                skillCost -= 1;
                moveCost += 2;
                skillDistanceBonus += 2;
                break;
            case Universal:
                multiplierPhysicalAttack += 0.7;
                multiplierMagicAttack += 0.7;
                multiplierPhysicalDefence += 0.5;
                multiplierMagicDefence += 0.5;
                skillCost -= 1;
                moveCost -= 2;
                skillDistanceBonus += 1;
                break;
        }
        statsDetail.setDamagePhysical((int) (atk * multiplierPhysicalAttack));
        statsDetail.setDamageMagic((int) (atk * multiplierMagicAttack));
        statsDetail.setDamagePure((int) (atk * multiplierPureAttack));

        statsDetail.setDefencePhysical((int) (def * multiplierPhysicalDefence));
        statsDetail.setDefenceMagic((int) (def * multiplierMagicDefence));

        statsDetail.setMoveCost((int) moveCost);
        statsDetail.setSkillCost((int) skillCost);


        statsDetail.setSkillDistance((int) skillDistanceBonus);
        statsDetail.setHealth(hp);


        //need logic
        statsDetail.setActivePoint(50);
        statsDetail.setSkillPoint(100);
        statsDetail.setMovePoint(100);

        statsDetail.setMoveSpeed(spd / 20);
        statsDetail.setSkillCast(1);


        if (moveCost == 0) {
            System.out.println();
        }

        return statsDetail;
    }

    private int getProgressMultiplier(CharacterTierType characterTier) {
        int progress;
        switch (characterTier) {
            case common:
                progress = DefaultValue.COMMON_MULTIPLIER_PROGRESS;
                break;
            case elite:
                progress = DefaultValue.ELITE_MULTIPLIER_PROGRESS;
                break;
            default:
                progress = DefaultValue.HERO_MULTIPLIER_PROGRESS;
        }
        return progress;
    }


    public int getLevel(int exp, CharacterTierType characterTier) {
        return getProgressLevel(exp, getProgressMultiplier(characterTier));
    }

    public int getExp(int level, CharacterTierType characterTier) {
        return getProgressExp(level, getProgressMultiplier(characterTier));
    }


    private int getProgressExp(int level, int progress) {
        int toPrevLevel = progress;
        int exp = 0;
        for (int next = 0; level-- > 1; next++) {
            toPrevLevel = (int) (Math.sqrt(next * progress) + toPrevLevel);
            exp += toPrevLevel;
        }
        return exp;
    }

    private int getProgressLevel(int exp, int progress) {
        int level = 0;
        int toPrevLevel = progress;
        for (int next = 0; exp > 0; next++) {
            toPrevLevel = (int) (Math.sqrt(next * progress) + toPrevLevel);
            exp -= toPrevLevel;
            level++;
        }
        return level;
    }

    public void updateFromLevel(CharacterProgress characterProgress) {
        updateProgressLevel(characterProgress);


    }

    private void updateProgressLevel(CharacterProgress characterProgress) {
        int progress = getProgressMultiplier(characterProgress.getCharacterTier());
        int exp = 0;


        int level = characterProgress.getLevel();
        int toNextLevel = progress;
        int next;
        for (next = 0; level-- > 1; next++) {
            toNextLevel = (int) (Math.sqrt(next * progress) + toNextLevel);
            exp += toNextLevel;
        }

        toNextLevel = (int) (Math.sqrt(++next * progress) + toNextLevel);
        characterProgress.setTotalExp(exp);
        characterProgress.setRequireExp(toNextLevel);

    }



    public void updateFromExp(CharacterProgress characterProgress) {
        int progress = getProgressMultiplier(characterProgress.getCharacterTier());
        int exp = characterProgress.getTotalExp();


        int level = 0;
        int toNextLevel = progress;
        for (int next = 0; exp > 0; next++) {
            toNextLevel = (int) (Math.sqrt(next * progress) + toNextLevel);
            exp -= toNextLevel;
            level++;
        }

        characterProgress.setLevel(level);
        characterProgress.setProgressExp(toNextLevel+exp);
        characterProgress.setRequireExp(toNextLevel);



    }
}
