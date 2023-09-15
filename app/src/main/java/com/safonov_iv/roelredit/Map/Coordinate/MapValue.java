package com.safonov_iv.roelredit.Map.Coordinate;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusType;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Cursor.Layer.FieldSetting;
import com.safonov_iv.roelredit.Cursor.Layer.GridDraw;
import com.safonov_iv.roelredit.GenerateObject.GenerateObjectAccess;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;
import com.safonov_iv.roelredit.Common.Setting;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

public class MapValue implements Bonus {
    private Long id;
    private double centerX;
    private double centerY;
    private int coordinate;
    private String value;
    private int weight;
    private Set<IconCoordinate> iconCoordinates;
    private Map<BonusType, Double> bonus;

    @JsonIgnore
    private byte alpha = -1;

    private MapGroupModel mapGroup;


    public MapValue(int coordinate,int weight, String key, String value, Set<IconCoordinate> iconCoordinates) {
        this.coordinate = coordinate;
        this.centerX = Setting.getSetting().getFieldSetting().getCenterAreaPositionX(coordinate);
        this.centerY = Setting.getSetting().getFieldSetting().getCenterAreaPositionY(coordinate);
        this.value = value;
        this.weight = weight;
        this.iconCoordinates = iconCoordinates;
        this.bonus=GenerateObjectAccess.bonusPrototype.getBonus(key).getBonusItems();


    }

    public MapValue(int coordinate, int weight, String value, Set<IconCoordinate> iconCoordinates) {
        this.coordinate = coordinate;
        this.centerX = Setting.getSetting().getFieldSetting().getCenterAreaPositionX(coordinate);
        this.centerY = Setting.getSetting().getFieldSetting().getCenterAreaPositionY(coordinate);
        this.value = value;
        this.weight = weight;
        this.iconCoordinates = iconCoordinates;


    }


    public String getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }


    public void drawGrid(Canvas canvas, Camera camera, @NotNull GridDraw grid, FieldSetting setting) {
//        Bitmap gridBase = PrototypeGrid.getBackGroundBitmap(value);
//        if (alpha != -1) {
//            Utils.changeColor(gridBase, alpha);
//        }

        grid.draw(canvas, coordinate, GenerateObjectAccess.prototypeGrid.getBackGroundBitmap(value), setting);


    }

    public void drawDecorate(Canvas canvas, Camera camera) {
        iconCoordinates.forEach(t -> t.draw(canvas, camera));

        if (mapGroup != null && mapGroup.getIconId() != DefaultValue.NO_EXIST_GROUP) {
            final Bitmap bitmap = GenerateObjectAccess.characterMap.getBitmapById(mapGroup.getIconId());
            canvas.drawBitmap(bitmap,
                    (float) camera.getDistanceToCameraX(centerX - bitmap.getWidth() / 2.0),
                    (float) camera.getDistanceToCameraY(centerY - bitmap.getHeight() / 2.0),
                    null);
        }


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Set<IconCoordinate> getIconCoordinates() {
        return iconCoordinates;
    }

    public void setIconCoordinates(Set<IconCoordinate> iconCoordinates) {
        this.iconCoordinates = iconCoordinates;
    }

    public MapGroupModel getMapGroup() {
        return mapGroup;
    }

    public void setMapGroup(MapGroupModel mapGroup) {
        this.mapGroup = mapGroup;
    }

    public void setAlpha(byte alpha) {
        this.alpha = alpha;
    }

    public void reset() {
        alpha = -1;
    }

    @Override
    public Map<BonusType, Double> getBonus() {
        return bonus;
    }
}
