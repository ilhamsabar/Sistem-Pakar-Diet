package com.example.ilhamsabar.cobadiet;

import android.app.Application;

/**
 * Created by ilham sabar on 11/24/2015.
 */
public class MyAlarm extends Application {
    public int notificationCount;
    @Override
    public void onCreate() {
        super.onCreate();
        notificationCount = 0;
    }
    public void incrementCount(){
        notificationCount ++;
    }
    public int getNotificationCount(){
        return notificationCount;
    }
}
