package com.safonov_iv.roelredit.EditMap.ClickOnStatus;


public interface PanelInt {
    boolean getCollision(int positionX, int positionY);
    void shift(int distanceX, int distanceY);
    boolean getAction();
}
