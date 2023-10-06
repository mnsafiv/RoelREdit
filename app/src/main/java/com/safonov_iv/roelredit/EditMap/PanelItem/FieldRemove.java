package com.safonov_iv.roelredit.EditMap.PanelItem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.Cursor.Display.CursorPosition;
import com.safonov_iv.roelredit.EditMap.PanelItem.Create.PanelEditProperties;
import com.safonov_iv.roelredit.Common.Setting;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;

public class FieldRemove extends PanelEditProperties {
    private final Rect bitmapRect;
    private final Bitmap bitmap;

    public FieldRemove(Context context, int id) {
        super();
        bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        bitmapRect = new Rect(0, 0, bitmap.getHeight(), bitmap.getWidth());
    }

    @Override
    public boolean getAction() {
        final CursorPosition cursor = Setting.getInstance().getCamera().getCursor();
        if (cursor.getCursorCoordinate() > -1) {
            MapPrototype.getInstance().getMapValues().remove(cursor.getCursorCoordinate());
            return true;
        }

        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, bitmapRect, rect, null);

    }


}
