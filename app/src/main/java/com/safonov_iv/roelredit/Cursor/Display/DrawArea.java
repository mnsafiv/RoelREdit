package com.safonov_iv.roelredit.Cursor.Display;

import com.safonov_iv.roelredit.Map.Coordinate.IconCoordinate;
import com.safonov_iv.roelredit.Map.Coordinate.MapValue;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.ArrayList;
import java.util.List;

public class DrawArea {
    private List<MapValue> mapValues = new ArrayList();
    private List<IconCoordinate> iconCoordinates = new ArrayList();
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public DrawArea() {
        final Camera camera = Camera.getCamera(Setting.getSetting());
        final int currentHeight = Setting.getSetting().getCurrentHeight();
        final int currentWidth = Setting.getSetting().getCurrentWidth();
        final double cameraResolution = camera.getCameraResolution();
        System.out.println();

    }
}
