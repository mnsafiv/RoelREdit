package com.safonov_iv.roelredit.EditMap.ClickOnStatus.RectItem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.safonov_iv.roelredit.GenerateObject.Battle.PersonData.CharacterModel;

public class ButtonIncreaseLevelEdit extends ActionOnClickImpl {
    private Rect bitmapRect;
    private Bitmap bitmap;
    private CharacterModel characterModel;
    private ActionOnClickImpl levelText;

    public ButtonIncreaseLevelEdit(Context context, int id, int numberPosition, int number, int size, CharacterModel characterModel, ActionOnClickImpl levelText) {
        this.characterModel = characterModel;
        this.levelText = levelText;

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
        int level = characterModel.getInfo().getCharacterProgress().getLevel();
        level = level < 100 ? level + 1 : level;
        characterModel.getInfo().getCharacterProgress().setLevel(level);
        levelText.updateStatus();
        return false;
    }
}
