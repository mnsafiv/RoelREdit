package com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class ButtonDecreaseLevelAdd extends ActionOnClickImpl {
    private final Rect bitmapRect;
    private Bitmap bitmap;
    private StructureTextInt levelText;


    public ButtonDecreaseLevelAdd(Context context, int id, int numberPosition, int number, int size, StructureTextInt nameText) {
        this.levelText = nameText;

        bitmap = BitmapFactory.decodeResource(context.getResources(), id);


        int startX = bitmap.getWidth() / number * (numberPosition - 1);
        int endX = bitmap.getWidth() / number;
        int endY = bitmap.getHeight();


        bitmap = Bitmap.createBitmap(bitmap, startX, 0, endX, endY);
        bitmap = Bitmap.createScaledBitmap(bitmap, size, size, false);
        bitmapRect = new Rect(0, 0, bitmap.getHeight(), bitmap.getWidth());
        rect = new Rect(bitmapRect);
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, bitmapRect, rect, null);
    }


    @Override
    public boolean action() {
        levelText.setInt(levelText.getStrInt()-1);
        return true;
    }


}
