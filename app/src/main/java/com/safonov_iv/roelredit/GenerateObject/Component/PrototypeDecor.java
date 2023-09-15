package com.safonov_iv.roelredit.GenerateObject.Component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.safonov_iv.roelredit.R;

import java.util.*;

public class PrototypeDecor extends Prototype{
    private volatile static PrototypeDecor prototypeDecor;


    private PrototypeDecor(Context context) {
        super(context);
        bitmaps = new HashMap<>();
        keys = new HashMap<>();

        initBitmapsValue(R.drawable.tree_002_4_2, "tree_002_4_2", 4, 2, 0);
        initBitmapsValue(R.drawable.tree_001_2_2, "tree_001_2_2", 2, 2, 0);
        initBitmapsValue(R.drawable.tree_003_2_1, "tree_003_2_1", 2, 1, 0);

    }


    public static synchronized PrototypeDecor getPrototypeDecor(Context context) {
        if(prototypeDecor==null){
            prototypeDecor=new PrototypeDecor(context);
        }
        return prototypeDecor;
    }

    private void initBitmapsValue(int id, String key, int rowNumber, int rowMax, int distance) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), id);
        int height = bitmap.getHeight() / rowMax;
        int width = bitmap.getWidth() / rowNumber;

        BitmapConfig bitmapConfig = new BitmapConfig(key);

        for (int i = 0; i < rowNumber * rowMax; i++) {
            String newKey = key + "_" + (i + 1);
            bitmaps.put(newKey, new BitmapMulti(context, id, width * (i % rowNumber), height * (i / rowNumber), width, height, distance));
            bitmapConfig.addKey(newKey);

        }
        keys.put(key, bitmapConfig);


    }


    public Bitmap getBackGroundBitmap(String item, double resolution) {
        final Bitmap bitmap = bitmaps.get(item).getBitmap();
        System.out.println();
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * resolution), (int) (bitmap.getHeight() * resolution), false);
    }




}
