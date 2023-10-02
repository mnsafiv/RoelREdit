package com.safonov_iv.roelredit.GenerateObject.Component;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import com.safonov_iv.roelredit.Common.DefaultValue;
import com.safonov_iv.roelredit.MainActivity;
import com.safonov_iv.roelredit.R;
import com.safonov_iv.roelredit.Common.Setting;

import java.util.*;

public class PrototypeGrid extends Prototype {
    @SuppressLint("StaticFieldLeak")
    private static volatile PrototypeGrid prototypeGrid;
    private final Path path;


    public PrototypeGrid() {
        super();
        bitmaps = new HashMap<>();
        keys = new HashMap<>();
        path = Setting.getInstance().getGrid().getPath();

        initBitmapsValue(R.drawable.floor_001_6_4, "floor_001_6_4", 6, 4, 1);
        initBitmapsValue(R.drawable.water_001_6_4, "water_001_6_4", 6, 4, Integer.MAX_VALUE);


        updateBitmapFromCurrentResolution();

    }

    public static PrototypeGrid getInstance() {
        if (prototypeGrid == null) {
            prototypeGrid = new PrototypeGrid();
        }
        return prototypeGrid;
    }


    private void initBitmapsValue(int id, String key, int rowNumber, int rowMax, int distance) {
        Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.getContext().getResources(), id);


        int height = bitmap.getHeight() / rowMax;
        int width = bitmap.getWidth() / rowNumber;


        BitmapConfig bitmapConfig = new BitmapConfig(key);

        for (int i = 0; i < rowNumber * rowMax; i++) {
            String newKey = key + "_" + (i + 1);
            bitmaps.put(newKey, new BitmapMulti(MainActivity.getContext(), id, width * (i % rowNumber), height * (i / rowNumber), width, height, distance));
            bitmapConfig.addKey(newKey);


        }
        keys.put(key, bitmapConfig);


    }

    private void updateBitmapFromCurrentResolution() {

        final double cameraResolution = camera.getCameraResolution();
        int widthCur = (int) (DefaultValue.DEFAULT_FIELD_SIZE / cameraResolution);
        int heightCur = (int) (DefaultValue.DEFAULT_FIELD_SIZE / cameraResolution);


        bitmaps.forEach((key, value) -> {
            Bitmap bitmap = value.resetToOriginalBitmapAndGetRef();


            bitmap = Bitmap.createScaledBitmap(bitmap, widthCur, heightCur, false);

            final Bitmap outputBitmap = Bitmap.createBitmap(widthCur, heightCur, Bitmap.Config.ARGB_8888);
            final Canvas canvas1 = new Canvas(outputBitmap);
            canvas1.clipPath(path);
            canvas1.drawBitmap(bitmap, 0, 0, null);

            value.setBitmap(outputBitmap);

        });


    }


}
