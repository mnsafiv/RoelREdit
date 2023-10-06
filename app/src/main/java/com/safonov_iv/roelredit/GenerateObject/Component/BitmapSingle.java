package com.safonov_iv.roelredit.GenerateObject.Component;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapSingle extends BitmapComponent {

    private Bitmap bitmap;
    private double distance = 0;


    public BitmapSingle(Bitmap bitmap, double distance) {
        this.bitmap=bitmap;
        this.distance = distance;
    }


    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public Bitmap getCopyOriginalBitmap() {
        return bitmap;
    }

    @Override
    public Bitmap resetToOriginalBitmapAndGetRef() {
        return bitmap;
    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
