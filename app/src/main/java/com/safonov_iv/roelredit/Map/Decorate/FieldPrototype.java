package com.safonov_iv.roelredit.Map.Decorate;

import android.graphics.Canvas;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;

import java.util.Map;

public interface FieldPrototype {
    MapPrototype getMapPrototype();
    Map<Integer, MapValue> getMap();
    MapPrototype getRefMap();
    int getCoordinate(int areaX, int areaY);



}
