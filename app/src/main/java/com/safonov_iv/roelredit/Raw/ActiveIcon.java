package com.safonov_iv.roelredit.Raw;

import android.graphics.Canvas;
import android.graphics.Rect;

public interface ActiveIcon {
    Rect getBorder();

    void draw(Canvas canvas);

    boolean getCollision(int activeCursorX, int activeCursorY);

    void update();

    int getPositionX();

    int getPositionY();
    int getHeight();

    int getWidth();

    void setPositionX(int positionX);

    void setPositionY(int positionY);
}
