package com.safonov_iv.roelredit.GenerateObject.Component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapMulti extends BitmapComponent {

    private Bitmap bitmap;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private double distance=0;


    public BitmapMulti(Context context, int bitmapId, int startX, int startY, int endX, int endY, double distance) {
        super(context, bitmapId);
        this.distance=distance;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        bitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createBitmap(bitmap, startX, startY, endX, endY);
    }


    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public Bitmap getCopyOriginalBitmap() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        return Bitmap.createBitmap(bitmap, startX, startY, endX, endY);
    }

    @Override
    public Bitmap resetToOriginalBitmapAndGetRef() {
        bitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap=Bitmap.createBitmap(bitmap, startX, startY, endX, endY);
        return bitmap;
    }

    @Override
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
