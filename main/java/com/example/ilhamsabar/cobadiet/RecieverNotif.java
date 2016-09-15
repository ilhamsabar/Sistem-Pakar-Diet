package com.example.ilhamsabar.cobadiet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ilham sabar on 2/23/2016.
 */
public class RecieverNotif extends BroadcastReceiver {
    MediaPlayer player;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "Bunda, hari ini waktunya Imunisasi !", Toast.LENGTH_LONG).show();

        player = MediaPlayer.create(context, R.drawable.alarm2);
        player.start();
		/*Intent service1 = new Intent(context, MyAlarmService.class);
	     context.startService(service1);*/
        Log.i("App", "called receiver method");
        try {
            Utils.generateNotification(context);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
