package com.safonov_iv.roelredit.EditMap.PanelItem;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.Cursor.Display.CursorPosition;
import com.safonov_iv.roelredit.EditMap.PanelItem.Create.PanelEditMap;
import com.safonov_iv.roelredit.EditMap.PanelItem.Create.PanelEditProperties;
import com.safonov_iv.roelredit.Common.Setting;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import lombok.Getter;

import java.util.Set;

public class SelectItemKit extends PanelEditProperties {
    private final CursorPosition cursor;
    private Rect bitmapRect;
    private final Bitmap bitmap;
    @Getter
    private final Set<PanelEditMap> items;


    public SelectItemKit(Set<PanelEditMap> items) {
        this.bitmapRect = rect;
        this.bitmap = items.stream().findAny().get().getBitmap();
        this.items = items;
        cursor = Setting.getInstance().getCamera().getCursor();
    }

    @Override
    public boolean getAction() {
        if (cursor.getCursorCoordinate() > -1) {
            MapPrototype.getInstance().getMapValues().remove(cursor.getCursorCoordinate());
            return true;
        }
        return false;
    }

    @Override
    public void setRect(Rect rect) {
        this.rect=rect;
        this.bitmapRect=rect;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, bitmapRect, null);

    }

    @Override
    public void reset() {
        super.reset();
    }



    @Override
    public void drawStatus(Canvas canvas) {
        super.drawStatus(canvas);
        items.forEach(t -> t.draw(canvas));
    }
}
