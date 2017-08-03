package com.android.lanjing.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Description:
 * Author: Lanjing
 * Time: 2016/9/4 15:14
 */
public class CustomIntentSerivce extends IntentService{
    public String TAG = getClass().getSimpleName();
    public static String EXTRA = "extra";

    private int i=0;

    public CustomIntentSerivce() {
        super("customintentservice");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent!=null){
            i = intent.getIntExtra(CustomIntentSerivce.EXTRA,-1);
        }
        Log.i(TAG, "i:  "+i+"   onHandleIntent Thread name: "+Thread.currentThread().getName()
                +"  id:"+Thread.currentThread().getId());
        /*Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Log.i(TAG, "i:  "+i+"   子Thread: "+Thread.currentThread().getId());
                    //wait(6000);
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();*/
        //可以在这个方法中处理耗时任务
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        Log.i(TAG, "CustomIntentSerivce  Thread: "+Thread.currentThread().getId());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
