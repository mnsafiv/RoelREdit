package com.safonov_iv.roelredit.GenerateObject.Component;

import android.content.Context;
import android.graphics.Bitmap;


public abstract class BitmapComponent {
    protected int bitmapId;
    protected Context context;

    public BitmapComponent(Context context, int bitmapId) {
        this.context = context;
        this.bitmapId = bitmapId;
    }

    public abstract double getDistance();


    public abstract Bitmap getBitmap();

    public abstract Bitmap getCopyOriginalBitmap();

    public abstract Bitmap resetToOriginalBitmapAndGetRef();

    public abstract void setBitmap(Bitmap bitmap);


    public int getBitmapId() {
        return bitmapId;
    }
}
