package com.chenqi.backapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * 自定义检查手机网络状态是否切换的广播接受器
 *
 * @author cj
 */
public class NetBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // 如果相等的话就说明网络状态发生了变化
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            int netWorkState = NetUtil.getNetWorkState(context);
            // 接口回调传过去状态的类型
            switch (netWorkState) {
                case -1:
                    Toast.makeText(context, "没有连接网络", Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    Toast.makeText(context, "移动网络", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(context, "无线网络连接", Toast.LENGTH_SHORT).show();
                    startApp(context);
                    break;

            }

        }
    }

    /**
     * 启动应用
     */
    private void startApp(Context context) {
        Intent intentActivity = context.getPackageManager()
                .getLaunchIntentForPackage("com.chenqi.backapp");
        context.startActivity(intentActivity);
    }


}  
  
