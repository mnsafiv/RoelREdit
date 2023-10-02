package com.safonov_iv.roelredit.GenerateObject.Component;

import android.content.Context;
import android.graphics.Bitmap;
import lombok.Getter;


public abstract class BitmapComponent {

    @Getter
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
}
