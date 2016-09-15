package com.example.ilhamsabar.cobadiet;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by ilham sabar on 2/23/2016.
 */
public class Utils {

    public static final int NOTIFICATION_ID = 1284885;
    public static NotificationManager mManager;
    public static Notification myNotication;


    public static void generateNotification(Context context){

//        mManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
//        Intent intent1 = new Intent(context,Utils.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context,0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
//
//
//        Notification.Builder builder = new Notification.Builder(context);
//        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        builder.setAutoCancel(true);
//        builder.setTicker("Notifikasi Imunisasi");
//        builder.setContentTitle("Notifikasi Imunisasi");
//        builder.setSmallIcon(R.mipmap.icon);
//        builder.setContentIntent(pendingIntent);
//        builder.setOngoing(true);
//        //builder.setSubText("Bunda, hari ini waktunya Imunisasi !");   //API level 16
//        builder.setNumber(1);
//        builder.build();
//
//        myNotication = builder.getNotification();
//        mManager.notify(11, myNotication);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.icon);
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        builder.setContentIntent(pendingIntent);

        builder.setSmallIcon(R.drawable.icon);
        builder.setContentTitle("Diet Sehat");
        builder.setContentText("dadeaeadsa");
        builder.setAutoCancel(true);
        builder.setWhen(5);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        // Will display the notification in the notification bar
        notificationManager.notify(NOTIFICATION_ID, builder.build());

        PendingIntent notifIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class),0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Diet Sehat")
                .setContentText("Waktunya Diet");
        mBuilder.setContentIntent(notifIntent);
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }
}
