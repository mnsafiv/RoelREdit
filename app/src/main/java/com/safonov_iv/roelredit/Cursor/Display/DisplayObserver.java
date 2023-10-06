package com.safonov_iv.roelredit.Cursor.Display;

import android.graphics.Canvas;
import com.safonov_iv.roelredit.Cursor.Layer.FieldSetting;
import com.safonov_iv.roelredit.Cursor.Layer.GridDraw;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DisplayObserver {
    private final GridDraw grid;
    private final FieldSetting setting;
    @Getter
    private final SortedSet<MapValue> mapValues;

    public DisplayObserver() {
        this.grid = Setting.getInstance().getGrid();
        this.setting = Setting.getInstance().getFieldSetting();
        mapValues = new TreeSet<>((o1, o2) -> {
            if (o1.getCoordinate() == o2.getCoordinate())
                return 0;
            return o1.getCoordinate() < o2.getCoordinate() ? -1 : 1;
        });

    }

    public void add(@NotNull Set<MapValue> mapValues) {
        this.mapValues.addAll(mapValues);

    }

    public void remove(@NotNull Set<MapValue> mapValues) {
        this.mapValues.removeAll(mapValues);
    }

    public void draw(Canvas canvas) {
        mapValues.forEach(t -> t.drawGrid(canvas, grid, setting));
        mapValues.forEach(t->t.drawDecorate(canvas));

    }


}
