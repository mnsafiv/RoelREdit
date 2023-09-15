package com.safonov_iv.roelredit.Cursor.Layer;

import com.safonov_iv.roelredit.Common.DefaultValue;

public class GridSetting {
    private final int capacity = 1000;
    private final int MARGIN = 2;
    private final float size;
    private float sizeMargin;
    private float height;
    private float nextX;
    private float nextY;
    private final GridType grid;


    public GridSetting(GridType grid) {
        this.grid = grid;
        this.size = DefaultValue.DEFAULT_FIELD_SIZE;
        sizeMargin = DefaultValue.DEFAULT_FIELD_SIZE + MARGIN;

        switch (grid) {
            case HexVertical:
                initializeVertical();
                break;
            case HexHorizontal:
                initializeHorizontal();
                break;
        }
    }

    private void initializeHorizontal() {
        height = (float) (sizeMargin * Math.cos(Math.toRadians(30))) / 2;
        nextX = (float) (sizeMargin * Math.cos(Math.toRadians(30)));
        nextY = (float) (sizeMargin * 1.5);
    }

    private void initializeVertical() {
        height = (float) (sizeMargin * Math.cos(Math.toRadians(30))) / 2;
        nextX = (float) (sizeMargin * 1.5);
        nextY = (float) (sizeMargin * Math.cos(Math.toRadians(30)));
    }

    public float getHeight() {
        return height;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getSize() {
        return size;
    }

    public float getNextX() {
        return nextX;
    }

    public float getNextY() {
        return nextY;
    }

    public GridType getGrid() {
        return grid;
    }
}
