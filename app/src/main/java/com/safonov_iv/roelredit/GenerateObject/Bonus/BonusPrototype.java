package com.safonov_iv.roelredit.GenerateObject.Bonus;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BonusPrototype {
    private static volatile BonusPrototype bonusPrototype;
    private final Map<String, BonusValue> bonuses;

    private BonusPrototype() {
        bonuses=new HashMap<>();

        addBonus( "water_001_6_4",BonusType.MOVE_DISTANCE, Integer.MAX_VALUE);


        addBonus("floor_001_6_4",BonusType.MOVE_DISTANCE, 1.0);


        addBonus("tree_001_2_2",BonusType.MOVE_MULTIPLIER, 0.1);
        addBonus("tree_001_2_2",BonusType.RANGE_MULTIPLIER, -0.1);



        addBonus("tree_002_4_2",BonusType.MOVE_DISTANCE, 0.1);
        addBonus("tree_002_4_2",BonusType.RANGE_MULTIPLIER, -0.1);



        addBonus("tree_003_2_1", BonusType.MOVE_DISTANCE, 0.1);
        addBonus("tree_003_2_1", BonusType.RANGE_MULTIPLIER, -0.1);

        System.out.println();


    }


    public static synchronized BonusPrototype getBonusPrototype() {
        if (bonusPrototype == null)
            bonusPrototype = new BonusPrototype();
        return bonusPrototype;
    }

    private void addBonus(String key, BonusType type, double value) {
        if(!bonuses.containsKey(key)){
            bonuses.put(key, new BonusValue(type,value));
        }else{
            Objects.requireNonNull(bonuses.get(key)).add(type,value);
        }


    }

    public BonusValue getBonus(String key) {
        return bonuses.get(key);
    }

}
