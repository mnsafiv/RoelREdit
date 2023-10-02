package com.safonov_iv.roelredit.Map.Coordinate;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusPrototype;
import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusType;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Cursor.Layer.FieldSetting;
import com.safonov_iv.roelredit.Cursor.Layer.GridDraw;
import com.safonov_iv.roelredit.GenerateObject.Component.CharacterMap;
import com.safonov_iv.roelredit.GenerateObject.Component.PrototypeGrid;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;
import com.safonov_iv.roelredit.Common.Setting;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
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


    public MapValue(int coordinate, int weight, String key, String value, Set<IconCoordinate> iconCoordinates) {
        this.coordinate = coordinate;
        this.centerX = Setting.getInstance().getFieldSetting().getCenterAreaPositionX(coordinate);
        this.centerY = Setting.getInstance().getFieldSetting().getCenterAreaPositionY(coordinate);
        this.value = value;
        this.weight = weight;
        this.iconCoordinates = iconCoordinates;
        this.bonus = BonusPrototype.getInstance().getBonus(key).getBonusItems();


    }

    public MapValue(int coordinate, int weight, String value, Set<IconCoordinate> iconCoordinates) {
        this.coordinate = coordinate;
        this.centerX = Setting.getInstance().getFieldSetting().getCenterAreaPositionX(coordinate);
        this.centerY = Setting.getInstance().getFieldSetting().getCenterAreaPositionY(coordinate);
        this.value = value;
        this.weight = weight;
        this.iconCoordinates = iconCoordinates;


    }


    public void drawGrid(Canvas canvas, @NotNull GridDraw grid, FieldSetting setting) {
//        Bitmap gridBase = PrototypeGrid.getBackGroundBitmap(value);
//        if (alpha != -1) {
//            Utils.changeColor(gridBase, alpha);
//        }

        grid.draw(canvas, coordinate, PrototypeGrid.getInstance().getBackGroundBitmap(value), setting);


    }

    public void drawDecorate(Canvas canvas, Camera camera) {
        iconCoordinates.forEach(t -> t.draw(canvas, camera));

        if (mapGroup != null && mapGroup.getIconId() != DefaultValue.NO_EXIST_GROUP) {
            final Bitmap bitmap = CharacterMap.getInstance().getBitmapById(mapGroup.getIconId());
            canvas.drawBitmap(bitmap,
                    (float) camera.getDistanceToCameraX(centerX - bitmap.getWidth() / 2.0),
                    (float) camera.getDistanceToCameraY(centerY - bitmap.getHeight() / 2.0),
                    null);
        }


    }

    public void reset() {
        alpha = -1;
    }

    @Override
    public Map<BonusType, Double> getBonus() {
        return bonus;
    }
}
