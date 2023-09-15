package com.safonov_iv.roelredit;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.safonov_iv.roelredit.Common.Utils;
import com.safonov_iv.roelredit.GenerateObject.GenerateObjectAccess;
import com.safonov_iv.roelredit.Common.Setting;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.setFullScreen(getWindow());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Setting.getSetting().setDisplayBounds(getWindowManager().getCurrentWindowMetrics().getBounds());
        }

        setContentView(R.layout.activity_main);

        Button button_start_level = findViewById(R.id.startGame);
        Button button_request = findViewById(R.id.generateRandom);

        new GenerateObjectAccess(getBaseContext());




        button_start_level.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnimationActivityMapGetFromServer.class);
            startActivity(intent);
        });

        button_request.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnimationActivityMap.class);
            startActivity(intent);
        });
    }





}