package com.safonov_iv.roelredit.Cursor.Layer;


import android.graphics.Bitmap;
import android.graphics.PointF;
import com.safonov_iv.roelredit.Common.Setting;

public abstract class FieldSetting {

    protected GridSetting gridSetting;


    protected FieldSetting(Setting setting) {
        this.gridSetting = setting.getGridSetting();
    }


    public float getSize() {
        return gridSetting.getSize();
    }

    public GridSetting getSetting() {
        return gridSetting;
    }

    public void setSetting(GridSetting setting) {
        this.gridSetting = setting;
    }

    public int getCoordinate(int areaX, int areaY) {
        return areaX + areaY * gridSetting.getCapacity();
    }

    public int getAreaX(int coordinate) {
        return coordinate % gridSetting.getCapacity();
    }

    public int getAreaY(int coordinate) {
        return coordinate / gridSetting.getCapacity();
    }


    public abstract int getCoordinate(double positionX, double positionY);

    public abstract float getCenterAreaPositionX(int coordinate);

    public abstract float getCenterAreaPositionY(int coordinate);

    public abstract float getCenterAreaPositionX(int areaX, int areaY);

    public abstract float getCenterAreaPositionY(int areaX, int areaY);


    public float getRadius() {
        return gridSetting.getSize() / 2;
    }

    public PointF getCoordinateStartBitmap(Bitmap bitmap, int coordinate) {
        return new PointF(getCenterAreaPositionX(coordinate)-bitmap.getWidth()/2,
                getCenterAreaPositionY(coordinate)-bitmap.getHeight()/2);
    }
}
