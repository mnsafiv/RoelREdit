package com.safonov_iv.roelredit.EditMap.ClickOnStatus;

import android.graphics.Canvas;
import android.graphics.Rect;

public interface ActiveAction extends PanelInt {
    Rect getBorder();

    void draw(Canvas canvas);

    boolean checkCollision();

    void update();

    int getPositionX();

    int getPositionY();
    int getHeight();

    int getWidth();

    void setPositionX(int positionX);

    void setPositionY(int positionY);
}
