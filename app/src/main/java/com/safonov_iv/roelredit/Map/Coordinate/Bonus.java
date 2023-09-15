package com.safonov_iv.roelredit.Map.Coordinate;

import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusType;

import java.util.Map;

public interface Bonus {
    Map<BonusType, Double> getBonus();
}
