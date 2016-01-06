package com.example.ilhamsabar.cobadiet;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by ilham sabar on 11/20/2015.
 */
public class LayoutAtkins extends Fragment {
    DBHelperAtkins dbHelper;
    PeraturanAtkins peraturanAtkins;
    protected Cursor cursor;
    TextView Hari1, Hari2, Hari3, Hari4,Hari5,Hari6,Hari7;
    String pagi1, siang1, malam1, pagi2, siang2, malam2, pagi3, siang3, malam3, pagi4, siang4, malam4, pagi5, siang5, malam5, pagi6, siang6, malam6, pagi7, siang7, malam7;
    Button proses;
    FloatingActionButton fabset;
    // This is a handle so that we can call methods on our service
    private ScheduleClient scheduleClient;
    // This is the date picker used to select the date for our notification
    private DatePicker picker;

    public LayoutAtkins(){

    }

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_atkins, container, false);
        Hari1 = (TextView) rootView.findViewById(R.id.hari1);
        Hari2 = (TextView) rootView.findViewById(R.id.hari2);
        Hari3 = (TextView) rootView.findViewById(R.id.hari3);
        Hari4 = (TextView) rootView.findViewById(R.id.hari4);
        Hari5 = (TextView) rootView.findViewById(R.id.hari5);
        Hari6 = (TextView) rootView.findViewById(R.id.hari6);
        Hari7 = (TextView) rootView.findViewById(R.id.hari7);
        fabset = (FloatingActionButton) rootView.findViewById(R.id.fabatkins);
        fabset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calNow = Calendar.getInstance();
                Calendar calender = (Calendar) calNow.clone();
                Calendar calender1 = (Calendar) calNow.clone();
                Calendar calender2 = (Calendar) calNow.clone();
                calender.set(Calendar.HOUR_OF_DAY, 13);
                calender.set(Calendar.MINUTE, 15);
                calender.set(Calendar.SECOND, 0);

                calender1.set(Calendar.HOUR_OF_DAY, 10);
                calender1.set(Calendar.MINUTE, 59);
                calender1.set(Calendar.SECOND, 0);

                calender2.set(Calendar.HOUR_OF_DAY, 10);
                calender2.set(Calendar.MINUTE, 55);
                calender2.set(Calendar.SECOND, 0);

//                if (calender.compareTo(calNow) <= 0) {
//                    // Today Set time passed, count to tomorrow
//                    calender.add(Calendar.DATE, 1);
//                    Log.i("hasil", " =<0");
//                }
//
//                if (calender1.compareTo(calNow) <= 0) {
//                    // Today Set time passed, count to tomorrow
//                    calender1.add(Calendar.DATE, 1);
//                    Log.i("hasil", " =<0");
//                }
//                if (calender2.compareTo(calNow) <= 0) {
//                    // Today Set time passed, count to tomorrow
//                    calender2.add(Calendar.DATE, 1);
//                    Log.i("hasil", " =<0");
//                }
                // Ask our service to set an alarm for that date, this activity talks to the client that talks to the service
                scheduleClient.setAlarmForNotification(calender);
                //scheduleClient.setAlarmForNotification1(calender1);
                //scheduleClient.setAlarmForNotification(calender2);
                // Notify the user what they just did
                Toast.makeText(getActivity(), "Notification berhasil di set", Toast.LENGTH_SHORT).show();
            }
        });

        scheduleClient = new ScheduleClient(getActivity());
        scheduleClient.doBindService();

        proses = (Button) rootView.findViewById(R.id.setdate);
        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calNow = Calendar.getInstance();
                Calendar calender = (Calendar) calNow.clone();
//                calender.set(year, month, day);
                calender.set(Calendar.HOUR_OF_DAY, 7);
                calender.set(Calendar.MINUTE, 41);
                calender.set(Calendar.SECOND, 0);
                if (calender.compareTo(calNow) <= 0) {
                    // Today Set time passed, count to tomorrow
                    calender.add(Calendar.DATE, 1);
                    Log.i("hasil", " =<0");
                }
                // Ask our service to set an alarm for that date, this activity talks to the client that talks to the service
                //null bede data yang saya kirim ke schedule client ?
                scheduleClient.setAlarmForNotification(calender);
                // Notify the user what they just did
                Toast.makeText(getActivity(), "Notification sudah di atur", Toast.LENGTH_SHORT).show();
            }
        });


        dbHelper = new DBHelperAtkins(this.getActivity());
        dbHelper.openDataBase();
        peraturanAtkins = new PeraturanAtkins();
        peraturanAtkins = dbHelper.Get_peraturanAtkin();
        pagi1 = peraturanAtkins.getSarapan();
        siang1 = peraturanAtkins.getMakansiang();
        malam1 = peraturanAtkins.getMakanmalam();
        Hari1.setText("Sarapan : "+pagi1+"\n Makan Siang : "+siang1+"\n Makan Malam : "+malam1);

        peraturanAtkins = dbHelper.Get_peraturanAtkin2();
        pagi2 = peraturanAtkins.getSarapan();
        siang2 = peraturanAtkins.getMakansiang();
        malam2 = peraturanAtkins.getMakanmalam();
        Hari2.setText("Sarapan : "+pagi2+"\n Makan Siang : "+siang2+"\n Makan Malam : "+malam2);

        peraturanAtkins = dbHelper.Get_peraturanAtkin3();
        pagi3 = peraturanAtkins.getSarapan();
        siang3 = peraturanAtkins.getMakansiang();
        malam3 = peraturanAtkins.getMakanmalam();
        Hari3.setText("Sarapan : "+pagi3+"\n Makan Siang : "+siang3+"\n Makan Malam : "+malam3);

        peraturanAtkins = dbHelper.Get_peraturanAtkin4();
        pagi4 = peraturanAtkins.getSarapan();
        siang4 = peraturanAtkins.getMakansiang();
        malam4 = peraturanAtkins.getMakanmalam();
        Hari4.setText("Sarapan : "+pagi4+"\n Makan Siang : "+siang4+"\n Makan Malam : "+malam4);

        peraturanAtkins = dbHelper.Get_peraturanAtkin5();
        pagi5 = peraturanAtkins.getSarapan();
        siang5 = peraturanAtkins.getMakansiang();
        malam5 = peraturanAtkins.getMakanmalam();
        Hari5.setText("Sarapan : "+pagi5+"\n Makan Siang : "+siang5+"\n Makan Malam : "+malam5);

        peraturanAtkins = dbHelper.Get_peraturanAtkin6();
        pagi6 = peraturanAtkins.getSarapan();
        siang6 = peraturanAtkins.getMakansiang();
        malam6 = peraturanAtkins.getMakanmalam();
        Hari6.setText("Sarapan : "+pagi6+"\n Makan Siang : "+siang6+"\n Makan Malam : "+malam6);

        peraturanAtkins = dbHelper.Get_peraturanAtkin7();
        pagi7 = peraturanAtkins.getSarapan();
        siang7 = peraturanAtkins.getMakansiang();
        malam7 = peraturanAtkins.getMakanmalam();
        Hari7.setText("Sarapan : "+pagi7+"\n Makan Siang : "+siang7+"\n Makan Malam : "+malam7);


        return rootView;
    }

    @Override
    public void onStop() {
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClient != null)
            scheduleClient.doUnbindService();
        super.onStop();
    }

//    public void hari1(){
//        dbHelper.openDataBase();
//        dbHelper.
//    }
}
