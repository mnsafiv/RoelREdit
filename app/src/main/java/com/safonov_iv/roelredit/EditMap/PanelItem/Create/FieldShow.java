package com.safonov_iv.roelredit.EditMap.PanelItem.Create;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import com.safonov_iv.roelredit.GenerateObject.Bonus.BonusType;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.R;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.Map;

public class FieldShow extends PanelEditProperties {


    public FieldShow(Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_show_group);


    }

    @Override
    public boolean getAction(MapPrototype map) {
        final MapValue mapValue = map.getMapValues().get(Setting.getInstance().getCamera().getCursor().getCursorCoordinate());
        final Map<BonusType, Double> bonus = mapValue.getBonus();
        System.out.println();
        return true;
    }




    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, rect, null);

    }


    @Override
    public void reset(Setting setting) {
    }

    @Override
    public void update() {


    }


}
