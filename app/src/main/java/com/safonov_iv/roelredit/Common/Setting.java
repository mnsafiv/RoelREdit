package com.safonov_iv.roelredit.Common;


import android.graphics.Rect;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Cursor.Layer.*;
import lombok.Getter;

public class Setting {

    private static volatile Setting setting;
    @Getter
    private final GridDraw grid;
    @Getter
    private final FieldSetting fieldSetting;
    @Getter
    private final GridSetting gridSetting;
    @Getter
    private final Camera camera;
    private Rect displayBounds;


    private Setting(GridType gridType) {
        //grid type
        this.gridSetting = new GridSetting(gridType);
        if (gridType == GridType.HexVertical) {
            this.fieldSetting = new HexVertical(this);
        } else {
            this.fieldSetting = new HexHorizontal(this);
        }


        this.camera = Camera.getInstance(this);
        this.grid = new HexGrid(DefaultValue.DEFAULT_FIELD_SIZE / 2, gridType, camera);


    }


    public static Setting getInstance() {
        if (setting == null) {
            setting = new Setting(DefaultValue.GRID_TYPE);
        }
        return setting;
    }

    public void setDisplayBounds(Rect bounds) {
        displayBounds = bounds;
    }

    public int getCurrentHeight() {
        return displayBounds.height();
    }

    public int getCurrentWidth() {
        return displayBounds.width();
    }
}
