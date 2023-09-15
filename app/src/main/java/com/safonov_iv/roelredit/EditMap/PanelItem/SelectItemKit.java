package com.safonov_iv.roelredit.EditMap.PanelItem;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.Cursor.Display.CursorPosition;
import com.safonov_iv.roelredit.EditMap.PanelItem.Create.PanelEditMap;
import com.safonov_iv.roelredit.EditMap.PanelItem.Create.PanelEditProperties;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.Set;

public class SelectItemKit extends PanelEditProperties {
    private final CursorPosition cursor;
    private Rect bitmapRect;
    private final Bitmap bitmap;
    private final Set<PanelEditMap> items;


    public SelectItemKit(Set<PanelEditMap> items) {
        this.bitmapRect = rect;
        this.bitmap = items.stream().findAny().get().getBitmap();
        this.items = items;
        cursor = Setting.getSetting().getCamera().getCursor();
    }

    @Override
    public boolean getAction(MapPrototype map) {
        if (cursor.getCursorCoordinate() > -1) {
            map.getMapValues().remove(cursor.getCursorCoordinate());
            return true;
        }
        return false;
    }

    @Override
    public void setRect(Rect rect) {
        this.rect=rect;
        this.bitmapRect=rect;
    }

    public Set<PanelEditMap> getItems() {
        return items;
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
