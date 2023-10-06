package com.safonov_iv.roelredit.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.Window;
import com.safonov_iv.roelredit.Common.Utils;
import com.safonov_iv.roelredit.Cursor.Display.DisplayImpl;
import com.safonov_iv.roelredit.Cursor.Display.UpdateSelectCursor;
import com.safonov_iv.roelredit.EditMap.EditMap;
import com.safonov_iv.roelredit.GenerateObject.Component.MapComponent;
import com.safonov_iv.roelredit.Map.Coordinate.Enum.MapType;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Common.Setting;



@SuppressLint("ViewConstructor")
public class FieldMap002 extends AbstractMap {
    private final EditMap editMap;
    private final UpdateSelectCursor updateCursor;
    private final DisplayImpl displayImpl;

    public FieldMap002(Context context, Window window) {
        super(context);
        Utils.setFullScreen(window);
        updateCursor = new UpdateSelectCursor(Setting.getInstance().getCamera().getCursor());
        MapPrototype exploreMap = MapPrototype.getInstance();
        exploreMap.setMapName("map_004");
        exploreMap.setMapValues(MapComponent.getMap(MapType.Simply,setting));

        editMap = new EditMap(context, exploreMap);
        displayImpl = DisplayImpl.getInstance();
        displayImpl.setExploreMap(exploreMap);
        displayImpl.updateBoundsMap();
        displayImpl.updateDrawArea();


    }

    @Override
    public void update() {
        super.update();
        editMap.update();

        if (updateCursor.isUpdatedCursorPosition()) {
            editMap.getCollision(cursor.getActiveCursorX(), cursor.getActiveCursorY());

        }

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        displayImpl.draw(canvas);
        editMap.draw(canvas);

    }
}
