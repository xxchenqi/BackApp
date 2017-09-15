package com.chenqi.backapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int netWorkState = NetUtil.getNetWorkState(MainActivity.this);
                switch (netWorkState) {
                    case -1:
                        Toast.makeText(MainActivity.this, "没有连接网络", Toast.LENGTH_SHORT).show();
                        start();
                        finish();
                        break;
                    case 0:
                        Toast.makeText(MainActivity.this, "移动网络", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "无线网络", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, 10*1000);
    }

    public void startWifi(View view) {
        start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Toast.makeText(this, "回退触发", Toast.LENGTH_SHORT).show();
//        start();
    }

    private void start() {
        Intent intent = new Intent();
        intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
        startActivity(intent);
    }

}
