package com.safonov_iv.roelredit.EditMap.PanelItem.Create;

import android.graphics.Canvas;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.EditMap.PanelItem.ResolutionIcon;
import com.safonov_iv.roelredit.GenerateObject.Component.BitmapComponent;
import com.safonov_iv.roelredit.Map.Coordinate.IconCoordinate;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;

public class FieldDecor extends PanelEditProperties {
    private final Camera camera;
    private final String iconType;
    private final String key;
    private final ResolutionIcon resolution;


    public FieldDecor(String id, String key, BitmapComponent bitmapComponent, ResolutionIcon resolution) {
        this.key = key;
        this.resolution = resolution;
        this.bitmap=bitmapComponent.getCopyOriginalBitmap();
        this.iconType=id;
        this.camera = Setting.getInstance().getCamera();
    }


    @Override
    public boolean getAction() {
        final MapValue mapValue = MapPrototype.getInstance().getMapValues().get(camera.getCursor().getCursorCoordinate());
        if (mapValue != null) {
            mapValue.setId(null);
            IconCoordinate iconCoordinateNew = new IconCoordinate(
                    camera.getCursor().getActiveCursorX() - camera.getDistanceToCameraX(mapValue.getCenterX()),
                    camera.getCursor().getActiveCursorY() - camera.getDistanceToCameraY(mapValue.getCenterY()),
                    resolution.getResolution(),
                    key, iconType, mapValue);
            mapValue.getIconCoordinates().add(iconCoordinateNew);

            return true;
        }

        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, rect, null);

    }


}
