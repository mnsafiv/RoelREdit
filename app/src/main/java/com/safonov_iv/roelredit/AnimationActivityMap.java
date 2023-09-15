package com.safonov_iv.roelredit;

import android.app.Activity;
import android.os.Bundle;
import com.safonov_iv.roelredit.Map.FieldMap002;

public class AnimationActivityMap extends Activity {

    private FieldMap002 map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        map = new FieldMap002(getBaseContext(),getWindow());
        setContentView(map);

    }


    @Override
    protected void onResume() {
        super.onResume();
        map.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.pause();
    }

}
