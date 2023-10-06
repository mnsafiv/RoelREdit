package com.safonov_iv.roelredit.GenerateObject.Component;

import android.graphics.Bitmap;


public abstract class BitmapComponent {

    public abstract double getDistance();


    public abstract Bitmap getBitmap();

    public abstract Bitmap getCopyOriginalBitmap();

    public abstract Bitmap resetToOriginalBitmapAndGetRef();

    public abstract void setBitmap(Bitmap bitmap);
}
