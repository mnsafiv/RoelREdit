package com.safonov_iv.roelredit;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.safonov_iv.roelredit.Common.Utils;
import com.safonov_iv.roelredit.Common.Setting;
import com.safonov_iv.roelredit.Test.AnimationActivityMapTestDisplay;

public class MainActivity extends AppCompatActivity {

    public static Context getContext() {
        return mInstance.getApplicationContext();
    }
    private static MainActivity mInstance;
    public static synchronized MainActivity getInstance() {
        return mInstance;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = this;

        Utils.setFullScreen(getWindow());

        setContentView(R.layout.activity_main);

        Button button_start_level = findViewById(R.id.startGame);
        Button button_request = findViewById(R.id.generateRandom);
        Button button_test_draw_area = findViewById(R.id.testDrawArea);

        button_start_level.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnimationActivityMapGetFromServer.class);
            startActivity(intent);
        });

        button_request.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnimationActivityMap.class);
            startActivity(intent);
        });

        button_test_draw_area.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnimationActivityMapTestDisplay.class);
            startActivity(intent);
        });

    }





}