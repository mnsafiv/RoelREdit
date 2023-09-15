package com.safonov_iv.roelredit.Map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Cursor.Display.CursorPosition;
import com.safonov_iv.roelredit.Cursor.Display.PanelControl;
import com.safonov_iv.roelredit.Cursor.Display.StatusCursor;
import com.safonov_iv.roelredit.R;
import com.safonov_iv.roelredit.Common.Setting;


public abstract class AbstractMap extends SurfaceView implements SurfaceHolder.Callback {

    protected Thread thread;
    protected final GameLoop gameLoop;
    protected Setting setting;
    protected CursorPosition cursor;
    private final Camera camera;
    private final PanelControl panelControl;


    public AbstractMap(Context context) {
        super(context);
        this.setting = Setting.getSetting();
        this.cursor = setting.getCamera().getCursor();
        this.camera = setting.getCamera();
        SurfaceHolder surfaceHolder = getHolder();
        gameLoop = new GameLoop(this, surfaceHolder);

        panelControl = new PanelControl();

        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(getContext(), R.color.ColorText));
        paint.setTextSize(25);
        statCursor = new StatusCursor(paint);
    }


    public void update() {
        //update camera position
        camera.update();

    }

    public void start() {
        thread = new Thread(gameLoop);
        thread.start();
    }


    public void pause() {
        gameLoop.setRunning(false);
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread = null;

    }

    StatusCursor statCursor;

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                cursor.addCursor(event.getActionIndex(),event.getX(), event.getY());
                cursor.setActiveCursor(event.getX(), event.getY());
                return true;

            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getPointerCount() == 2) {
                    camera.cameraResolution.startChangeResolution(
                            event.getX(0),
                            event.getY(0),
                            event.getX(1),
                            event.getY(1));
                }


                cursor.addCursor(event.getActionIndex(),event.getX(event.getActionIndex()), event.getX(event.getActionIndex()));
                cursor.setActiveCursor(event.getX(event.getActionIndex()), event.getX(event.getActionIndex()));

                return true;

            case MotionEvent.ACTION_MOVE:
                camera.setIsMoving(event.getX(), event.getY());

                statCursor.changeCursor(event.getX(event.getActionIndex()), event.getY(event.getActionIndex()));

                if (event.getPointerCount() == 2) {
                    cursor.refreshCounterCursor();
                    camera.cameraResolution.changeResolution(
                            event.getX(0),
                            event.getY(0),
                            event.getX(1),
                            event.getY(1));
                }


                return true;

            case MotionEvent.ACTION_UP:
                cursor.setSelectCursor(event.getActionIndex(),event.getX(), event.getY());
                camera.setIsUp();
                return true;

            case MotionEvent.ACTION_POINTER_UP:

                cursor.setSelectCursor(event.getActionIndex(),event.getX(event.getActionIndex()), event.getX(event.getActionIndex()));
                cursor.refreshCounterCursor();
                camera.setIsUp();


                return true;

        }


        return super.onTouchEvent(event);
    }

    @Override
    public void draw(Canvas canvas) {

        super.draw(canvas);
        statCursor.draw(canvas);

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }


}
