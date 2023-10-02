package com.safonov_iv.roelredit.EditMap.PanelItem.Create;

import android.graphics.Canvas;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.GenerateObject.Component.BitmapComponent;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;

public class FieldValue extends PanelEditProperties {

    private String backGroundType;
    private int weight;


    public FieldValue(String backGroundType, BitmapComponent component) {
        this.backGroundType = backGroundType;
        this.weight = (int) component.getDistance();
        this.bitmap = component.getCopyOriginalBitmap();

    }


    @Override
    public boolean getAction(MapPrototype map) {
        System.out.println();
        final Camera camera = Setting.getInstance().getCamera();
        if (camera.getCursor().getCursorCoordinate() > -1) {
            map.getMapValues().put(camera.getCursor().getCursorCoordinate(),
                    new MapValue(camera.getCursor().getCursorCoordinate(), weight, backGroundType, null));
            return true;
        }

        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, rect, null);

    }


}
