package com.safonov_iv.roelredit.Test;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.Common.Setting;
import com.safonov_iv.roelredit.Cursor.Display.Display;
import com.safonov_iv.roelredit.Cursor.Display.DisplayObserver;
import com.safonov_iv.roelredit.Map.Coordinate.MapPrototype;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DisplayTest implements Display {
    private static DisplayTest display;
    private final Paint paint;
    @Setter
    private MapPrototype exploreMap;
    private final DisplayObserver displayObserver;
    private final int areaBorder;
    private final Rect drawArea = new Rect();


    private final Set<Integer> mapValuesKeys = new HashSet<>();

    private DisplayTest() {
        areaBorder = (int) -DefaultValue.DEFAULT_FIELD_SIZE * 2;
        displayObserver = new DisplayObserver();
        drawArea.set(
                -areaBorder,
                -areaBorder,
                Setting.getInstance().getCurrentWidth() + areaBorder,
                Setting.getInstance().getCurrentHeight() + areaBorder);
        paint = new Paint();
        paint.setColor(Color.DKGRAY);


    }

    public static synchronized DisplayTest getInstance() {
        if (display == null) {
            display = new DisplayTest();
        }
        return display;
    }


    @Override
    public void updateBoundsMap() {

    }

    @Override
    public void updateDrawArea() {
        int x = (int) Setting.getInstance().getCamera().getCameraX();
        int y = (int) Setting.getInstance().getCamera().getCameraY();


        drawArea.offset(-x, -y);


        int coordinate1 = Setting.getInstance().getFieldSetting().getCoordinate(drawArea.left, (double) drawArea.top);
        int topAreaX = Setting.getInstance().getFieldSetting().getAreaX(coordinate1);
        int topAreaY = Setting.getInstance().getFieldSetting().getAreaY(coordinate1);

        int coordinate2 = Setting.getInstance().getFieldSetting().getCoordinate(drawArea.right, (double) (drawArea.bottom));
        int bottomAreaX = Setting.getInstance().getFieldSetting().getAreaX(coordinate2) + 1;
        int bottomAreaY = Setting.getInstance().getFieldSetting().getAreaY(coordinate2) + 1;


        Set<Integer> newMapValuesKeys = new HashSet<>();

        for (int i = topAreaX; i < bottomAreaX; i++) {
            for (int j = topAreaY; j < bottomAreaY; j++) {
                newMapValuesKeys.add(Setting.getInstance().getFieldSetting().getCoordinate(i, j));
            }
        }

        Set<Integer> add = newMapValuesKeys.stream().filter(t -> !mapValuesKeys.contains(t)).collect(Collectors.toSet());
        Set<Integer> remove = mapValuesKeys.stream().filter(t -> !newMapValuesKeys.contains(t)).collect(Collectors.toSet());
        mapValuesKeys.addAll(add);
        mapValuesKeys.removeAll(remove);


        Set<MapValue> mapValues = new HashSet<>();
        add.forEach(t -> mapValues.add(exploreMap.getMapValues().get(t)));
        mapValues.remove(null);
        displayObserver.add(mapValues);
        mapValues.clear();
        remove.forEach(t -> mapValues.add(exploreMap.getMapValues().get(t)));
        mapValues.remove(null);
        displayObserver.remove(mapValues);

        drawArea.offsetTo(-areaBorder, -areaBorder);


    }

    @Override
    public void draw(Canvas canvas) {
        displayObserver.draw(canvas);
        canvas.drawRect(drawArea, paint);
    }

    @Override
    public void addToDrawArea(MapValue mapValue) {

    }

}
