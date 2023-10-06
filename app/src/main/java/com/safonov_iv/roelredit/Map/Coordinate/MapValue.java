package com.safonov_iv.roelredit.Map.Coordinate;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusPrototype;
import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusType;
import com.safonov_iv.roelredit.Cursor.Layer.FieldSetting;
import com.safonov_iv.roelredit.Cursor.Layer.GridDraw;
import com.safonov_iv.roelredit.GenerateObject.Component.PrototypeGrid;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;
import com.safonov_iv.roelredit.Common.Setting;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Getter
@Setter
public class MapValue implements Bonus {
    private final PrototypeGrid prototypeGrid;
    private Long id;
    private double centerX;
    private double centerY;
    private int coordinate;
    private String value;
    private int weight;
    private SortedSet<IconCoordinate> iconCoordinates;


    private Map<BonusType, Double> bonus;

    @JsonIgnore
    private byte alpha = -1;

    private MapGroupModel mapGroup;


    public MapValue(int coordinate, int weight, String key, String value) {
        iconCoordinates = new TreeSet<>((o1, o2) -> {
            if (o1.getAbsolutePositionY() == o2.getAbsolutePositionY())
                return 0;
            return o1.getAbsolutePositionY() < o2.getAbsolutePositionY() ? -1 : 1;
        });

        this.coordinate = coordinate;
        this.centerX = Setting.getInstance().getFieldSetting().getCenterAreaPositionX(coordinate);
        this.centerY = Setting.getInstance().getFieldSetting().getCenterAreaPositionY(coordinate);
        this.value = value;
        this.weight = weight;


        this.bonus = BonusPrototype.getInstance().getBonus(key).getBonusItems();
        this.prototypeGrid = PrototypeGrid.getInstance();


    }

    public MapValue(int coordinate, int weight, String value, Set<IconCoordinate> iconCoordinates) {
        this.iconCoordinates = new TreeSet<>((o1, o2) -> {
            if (o1.getAbsolutePositionY() == o2.getAbsolutePositionY())
                return 0;
            return o1.getAbsolutePositionY() < o2.getAbsolutePositionY() ? -1 : 1;
        });
        this.coordinate = coordinate;
        this.centerX = Setting.getInstance().getFieldSetting().getCenterAreaPositionX(coordinate);
        this.centerY = Setting.getInstance().getFieldSetting().getCenterAreaPositionY(coordinate);
        this.value = value;
        this.weight = weight;
        this.iconCoordinates.addAll(iconCoordinates);
        this.prototypeGrid = PrototypeGrid.getInstance();


    }


    public void drawGrid(Canvas canvas, @NotNull GridDraw grid, FieldSetting setting) {
        grid.draw(canvas, coordinate, prototypeGrid.getBackGroundBitmap(value), setting);
        Camera camera = Setting.getInstance().getCamera();

        Paint paint =new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle((float) camera.getDistanceToCameraX(centerX), (float) camera.getDistanceToCameraY(centerY),10,paint);
        canvas.drawText(String.valueOf(coordinate),
                (float) camera.getDistanceToCameraX(centerX-10),
                (float) camera.getDistanceToCameraY(centerY-20),paint);

    }

    public void drawDecorate(Canvas canvas) {
        iconCoordinates.forEach(t -> t.draw(canvas));

    }

    public void reset() {
        alpha = -1;
    }

    @Override
    public Map<BonusType, Double> getBonus() {
        return bonus;
    }

    public void add(Set<IconCoordinate> icons) {
        this.iconCoordinates.addAll(icons);

    }

    public void set(MapValue mapValue) {
        reset();
        iconCoordinates.clear();
        bonus.clear();
        value=mapValue.getValue();
        weight=mapValue.getWeight();

    }
}
