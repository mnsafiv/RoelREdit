package com.safonov_iv.roelredit.Cursor.Display;


import android.graphics.Bitmap;
import com.safonov_iv.roelredit.Common.Utils;
import com.safonov_iv.roelredit.Common.Setting;
import org.jetbrains.annotations.NotNull;


public final class Camera {
    private static volatile Camera camera;

    private float moveX;
    private float moveY;
    private CameraState state;
    private double cameraX;
    private double cameraY;
    private double distance;
    private double startX;
    private double startY;
    public CameraResolution cameraResolution;
    private final CursorPosition cursorPosition;

    //for update fixate position
    private double positionCameraX;
    private double positionCameraY;

    private final PanelControl panelControl;


    private Camera(Setting setting) {
        this.cameraX = 0;
        this.cameraY = 0;
        this.cursorPosition = new CursorPosition(this, setting.getFieldSetting());
        this.cameraResolution = new CameraResolution();
        this.state = CameraState.isUp;
        this.panelControl = new PanelControl();
    }

    public static Camera getCamera(Setting setting) {
        if(camera==null){
            camera=new Camera(setting);
        }
        return camera;
    }

    private void setIsDown(float x, float y) {
        moveX = x;
        moveY = y;
        distance = 0;
        startX = cameraX;
        startY = cameraY;



        if (checkCollision(x, y)) {
            state = CameraState.isLock;
        } else {
            state = CameraState.isDown;
        }


    }

    private boolean checkCollision(float x, float y) {
        //collision with panel

        final boolean collision = panelControl.getCollision((int) x, (int) y);
        final boolean actionCollision = panelControl.getActionCollision((int) x, (int) y);


        return collision || actionCollision;
    }

    public void setIsMoving(float x, float y) {
        switch (state) {
            case isMove:
            case isDown:
                isMoving(x, y);
                break;
            case isUp:
                setIsDown(x, y);
                break;
            case isLock:
                isLock(x, y);
                break;
        }


    }


    private void isLock(float x, float y) {
        int distanceX = (int) Utils.getDistanceBetweenTwoPoints(startX, 0, cameraX - moveX + x, 0);
        int distanceY = (int) Utils.getDistanceBetweenTwoPoints(0, startY, 0, cameraY - moveY + y);

        distance = Utils.getDistanceBetweenTwoPoints(startX, startY, cameraX - moveX + x, cameraY - moveY + y);

        if (moveX > x) {
            distanceX = -distanceX;
        }
        if (moveY > y) {
            distanceY = -distanceY;
        }



        moveX = x;
        moveY = y;





        panelControl.shift(distanceX, distanceY);



    }

    private void isMoving(float x, float y) {
        //need fix
        double prevDistance = distance;
        distance = Utils.getDistanceBetweenTwoPoints(startX, startY, cameraX - moveX + x, cameraY - moveY + y);
        if (Math.abs(prevDistance - distance) > 100) {
            moveX = x;
            moveY = y;
            return;
        }


        cameraX = (float) (cameraX - moveX + x);
        cameraY = (float) (cameraY - moveY + y);

        moveX = x;
        moveY = y;
        state = CameraState.isMove;
    }

    public PanelControl getPanelControl() {
        return panelControl;
    }

    public void setIsUp() {

        state = CameraState.isUp;
    }

    public double getCameraX() {
        return positionCameraX;
    }

    public double getCameraY() {
        return positionCameraY;
    }


    public double getDistanceToCameraX(double x) {
        return (x + positionCameraX) * cameraResolution.getResolutionSize();
    }

    public double getDistanceToCameraY(double y) {
        return (y + positionCameraY) * cameraResolution.getResolutionSize();
    }


    public double getDistanceDisplayToCameraX(double x) {
        return x - positionCameraX;
    }

    public double getDistanceDisplayToCameraY(double y) {
        return y - positionCameraY;
    }


    public void update() {
        positionCameraX = cameraX;
        positionCameraY = cameraY;

    }

    public CursorPosition getCursor() {
        return cursorPosition;
    }

    public double getCenterBitmapToCameraX(@NotNull Bitmap bitmap, double centerX) {
        return getDistanceToCameraX(centerX - bitmap.getWidth() / 2);
    }

    public double getCenterBitmapToCameraY(@NotNull Bitmap bitmap, double centerY) {
        return getDistanceToCameraY(centerY - bitmap.getHeight() / 2);
    }


    public double getCameraResolution() {
        return cameraResolution.getResolutionSize();
    }
}
