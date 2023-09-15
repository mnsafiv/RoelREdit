package com.safonov_iv.roelredit.GenerateObject.Component;





import com.safonov_iv.roelredit.GenerateObject.Battle.Enum.*;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterModel;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterPrototype;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterSkill;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.Stats;
import com.safonov_iv.roelredit.GenerateObject.GenerateObjectAccess;
import com.safonov_iv.roelredit.GenerateObject.Model.CharacterBitmapModel;
import com.safonov_iv.roelredit.GenerateObject.Model.CharacterSkillArea;

import java.util.*;

public class PersonComponent {
    private static PersonComponent personComponent;

    private final static Map<String, CharacterPrototype> typeCharacters = new HashMap<>();
    private final static Map<String, CharacterSkill> typeSkills = new HashMap<>();


    private PersonComponent() {
        initSkill();
        initCharacter();

    }

    public static PersonComponent getPersonComponent() {
        if(personComponent==null){
            personComponent=new PersonComponent();
        }
        return personComponent;
    }

    private void initCharacter() {

        String key = "Archer";
        Stats baseStats = new Stats(100, 30, 20, 100);
        Stats increaseStats = new Stats(5, 7, 2, 0.01);

        final CharacterBitmapModel characterBitmapModel = GenerateObjectAccess.characterBitmapModel;


        Set<CharacterSkill> skillSet = new HashSet<>();
        try {
            skillSet.add(getSkill("Arrow"));
            skillSet.add(getSkill("archerStrike"));
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        typeCharacters.put(key, new CharacterPrototype(
                AttackType.Physical,
                characterBitmapModel.getBitmapId(key), ArmorType.Light, JobType.Range, skillSet, CharacterTierType.elite, baseStats, increaseStats));

        key = "Mage";
        baseStats = new Stats(70, 35, 35, 90);
        increaseStats = new Stats(10, 5, 5, 0.03);



        skillSet.clear();
        try {
            skillSet.add(getSkill("FireBall"));
            skillSet.add(getSkill("momentFireball"));
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        typeCharacters.put(key, new CharacterPrototype(AttackType.Magic, characterBitmapModel.getBitmapId(key), ArmorType.Light, JobType.Mage, skillSet, CharacterTierType.elite, baseStats, increaseStats));


        key = "Cup";
        baseStats = new Stats(30, 10, 10, 115);
        increaseStats = new Stats(5, 3, 1, 0.01);

        skillSet.clear();
        try {
            skillSet.add(getSkill("PunchSimply"));
            skillSet.add(getSkill("SuperPunchSimply"));
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        typeCharacters.put(key, new CharacterPrototype(AttackType.Magic, characterBitmapModel.getBitmapId(key), ArmorType.Light, JobType.Warrior, skillSet, CharacterTierType.common, baseStats, increaseStats));

        key = "Warrior";
        baseStats = new Stats(170, 50, 70, 130);
        increaseStats = new Stats(10, 3, 9, 0.015);

        skillSet.clear();
        try {
            skillSet.add(getSkill("PunchWarrior"));
            skillSet.add(getSkill("Slash"));
            skillSet.add(getSkill("ReversePunch"));
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        typeCharacters.put(key, new CharacterPrototype(AttackType.Magic, characterBitmapModel.getBitmapId(key), ArmorType.Light, JobType.Mage, skillSet, CharacterTierType.elite, baseStats, increaseStats));


        key = "LightMage";
        baseStats = new Stats(50, 50, 15, 115);
        increaseStats = new Stats(3, 9, 1, 0.05);

        skillSet.clear();
        try {
            skillSet.add(getSkill("ReverseFlyFireball"));
            skillSet.add(getSkill("TowerOfTower"));
            skillSet.add(getSkill("momentFireball"));
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        typeCharacters.put(key, new CharacterPrototype(AttackType.Magic, characterBitmapModel.getBitmapId(key), ArmorType.Light, JobType.Mage, skillSet, CharacterTierType.elite, baseStats, increaseStats));


    }

    private void initSkill() {

        int number = 1;

        //fireBall
        String key = "FireBall";
        CharacterSkill characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(1);
        characterSkill.setMultiplier(150);
        characterSkill.setSkill_id(number++);
        characterSkill.setChargeRound(2);
        characterSkill.setChargeCapacity(5);
        characterSkill.setChargeStartCapacity(3);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's fireball");


        characterSkill.setSkillType(ObjectType.Throw);
        characterSkill.setSkillCollision(SkillCollision.No);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.destroy);
        characterSkill.setSkillMoment(SkillMoment.NoMoment);

        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);

        //Arrow
        key = "Arrow";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(0);
        characterSkill.setMultiplier(50);
        characterSkill.setSkill_id(1001);
        characterSkill.setChargeRound(15);
        characterSkill.setChargeCapacity(15);
        characterSkill.setChargeStartCapacity(15);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's arrow");


        characterSkill.setSkillType(ObjectType.Arrow);
        characterSkill.setSkillCollision(SkillCollision.No);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.destroy);
        characterSkill.setSkillMoment(SkillMoment.NoMoment);

        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);

        //momentFireball
        key = "momentFireball";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(1);
        characterSkill.setMultiplier(50);
        characterSkill.setSkill_id(number++);
        characterSkill.setChargeRound(2);
        characterSkill.setChargeCapacity(5);
        characterSkill.setChargeStartCapacity(1);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's Moment fireball");


        characterSkill.setSkillType(ObjectType.Passive);
        characterSkill.setSkillCollision(SkillCollision.No);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.destroy);
        characterSkill.setSkillMoment(SkillMoment.Moment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);

        //archerStrike
        key = "archerStrike";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(1);
        characterSkill.setMultiplier(20);
        characterSkill.setSkill_id(number++);
        characterSkill.setChargeRound(2);
        characterSkill.setChargeCapacity(5);
        characterSkill.setChargeStartCapacity(1);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's Archer strike");


        characterSkill.setSkillType(ObjectType.Passive);
        characterSkill.setSkillCollision(SkillCollision.No);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.destroy);
        characterSkill.setSkillMoment(SkillMoment.Moment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);


