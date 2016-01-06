package com.example.ilhamsabar.cobadiet;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by ilham sabar on 11/4/2015.
 */
public class AlaramReceiver extends BroadcastReceiver {
    public static final int NOTIFICATION_ID = 1284885;

    @Override
    public void onReceive(Context context, Intent intent) {

        buatnotif(context, "Menu diet Hari ini", "Sarapan", "Pesan");

    }

    public void buatnotif( Context context, String msg, String msgText, String msgAlert){

//        NotificationCompat.Builder buildeer = new NotificationCompat.Builder(getActivity().getApplicationContext());
//        buildeer.setSmallIcon(R.drawable.icon);
//        buildeer.setSubText("Tap to view documentation about notifications.");
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
                .setContentTitle(msg)
                .setTicker(msgAlert)
                .setContentText(msgText);
        mBuilder.setContentIntent(notifIntent);
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }
}

