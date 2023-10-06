package com.safonov_iv.roelredit;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import com.safonov_iv.roelredit.Common.Setting;
import com.safonov_iv.roelredit.Map.FieldMap;
import com.safonov_iv.roelredit.Map.FieldMap002;

public class AnimationActivityMapGetFromServer extends Activity {

    private FieldMap002 map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Setting.getInstance().setDisplayBounds(getWindowManager().getCurrentWindowMetrics().getBounds());
        }
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
