package com.safonov_iv.roelredit.Common;


import android.graphics.Rect;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Cursor.Layer.*;

public class Setting {

    private static volatile Setting setting;
    private final Camera camera;
    private final GridDraw grid;
    private final FieldSetting fieldSetting;
    private final GridSetting gridSetting;
    private Rect displayBounds;


    private Setting(GridType gridType) {
        //grid type
        this.gridSetting = new GridSetting(gridType);
        if (gridType == GridType.HexVertical) {
            this.fieldSetting = new HexVertical(this);
        } else {
            this.fieldSetting = new HexHorizontal(this);
        }


        this.camera = Camera.getCamera(this);
        this.grid = new HexGrid(DefaultValue.DEFAULT_FIELD_SIZE / 2, gridType, camera);


    }


    public static Setting getSetting() {
        if (setting == null) {
            setting = new Setting(DefaultValue.GRID_TYPE);
        }
        return setting;
    }

    public GridDraw getGrid() {
        return grid;
    }

    public FieldSetting getFieldSetting() {
        return fieldSetting;
    }


    public GridSetting getGridSetting() {
        return gridSetting;
    }


    public Camera getCamera() {
        return camera;
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
