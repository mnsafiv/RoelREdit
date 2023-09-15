package com.safonov_iv.roelredit.Map.Decorate;

import android.graphics.Canvas;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Cursor.Layer.FieldSetting;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MapField implements FieldPrototype {


    private final FieldSetting setting;
    private final Camera camera;
    private final MapPrototype mapPrototype;



    public MapField(@NotNull Setting setting, MapPrototype mapPrototype) {
        this.setting = setting.getFieldSetting();

        camera = setting.getCamera();
        this.mapPrototype = mapPrototype;
    }

    @Override
    public void draw(Canvas canvas) {
        mapPrototype.getMapValues().forEach((key, value) ->
                value.drawGrid(canvas,camera, mapPrototype.getGrid(), mapPrototype.getSetting()));

        mapPrototype.getMapValues().forEach((key, value) ->
                value.drawDecorate(canvas,camera));

    }


    @Override
    public MapPrototype getMapPrototype() {
        return mapPrototype;
    }


    @Override
    public Map<Integer, MapValue> getMap() {
        return new HashMap<>(mapPrototype.getMapValues());
    }


    @Override
    public MapPrototype getRefMap() {
        return mapPrototype;
    }

    @Override
    public int getCoordinate(int areaX, int areaY) {
        return setting.getCoordinate(areaX, areaY);
    }


}
