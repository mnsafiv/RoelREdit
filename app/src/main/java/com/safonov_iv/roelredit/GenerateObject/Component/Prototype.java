package com.safonov_iv.roelredit.GenerateObject.Component;

import android.graphics.Bitmap;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Common.Setting;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;

public abstract class Prototype {
    protected Map<String, BitmapComponent> bitmaps;
    @Getter
    protected Map<String, BitmapConfig> keys;
    protected Camera camera;

    public Prototype() {
        this.camera= Setting.getInstance().getCamera();


    }


    public Bitmap getBackGroundBitmap(String backGroundType) {
        return Objects.requireNonNull(bitmaps.get(backGroundType)).getBitmap();
    }



    public Bitmap getCopyFullBackGroundBitmap(String backGroundType) {
        return Objects.requireNonNull(bitmaps.get(backGroundType)).getCopyOriginalBitmap();
    }

    public BitmapComponent getBitmapComponent(String backGroundType) {
        return bitmaps.get(backGroundType);
    }



}
