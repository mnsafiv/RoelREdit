package com.safonov_iv.roelredit.Cursor.Display;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;

public interface Display {

    void updateBoundsMap();

    void updateDrawArea();

    void draw(Canvas canvas);

    void setExploreMap(MapPrototype exploreMap);

    void addToDrawArea(MapValue mapValue);
}
