package com.safonov_iv.roelredit;

import android.app.Activity;
import android.os.Bundle;
import com.safonov_iv.roelredit.Map.FieldMap;

public class AnimationActivityMapGetFromServer extends Activity {

    private FieldMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        map = new FieldMap(getBaseContext(),getWindow());
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
