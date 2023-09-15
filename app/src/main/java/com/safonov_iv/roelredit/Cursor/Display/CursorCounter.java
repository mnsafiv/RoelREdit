package com.safonov_iv.roelredit.Cursor.Display;


import com.safonov_iv.roelredit.Common.Utils;

import java.util.Objects;

public class CursorCounter {
    private float positionX;
    private float positionY;

    public CursorCounter(float positionX, float positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursorCounter)) return false;
        CursorCounter that = (CursorCounter) o;
        return positionX == that.positionX && positionY == that.positionY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY);
    }


    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPosition(int x, int y)    {
        this.positionX=x;
        this.positionY=y;
    }

    public boolean contains(int x, int y) {
        return positionX==x && positionY==y;
    }

    public boolean checkDistance(int distance, float positionX, float positionY) {
        return Utils.getDistanceBetweenTwoPoints(positionX,positionY,this.positionX,this.positionY)<distance;
    }
}
