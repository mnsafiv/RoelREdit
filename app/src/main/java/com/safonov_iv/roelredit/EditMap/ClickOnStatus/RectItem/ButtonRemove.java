package com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterModel;
import com.safonov_iv.roelredit.GenerateObject.Model.MapGroupModel;

public class ButtonRemove extends ActionOnClickImpl {
    private final Rect bitmapRect;
    private Bitmap bitmap;

    private final MapGroupModel mapGroupModel;
    private final CharacterModel characterModel;

    public ButtonRemove(Context context, int id, int numberPosition, int number, int size, MapGroupModel mapGroupModel, CharacterModel characterModel) {
        this.mapGroupModel = mapGroupModel;
        this.characterModel = characterModel;

        bitmap = BitmapFactory.decodeResource(context.getResources(), id);

        int startX = bitmap.getWidth() / number * (numberPosition - 1);
        int endX = bitmap.getWidth() / number;
        int endY = bitmap.getHeight();


        bitmap = Bitmap.createBitmap(bitmap, startX, 0, endX, endY);
        bitmap = Bitmap.createScaledBitmap(bitmap, size, size, false);
        bitmapRect = new Rect(0, 0, bitmap.getHeight(), bitmap.getWidth());
        this.rect = new Rect(bitmapRect);


    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, bitmapRect, rect, null);
    }


    @Override
    public boolean action() {
        mapGroupModel.remove(characterModel);
        return true;
    }
}
