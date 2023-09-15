package com.safonov_iv.roelredit.EditMap.PanelItem.Create;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Common.Setting;


public abstract class PanelEditProperties implements PanelEditMap{

    protected Rect rect;
    protected Bitmap bitmap;


    public PanelEditProperties() {
        this.rect=new Rect();
    }

    @Override
    public void reset() {

    }





    @Override
    public void setRect(Rect rect) {
        this.rect = rect;
    }

    @Override
    public Rect getRect() {
        return rect;
    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public boolean getCollision(int positionX, int positionY) {
        return rect.contains(positionX, positionY);
    }

    @Override
    public void shift(int distanceX, int distanceY) {

    }

    @Override
    public void drawStatus(Canvas canvas) {

    }


    @Override
    public boolean getAction(MapPrototype map) {
        return false;
    }

    public void reset(Setting setting){

    }

    @Override
    public void update() {

    }

}
