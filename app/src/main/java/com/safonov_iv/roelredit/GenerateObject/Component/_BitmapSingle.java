package com.safonov_iv.roelredit.GenerateObject.Component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class _BitmapSingle extends BitmapComponent {

    private Bitmap bitmap;
    private int distance = 0;


    public _BitmapSingle(Context context, int bitmapId) {
        super(context, bitmapId);
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
    }


    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public Bitmap getCopyOriginalBitmap() {
        return BitmapFactory.decodeResource(context.getResources(), bitmapId);
    }

    @Override
    public Bitmap resetToOriginalBitmapAndGetRef() {
        bitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
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
