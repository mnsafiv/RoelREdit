package com.safonov_iv.roelredit.EditMap.ClickOnStatus;


import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;

public interface PanelInt {
    boolean getCollision(int positionX, int positionY);
    void shift(int distanceX, int distanceY);
    boolean getAction(MapPrototype map);
}
