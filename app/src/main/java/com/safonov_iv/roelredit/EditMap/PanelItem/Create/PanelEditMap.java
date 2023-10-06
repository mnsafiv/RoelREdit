package com.safonov_iv.roelredit.EditMap.PanelItem.Create;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.EditMap.ClickOnStatus.PanelInt;

public interface PanelEditMap extends PanelInt {
    boolean getAction();

    void draw(Canvas canvas);
    void drawStatus(Canvas canvas);

    void setRect(Rect rect);

    Bitmap getBitmap();

    void reset();

    Rect getRect();

    boolean getCollision(int positionX, int positionY);

    void update();

}
