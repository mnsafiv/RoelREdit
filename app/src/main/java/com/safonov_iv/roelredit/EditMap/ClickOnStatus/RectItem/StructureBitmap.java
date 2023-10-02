package com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.GenerateObject.Component.CharacterMap;

public class StructureBitmap extends ActionOnClickImpl {

    private Rect bitmapRect;
    private Bitmap bitmap;

    public StructureBitmap(Context context, int id, int numberPosition, int number, int height) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        int startX = bitmap.getWidth() / number * (numberPosition - 1);
        int endX = bitmap.getWidth() / number;
        int endY = bitmap.getHeight();
        bitmap = Bitmap.createBitmap(bitmap, startX, 0, endX, endY);
        calculate(height);
    }

    public StructureBitmap(int sourceId, int height) {
        bitmap = CharacterMap.getInstance().getBitmapById(sourceId);
        calculate(height);
    }

    private void calculate(int size) {
        double multiple = (double) bitmap.getHeight() / (double) bitmap.getWidth();
        bitmap = Bitmap.createScaledBitmap(bitmap, (int) (size / multiple), size, false);
        bitmapRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        rect = new Rect(bitmapRect);
    }

    public StructureBitmap(Bitmap bitmap) {
        int size = 30;

        double height = bitmap.getHeight();
        double width = bitmap.getWidth();
        double multiple = height / width;


        bitmap = Bitmap.createScaledBitmap(bitmap, size, (int) (size / multiple), false);


        bitmapRect = new Rect(0, 0, bitmap.getHeight(), bitmap.getWidth());
        rect = new Rect(bitmapRect);


    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, bitmapRect, rect, null);
    }


    @Override
    public boolean action() {

        return false;
    }


}
