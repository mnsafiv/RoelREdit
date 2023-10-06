package com.safonov_iv.roelredit.Test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.Window;
import com.safonov_iv.roelredit.Common.Utils;
import com.safonov_iv.roelredit.Cursor.Display.Display;
import com.safonov_iv.roelredit.GenerateObject.Component.MapComponent;
import com.safonov_iv.roelredit.Map.AbstractMap;
import com.safonov_iv.roelredit.Map.Coordinate.Enum.MapType;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;



@SuppressLint("ViewConstructor")
public class FieldMapTest extends AbstractMap {
    private final Display display;

    public FieldMapTest(Context context, Window window) {
        super(context);
        Utils.setFullScreen(window);
        MapPrototype exploreMap = MapPrototype.getInstance();
        exploreMap.setMapName("map_004");
        exploreMap.setMapValues(MapComponent.getMap(MapType.Simply,setting));
        display = DisplayTest.getInstance();
        display.setExploreMap(exploreMap);
        display.updateDrawArea();


    }

    @Override
    public void update() {
        super.update();

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        display.draw(canvas);

    }
}
