package com.safonov_iv.roelredit.GenerateObject.Component;

import android.content.Context;
import android.graphics.Bitmap;
import com.safonov_iv.roelredit.Cursor.Display.Camera;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.Map;

public abstract class Prototype {
    protected Map<String, BitmapComponent> bitmaps;
    protected Map<String, BitmapConfig> keys;
    protected Camera camera;
    protected Context context;

    public Prototype(Context context) {
        this.context=context;
        this.camera= Setting.getSetting().getCamera();


    }


    public Bitmap getBackGroundBitmap(String backGroundType) {
        return bitmaps.get(backGroundType).getBitmap();
    }

    public Map<String, BitmapConfig> getKeys() {
        return keys;
    }



    public Bitmap getCopyFullBackGroundBitmap(String backGroundType) {
        return bitmaps.get(backGroundType).getCopyOriginalBitmap();
    }

    public BitmapComponent getBitmapComponent(String backGroundType) {
        return bitmaps.get(backGroundType);
    }



}
