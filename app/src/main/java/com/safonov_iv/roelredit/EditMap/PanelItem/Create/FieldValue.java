package com.safonov_iv.roelredit.EditMap.PanelItem.Create;

import android.graphics.Canvas;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Cursor.Display.DisplayImpl;
import com.safonov_iv.roelredit.GenerateObject.Component.BitmapComponent;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.HashSet;
import java.util.Map;

public class FieldValue extends PanelEditProperties {

    private final String backGroundType;
    private final int weight;


    public FieldValue(String backGroundType, BitmapComponent component) {
        this.backGroundType = backGroundType;
        this.weight = (int) component.getDistance();
        this.bitmap = component.getCopyOriginalBitmap();

    }


    @Override
    public boolean getAction() {
        final Camera camera = Setting.getInstance().getCamera();
        int coordinate = camera.getCursor().getCursorCoordinate();

        if (coordinate > -1) {
            MapValue mapValue = new MapValue(camera.getCursor().getCursorCoordinate(), weight, backGroundType, new HashSet<>());
            MapValue targetMapValue = MapPrototype.getInstance().getMapValues().get(coordinate);
            if (targetMapValue != null) {
                targetMapValue.set(mapValue);
            } else {
                DisplayImpl.getInstance().addToDrawArea(mapValue);
                DisplayImpl.getInstance().updateBoundsMap();
            }


            return true;
        }

        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, rect, null);

    }


}
