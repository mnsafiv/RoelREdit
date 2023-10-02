package com.safonov_iv.roelredit.GenerateObject.Component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.GenerateObject.Model.CharacterBitmapModel;
import com.safonov_iv.roelredit.MainActivity;
import com.safonov_iv.roelredit.R;

import java.util.HashMap;
import java.util.Map;

public class CharacterMap {

    private static CharacterMap cm;
    private final Map<Integer, Bitmap> characterMap = new HashMap<>();
    private final int maxCameraResolution = 1;
    private final int sizeImage = (int) DefaultValue.DEFAULT_FIELD_SIZE / 2;
    private final int sizeAspect = 2;



    private CharacterMap(Context context) {

        Bitmap bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.character_archer_001);
        int endX = bitmap1.getWidth() / 2;
        int endY = bitmap1.getHeight();

        CharacterBitmapModel.getInstance().getCharacterBitmaps().forEach((key, value) -> {
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), value.getId());
            Bitmap bitmapMaxSize = Bitmap.createBitmap(bitmap, 0, 0, endX, endY);
            bitmapMaxSize = Bitmap.createScaledBitmap(bitmapMaxSize, maxCameraResolution * sizeImage, maxCameraResolution * sizeImage * sizeAspect, false);
            characterMap.put(value.getId_bitmap(), bitmapMaxSize);
        });

    }

    public static synchronized CharacterMap getInstance() {
        if (cm == null) {
            cm = new CharacterMap(MainActivity.getContext());
        }
        return cm;
    }
    public Bitmap getBitmapById(int id) {
        return characterMap.get(id);
    }

}
