package com.safonov_iv.roelredit.Map.Decorate;

import android.graphics.Canvas;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Cursor.Layer.FieldSetting;
import com.safonov_iv.roelredit.Cursor.Layer.GridDraw;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.HashMap;
import java.util.Map;

public class MapField implements FieldPrototype {
    private final FieldSetting fieldSetting;
    private final MapPrototype mapPrototype;


    public MapField(MapPrototype mapPrototype) {
        this.fieldSetting = Setting.getInstance().getFieldSetting();
        this.mapPrototype = mapPrototype;
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
        return fieldSetting.getCoordinate(areaX, areaY);
    }


}
