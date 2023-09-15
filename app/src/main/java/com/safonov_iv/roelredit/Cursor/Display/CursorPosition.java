package com.safonov_iv.roelredit.Cursor.Display;

import com.safonov_iv.roelredit.Cursor.Layer.FieldSetting;

import java.util.HashMap;
import java.util.Map;

public class CursorPosition {

    private final Camera camera;
    private final FieldSetting setting;

    private final Map<Integer, CursorCounter> counter = new HashMap<>();

    private int activeCursorX = -1;
    private int activeCursorY = -1;

    private int cursorPositionX = -1;
    private int cursorPositionY = -1;

    private int cursorCoordinate = -1;
    private int controlNumber = -1;

    public CursorPosition(Camera camera, FieldSetting setting) {
        this.camera = camera;
        this.setting = setting;
    }


    public int getActiveCursorX() {
        return activeCursorX;
    }

    public int getActiveCursorY() {
        return activeCursorY;
    }


    public int getCursorCoordinate() {
        return cursorCoordinate;
    }

    public void setActiveCursor(float positionX, float positionY) {
        this.activeCursorX = (int) positionX;
        this.activeCursorY = (int) positionY;
    }


    public void setSelectCursor(int actionIndex, float positionX, float positionY) {
        final CursorCounter cursorCounter = counter.get(actionIndex);

        if (cursorCounter == null) {
            return;
        }

        if (cursorCounter.checkDistance(10, positionX, positionY)) {
            double resolution = camera.cameraResolution.getResolutionSize();

            this.cursorCoordinate = setting.getCoordinate(
                    (positionX / resolution - camera.getCameraX()),
                    (positionY / resolution - camera.getCameraY()));

            controlNumber = Integer.valueOf(cursorPositionX).hashCode() +
                    Integer.valueOf(cursorPositionY).hashCode();


            this.cursorPositionX = (int) positionX;
            this.cursorPositionY = (int) positionY;


        }

        counter.remove(cursorCounter);


    }

    public int getCursorPositionX() {
        return cursorPositionX;
    }

    public int getCursorPositionY() {
        return cursorPositionY;
    }

    public int getControlNumber() {
        return controlNumber;
    }

    public void addCursor(int index, float positionX, float positionY) {
        counter.put(index, new CursorCounter(positionX, positionY));
    }

    public void refreshCounterCursor() {
        counter.clear();
    }


}
