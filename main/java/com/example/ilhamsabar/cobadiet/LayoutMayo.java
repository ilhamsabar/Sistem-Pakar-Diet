package com.example.ilhamsabar.cobadiet;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by ilham sabar on 11/15/2015.
 */
public class LayoutMayo extends Fragment {
    public static final int NOTIFICATION_ID = 1284885;
    TimePicker myTimePicker;
    Button buttonstartSetDialog;
    TextView textAlarmPrompt;
    TimePickerDialog timePickerDialog;



    final static int RQS_1=1;
    public static final int MID = 1284885;

    public LayoutMayo(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mayo,container,false);
        DBHelper db = new DBHelper(getActivity().getApplicationContext());
        buttonstartSetDialog = (Button) rootView.findViewById(R.id.followingplanMayo);
    buttonstartSetDialog.setOnClickListener(new View.OnClickListener() {
//
            @Override
            public void onClick(View v) {
////                Calendar calendar = Calendar.getInstance();
////                timePickerDialog = new TimePickerDialog(getActivity(),
////                        onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
////                        calendar.get(Calendar.MINUTE), true);
////                timePickerDialog.setTitle("Set Alarm Time");
////                timePickerDialog.show();
////
////                Integer jam = calendar.get(Calendar.HOUR_OF_DAY);
////                Integer menit = calendar.get(Calendar.MINUTE);
////
////                if (jam==16&&menit==20){
////
////                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity().getApplicationContext());
////                    builder.setSmallIcon(R.drawable.icon);
////                    builder.setSubText("Tap to view documentation about notifications.");
////
////                    Intent intent = new Intent(getActivity(), MainActivity.class);
////                    PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
////                    builder.setContentIntent(pendingIntent);
////
////                    builder.setSmallIcon(R.drawable.icon);
////                    builder.setWhen(5);
////                    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
////
////                    String[] events = new String[6];
////
////                    events[0] = new String("Menu Makan Hari Ini");
////                    events[1] = new String("Ayam bakar");
////                    events[2] = new String("ikan goreng");
////
////                    // Sets a title for the Inbox style big view
////                    inboxStyle.setBigContentTitle("My Diet");
////
////                    // Moves events into the big view
////                    for (int i=0; i < events.length; i++) {
////                        inboxStyle.addLine(events[i]);
////                    }
////
////                    builder.setStyle(inboxStyle);
////
////                    NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
////                    // Will display the notification in the notification bar
////                    notificationManager.notify(NOTIFICATION_ID, builder.build());
//                //}
//                setAlarm();
                Toast.makeText(getActivity(), "Berhasil di klik", Toast.LENGTH_LONG).show();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity().getApplicationContext());
                builder.setSmallIcon(R.drawable.icon);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
                builder.setContentIntent(pendingIntent);

                builder.setSmallIcon(R.drawable.icon);
                builder.setContentTitle("Diet Sehat");
                builder.setContentText("dadeaeadsa");
                builder.setAutoCancel(true);
                builder.setWhen(5);
                NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
                // Will display the notification in the notification bar
                notificationManager.notify(NOTIFICATION_ID, builder.build());

                Long alerTime = new GregorianCalendar().getTimeInMillis()+5*100;
                Intent alertIntent = new Intent(getActivity(), AlaramReceiver.class);
                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, alerTime, PendingIntent.getBroadcast(getActivity(), 1, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT));
            }
        });

        try {
            db.CreateDataBase();
        }catch (IOException ioe){
            throw new Error("Tidak dapat membuat database");
        }

        TextView h1isi = (TextView) rootView.findViewById(R.id.mayoH1);
        TextView h2tisi = (TextView) rootView.findViewById(R.id.mayoH2);
        TextView h3isi = (TextView) rootView.findViewById(R.id.mayoH3);
        TextView h4tisi = (TextView) rootView.findViewById(R.id.mayoH4);
        TextView h5isi = (TextView) rootView.findViewById(R.id.mayoH5);
        TextView h6tisi = (TextView) rootView.findViewById(R.id.mayoH6);
        TextView h7isi = (TextView) rootView.findViewById(R.id.mayoH7);
        TextView h8tisi = (TextView) rootView.findViewById(R.id.mayoH8);
        TextView h9isi = (TextView) rootView.findViewById(R.id.mayoH9);
        TextView h10tisi = (TextView) rootView.findViewById(R.id.mayoH10);
        TextView h11isi = (TextView) rootView.findViewById(R.id.mayoH11);
        TextView h12tisi = (TextView) rootView.findViewById(R.id.mayoH12);
        TextView h13isi = (TextView) rootView.findViewById(R.id.mayoH13);



        //String buffer = "";
        String h1 ="";String h2 ="";String h3 ="";String h4 ="";String h5 ="";String h6 ="";String h7 ="";String h8 ="";String h9 ="";String h10 ="";
        String h11 =""; String h12 =""; String h13 ="";


        if (db.open()){
            List<Peraturan> peraturans = db.getPeraturans();

// //               String ID = peraturans.get(x).id;
                    String h1PAGI = peraturans.get(0).pagi;
                    String h1SIANG = peraturans.get(0).siang;
                    String h1MALAM = peraturans.get(0).malam;
                    h1 = h1  + "Menu Makan Pagi " + h1PAGI + "\n";
                    h1 = h1  + "Menu Makan Siang " + h1SIANG + "\n";
                    h1 = h1  + "Menu Makan Malam " + h1MALAM + "\n";
                    String h2PAGI = peraturans.get(1).pagi;
                    String h2SIANG = peraturans.get(1).siang;
                    String h2MALAM = peraturans.get(1).malam;
                    h2 = h2  + "Menu Makan Pagi " + h2PAGI + "\n";
                    h2 = h2  + "Menu Makan Siang " + h2SIANG + "\n";
                    h2 = h2  + "Menu Makan Malam " + h2MALAM + "\n";
                    String h3PAGI = peraturans.get(2).pagi;
                    String h3SIANG = peraturans.get(2).siang;
                    String h3MALAM = peraturans.get(2).malam;
                    h3 = h3  + "Menu Makan Pagi " + h3PAGI + "\n";
                    h3 = h3  + "Menu Makan Siang " + h3SIANG + "\n";
                    h3 = h3  + "Menu Makan Malam " + h3MALAM + "\n";
            String h4PAGI = peraturans.get(3).pagi;
            String h4SIANG = peraturans.get(3).siang;
            String h4MALAM = peraturans.get(3).malam;
            h4 = h4  + "Menu Makan Pagi " + h4PAGI + "\n";
            h4 = h4  + "Menu Makan Siang " + h4SIANG + "\n";
            h4 = h4  + "Menu Makan Malam " + h4MALAM + "\n";
            String h5PAGI = peraturans.get(4).pagi;
            String h5SIANG = peraturans.get(4).siang;
            String h5MALAM = peraturans.get(4).malam;
            h5 = h5  + "Menu Makan Pagi " + h5PAGI + "\n";
            h5 = h5  + "Menu Makan Siang " + h5SIANG + "\n";
            h5 = h5  + "Menu Makan Malam " + h5MALAM + "\n";
            String h6PAGI = peraturans.get(5).pagi;
            String h6SIANG = peraturans.get(5).siang;
            String h6MALAM = peraturans.get(5).malam;
            h6 = h6  + "Menu Makan Pagi " + h6PAGI + "\n";
            h6 = h6  + "Menu Makan Siang " + h6SIANG + "\n";
            h6 = h6  + "Menu Makan Malam " + h6MALAM + "\n";
            String h7PAGI = peraturans.get(6).pagi;
            String h7SIANG = peraturans.get(6).siang;
            String h7MALAM = peraturans.get(6).malam;
            h7 = h7  + "Menu Makan Pagi " + h7PAGI + "\n";
            h7 = h7  + "Menu Makan Siang " + h7SIANG + "\n";
            h7 = h7  + "Menu Makan Malam " + h7MALAM + "\n";
            String h8PAGI = peraturans.get(7).pagi;
            String h8SIANG = peraturans.get(7).siang;
            String h8MALAM = peraturans.get(7).malam;
            h8 = h8  + "Menu Makan Pagi " + h8PAGI + "\n";
            h8 = h8  + "Menu Makan Siang " + h8SIANG + "\n";
            h8 = h8  + "Menu Makan Malam " + h8MALAM + "\n";
            String h9PAGI = peraturans.get(8).pagi;
            String h9SIANG = peraturans.get(8).siang;
            String h9MALAM = peraturans.get(8).malam;
            h9 = h9  + "Menu Makan Pagi " + h9PAGI + "\n";
            h9 = h9  + "Menu Makan Siang " + h9SIANG + "\n";
            h9 = h9  + "Menu Makan Malam " + h9MALAM + "\n";
            String h10PAGI = peraturans.get(9).pagi;
            String h10SIANG = peraturans.get(9).siang;
            String h10MALAM = peraturans.get(9).malam;
            h10 = h10  + "Menu Makan Pagi " + h10PAGI + "\n";
            h10 = h10  + "Menu Makan Siang " + h10SIANG + "\n";
            h10 = h10  + "Menu Makan Malam " + h10MALAM + "\n";
            String h11PAGI = peraturans.get(10).pagi;
            String h11SIANG = peraturans.get(10).siang;
            String h11MALAM = peraturans.get(10).malam;
            h11 = h11  + "Menu Makan Pagi " + h11PAGI + "\n";
            h11 = h11  + "Menu Makan Siang " + h11SIANG + "\n";
            h11 = h11  + "Menu Makan Malam " + h11MALAM + "\n";
            String h12PAGI = peraturans.get(11).pagi;
            String h12SIANG = peraturans.get(11).siang;
            String h12MALAM = peraturans.get(11).malam;
            h12 = h12  + "Menu Makan Pagi " + h12PAGI + "\n";
            h12 = h12  + "Menu Makan Siang " + h12SIANG + "\n";
            h12 = h12  + "Menu Makan Malam " + h12MALAM + "\n";
            String h13PAGI = peraturans.get(12).pagi;
            String h13SIANG = peraturans.get(12).siang;
            String h13MALAM = peraturans.get(12).malam;
            h13 = h13  + "Menu Makan Pagi " + h13PAGI + "\n";
            h13 = h13  + "Menu Makan Siang " + h13SIANG + "\n";
            h13 = h13  + "Menu Makan Malam " + h13MALAM + "\n";

        }
        else {
            Toast.makeText(getActivity(), "Eror membuka database", Toast.LENGTH_SHORT).show();
        }
        h1isi.setText(h1);h2tisi.setText(h2);h3isi.setText(h3);h4tisi.setText(h4);h5isi.setText(h5);h6tisi.setText(h6);h7isi.setText(h7);h8tisi.setText(h8);
        h9isi.setText(h9);h10tisi.setText(h10);h11isi.setText(h11);h12tisi.setText(h12);h13isi.setText(h13);




        return rootView;
    }

    public void openTimePickerDialog(boolean is24r) {
        Calendar calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(getActivity(),
                onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), true);
        timePickerDialog.setTitle("Set Alarm Time");
        timePickerDialog.show();

        Integer jam = calendar.get(Calendar.HOUR_OF_DAY);
        Integer menit = calendar.get(Calendar.MINUTE);


    }

    public void setAlarm(View view){
        Long alerTime = new GregorianCalendar().getTimeInMillis()+5*1000;
        Intent alertIntent = new Intent(getActivity(), AlaramReceiver.class);
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alerTime, PendingIntent.getBroadcast(getActivity(), 1, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();
            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);

            if (calSet.compareTo(calNow) <= 0) {
                // Today Set time passed, count to tomorrow
                calSet.add(Calendar.DATE, 1);
                Log.i("hasil", " =<0");
            } else if (calSet.compareTo(calNow) > 0) {
                Log.i("hasil", " > 0");
            } else {
                Log.i("hasil", " else ");
            }

            //setAlarm(calSet);
        }
    };


//    private void setAlarm(Calendar targetCal) {
//
////        textAlarmPrompt.setText("***\n" + "Alarm set on " + targetCal.getTime()
////                + "\n***");
//        Toast.makeText(getActivity(), "set alaram pada " + targetCal.getTime(), Toast.LENGTH_LONG).show();
//
//        Intent intent = new Intent(getActivity().getBaseContext(), AlaramReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(
//                getActivity().getBaseContext(), RQS_1, intent, 0);
//        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
//                pendingIntent);
//
//    }





}
