package com.safonov_iv.roelredit.GenerateObject.Component;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.safonov_iv.roelredit.MainActivity;
import com.safonov_iv.roelredit.R;

import java.util.*;

public class PrototypeDecor extends Prototype{
    private volatile static PrototypeDecor prototypeDecor;


    private PrototypeDecor() {
        super();
        bitmaps = new HashMap<>();
        keys = new HashMap<>();

        initBitmapsValue(R.drawable.tree_002_4_2, "tree_002_4_2", 4, 2, 0);
        initBitmapsValue(R.drawable.tree_001_2_2, "tree_001_2_2", 2, 2, 0);
        initBitmapsValue(R.drawable.tree_003_2_1, "tree_003_2_1", 2, 1, 0);

    }


    public static synchronized PrototypeDecor getInstance() {

        if(prototypeDecor==null){
            prototypeDecor=new PrototypeDecor();
        }
        return prototypeDecor;
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


    public Bitmap getBackGroundBitmap(String item, double resolution) {
        final Bitmap bitmap = Objects.requireNonNull(bitmaps.get(item)).getBitmap();
        System.out.println();
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * resolution), (int) (bitmap.getHeight() * resolution), false);
    }




}
