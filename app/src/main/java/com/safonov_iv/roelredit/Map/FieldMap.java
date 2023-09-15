package com.safonov_iv.roelredit.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.Window;
import com.safonov_iv.roelredit.Common.Utils;
import com.safonov_iv.roelredit.Cursor.Display.UpdateSelectCursor;
import com.safonov_iv.roelredit.EditMap.EditMap;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Decorate.FieldPrototype;
import com.safonov_iv.roelredit.Map.Decorate.MapField;
import com.safonov_iv.roelredit.Repo.Data.MapDataGet;


@SuppressLint("ViewConstructor")
public class FieldMap extends AbstractMap {

    private final FieldPrototype field;
    private EditMap editMap;
    private final UpdateSelectCursor updateCursor;

    public FieldMap(Context context, Window window) {
        super(context);
        Utils.setFullScreen(window);

        updateCursor = new UpdateSelectCursor(setting.getCamera().getCursor());


        MapDataGet mapDataGet = new MapDataGet();

        Thread threadQuery = new Thread(mapDataGet);
        threadQuery.start();

        MapPrototype mapPrototype = mapDataGet.getMap().getMapPrototype(setting);

        field = new MapField(setting, mapPrototype);
        editMap = new EditMap(getContext(), setting,mapPrototype);




    }



    @Override
    public void update() {
        super.update();
        editMap.update();

        if (updateCursor.isUpdatedCursorPosition()) {
            editMap.getCollision(cursor.getActiveCursorX(),cursor.getActiveCursorY());

        }

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        field.draw(canvas);
        editMap.draw(canvas);

    }
}
