package com.safonov_iv.roelredit.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.Window;
import com.safonov_iv.roelredit.Common.Utils;
import com.safonov_iv.roelredit.Cursor.Display.UpdateSelectCursor;
import com.safonov_iv.roelredit.EditMap.EditMap;
import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusPrototype;
import com.safonov_iv.roelredit.GenerateObject.Component.MapComponent;
import com.safonov_iv.roelredit.GenerateObject.GenerateObjectAccess;
import com.safonov_iv.roelredit.Map.Coordinate.Enum.MapType;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Map.Decorate.FieldPrototype;
import com.safonov_iv.roelredit.Map.Decorate.MapField;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.Map;


@SuppressLint("ViewConstructor")
public class FieldMap002 extends AbstractMap {

    private final FieldPrototype field;
    private final EditMap editMap;
    private final UpdateSelectCursor updateCursor;

    public FieldMap002(Context context, Window window) {
        super(context);
        Utils.setFullScreen(window);
        updateCursor = new UpdateSelectCursor(Setting.getSetting().getCamera().getCursor());
        final Map<Integer, MapValue> map = MapComponent.getMap(MapType.Simply, setting);
        MapPrototype exploreMap = new MapPrototype("map_004", map);
        exploreMap.setGrid(setting.getGrid());
        exploreMap.setSetting(setting.getFieldSetting());
        field = new MapField(setting, exploreMap);
        editMap = new EditMap(context, setting, exploreMap);

        final BonusPrototype bonusPrototype = GenerateObjectAccess.bonusPrototype;
        System.out.println();


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
        field.draw(canvas);
        editMap.draw(canvas);

    }
}