        //Reverse fly fireball
        key = "ReverseFlyFireball";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(1);
        characterSkill.setMultiplier(15);
        characterSkill.setSkill_id(number++);
        characterSkill.setChargeRound(2);
        characterSkill.setChargeCapacity(5);
        characterSkill.setChargeStartCapacity(3);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's reverse fly fireball");


        characterSkill.setSkillType(ObjectType.Reverse);
        characterSkill.setSkillCollision(SkillCollision.No);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.destroy);
        characterSkill.setSkillMoment(SkillMoment.NoMoment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);


        //towerOfFire
        key = "TowerOfTower";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(3);
        characterSkill.setMultiplier(75);
        characterSkill.setSkill_id(number++);
        characterSkill.setChargeRound(1);
        characterSkill.setChargeCapacity(1);
        characterSkill.setChargeStartCapacity(1);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's tower of fire");


        characterSkill.setSkillType(ObjectType.Active);
        characterSkill.setSkillCollision(SkillCollision.High);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.action);
        characterSkill.setSkillMoment(SkillMoment.NoMoment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("circle"));
        typeSkills.put(key, characterSkill);


        //Push away
        key = "PushAway";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(3);
        characterSkill.setMultiplier(75);
        characterSkill.setSkill_id(number);
        characterSkill.setChargeRound(1);
        characterSkill.setChargeCapacity(2);
        characterSkill.setChargeStartCapacity(1);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's super ball");


        characterSkill.setSkillType(ObjectType.PushAway);
        characterSkill.setSkillCollision(SkillCollision.High);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.action);
        characterSkill.setSkillMoment(SkillMoment.NoMoment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);



        //PunchSimply
        key = "PunchSimply";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(1);
        characterSkill.setMultiplier(75);
        characterSkill.setSkill_id(number);
        characterSkill.setChargeRound(1);
        characterSkill.setChargeCapacity(2);
        characterSkill.setChargeStartCapacity(1);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's PunchSimply");


        characterSkill.setSkillType(ObjectType.Passive);
        characterSkill.setSkillCollision(SkillCollision.No);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.action);
        characterSkill.setSkillMoment(SkillMoment.Moment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);

        //SuperPunchSimply
        key = "SuperPunchSimply";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(3);
        characterSkill.setMultiplier(150);
        characterSkill.setSkill_id(number);
        characterSkill.setChargeRound(1);
        characterSkill.setChargeCapacity(1);
        characterSkill.setChargeStartCapacity(1);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's SuperPunchSimply");


        characterSkill.setSkillType(ObjectType.Passive);
        characterSkill.setSkillCollision(SkillCollision.No);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.action);
        characterSkill.setSkillMoment(SkillMoment.Moment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);


        //PunchWarrior
        key = "PunchWarrior";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(1);
        characterSkill.setMultiplier(75);
        characterSkill.setSkill_id(number);
        characterSkill.setChargeRound(1);
        characterSkill.setChargeCapacity(2);
        characterSkill.setChargeStartCapacity(1);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's PunchWarrior");


        characterSkill.setSkillType(ObjectType.Passive);
        characterSkill.setSkillCollision(SkillCollision.No);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.action);
        characterSkill.setSkillMoment(SkillMoment.Moment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);


        //Slash
        key = "Slash";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(3);
        characterSkill.setMultiplier(250);
        characterSkill.setSkill_id(number);
        characterSkill.setChargeRound(2);
        characterSkill.setChargeCapacity(1);
        characterSkill.setChargeStartCapacity(1);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's Slash");


        characterSkill.setSkillType(ObjectType.Passive);
        characterSkill.setSkillCollision(SkillCollision.No);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.action);
        characterSkill.setSkillMoment(SkillMoment.Moment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);



        //ReversePunch
        key = "ReversePunch";
        characterSkill = new CharacterSkill();
        characterSkill.setSkillCostTimes(2);
        characterSkill.setMultiplier(100);
        characterSkill.setSkill_id(number);
        characterSkill.setChargeRound(1);
        characterSkill.setChargeCapacity(1);
        characterSkill.setChargeStartCapacity(1);

        characterSkill.setSkillName(key);
        characterSkill.setSkillDescription("It's ReversePunch");


        characterSkill.setSkillType(ObjectType.Passive);
        characterSkill.setSkillCollision(SkillCollision.High);
        characterSkill.setSkillBehaviorAfterCollision(SkillBehaviorAfterCollide.action);
        characterSkill.setSkillMoment(SkillMoment.NoMoment);


        characterSkill.setArea(CharacterSkillArea.getSkillAreas("base"));
        typeSkills.put(key, characterSkill);


    }


    public CharacterModel getGenerateModel(String key, int lvl) {
        return typeCharacters.get(key).getCharacterModel(key, lvl);
    }

    private CharacterSkill getSkill(String key) throws CloneNotSupportedException {
        return (CharacterSkill) Objects.requireNonNull(typeSkills.get(key)).clone();
    }




}
