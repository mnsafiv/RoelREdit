package com.safonov_iv.roelredit.GenerateObject.Battle.PersonData;

public class Stats {
    protected double hp;
    protected double atk;
    protected double def;
    protected double speed;

    public Stats(double hp, double atk, double def, double speed) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.speed = speed;
    }

    public double getHp() {
        return hp;
    }

    public double getAtk() {
        return atk;
    }

    public double getDef() {
        return def;
    }

    public double getSpeed() {
        return speed;
    }
}