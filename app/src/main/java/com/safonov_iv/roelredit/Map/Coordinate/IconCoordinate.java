package com.safonov_iv.roelredit.Map.Coordinate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusType;
import com.safonov_iv.roelredit.Common.Utils;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.GenerateObject.GenerateObjectAccess;

import java.util.Map;

public class IconCoordinate implements Bonus {
    private Long id;
    private double positionX;
    private double positionY;
    private double resolution;
    private String iconType;


    private byte alpha = -1;



    @JsonIgnore
    private MapValue mapValueOwner;


    //bonus
    private Map<BonusType, Double> bonus;



    public IconCoordinate(double positionX, double positionY, double resolution, String key, String iconType, MapValue mapValueOwner) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.resolution = resolution;
        this.iconType = iconType;
        this.bonus= GenerateObjectAccess.bonusPrototype.getBonus(key).getBonusItems();

        this.mapValueOwner = mapValueOwner;
    }


    public void draw(Canvas canvas, Camera camera) {

        Bitmap bitmap = GenerateObjectAccess.prototypeDecor.getBackGroundBitmap(iconType, resolution);

        if (alpha != -1) {
            bitmap = Utils.changeColor(bitmap, alpha);
        }


        canvas.drawBitmap(bitmap,
                (float) camera.getCenterBitmapToCameraX(bitmap, mapValueOwner.getCenterX() + positionX),
                (float) camera.getCenterBitmapToCameraY(bitmap, mapValueOwner.getCenterY() + positionY),
                null);
    }


    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }
    

    public void setMapValueOwner(MapValue mapValueOwner) {
        this.mapValueOwner = mapValueOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAlpha(byte alpha) {
        this.alpha = alpha;
    }

    public void reset(){
        alpha=-1;
    }

    @Override
    public Map<BonusType, Double> getBonus() {
        return bonus;
    }
}
