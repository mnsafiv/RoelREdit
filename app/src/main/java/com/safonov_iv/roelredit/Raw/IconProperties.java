package com.safonov_iv.roelredit.Raw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.Cursor.Display.CursorPosition;

public abstract class IconProperties implements ActiveIcon {

    protected Rect bitmapRect;
    protected int positionX;
    protected int positionY;
    protected Bitmap bitmapIcon;
    protected CursorPosition cursorPosition;

    protected IconProperties(CursorPosition cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    @Override
    public Rect getBorder() {
        return bitmapRect;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmapIcon, positionX, positionY, null);
    }

    @Override
    public boolean getCollision(int activeCursorX, int activeCursorY) {
        return (bitmapRect.contains(
                cursorPosition.getCursorPositionX() - positionX,
                cursorPosition.getCursorPositionY() - positionY));
    }

    @Override
    public void update() {

    }

    @Override
    public int getHeight() {
        return bitmapIcon.getHeight();
    }

    @Override
    public int getWidth() {
        return bitmapIcon.getWidth();
    }

    @Override
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    @Override
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }
}
