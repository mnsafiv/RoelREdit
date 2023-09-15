package com.safonov_iv.roelredit.GenerateObject.Battle.Enum;

public enum CharacterTierType {
    elite(3),
    common(1),
    hero(5),
    boss(5),
    eliteBoss(10),
    legendaryBoss(15);

    public final int grade;

    CharacterTierType(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}
