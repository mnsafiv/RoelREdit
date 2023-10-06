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
import java.util.Objects;

public class FieldShow extends PanelEditProperties {


    public FieldShow(Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_show_group);


    }

    @Override
    public boolean getAction() {
        final MapValue mapValue = MapPrototype.getInstance().getMapValues().get(Setting.getInstance().getCamera().getCursor().getCursorCoordinate());
        final Map<BonusType, Double> bonus = Objects.requireNonNull(mapValue).getBonus();
        return true;
    }




    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, rect, null);

    }


}
