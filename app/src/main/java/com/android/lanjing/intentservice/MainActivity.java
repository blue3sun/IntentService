package com.android.lanjing.intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testIntentService();
            }
        });
    }

    private void testIntentService() {
        Intent intent1 = new Intent(MainActivity.this,CustomIntentSerivce.class);
        intent1.putExtra(CustomIntentSerivce.EXTRA,1);
        startService(intent1);

        Intent intent2 = new Intent(MainActivity.this,CustomIntentSerivce.class);
        intent2.putExtra(CustomIntentSerivce.EXTRA,2);
        startService(intent2);

        Intent intent3 = new Intent(MainActivity.this,CustomIntentSerivce.class);
        intent3.putExtra(CustomIntentSerivce.EXTRA,3);
        startService(intent3);

    }
}
