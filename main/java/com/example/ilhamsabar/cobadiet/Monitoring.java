package com.example.ilhamsabar.cobadiet;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by ilham sabar on 2/18/2016.
 */
public class Monitoring extends Fragment {

    private ScheduleClient scheduleClient;
    final static int RQS_1 = 1;
    FloatingActionButton Ingat;
    TextView BB, BBideal,status, BBawal,
            Msarapan1, Msarapan2, Msarapan3, Msarapan4, Msarapan5, Msarapanku,
            Msiang1, Msiang2, Msiang3, Msiang4, Msiang5, Msiangku,
            Mmalam1, Mmalam2, Mmalam3, Mmalam4, Mmalam5, Mmalamku,
            Molahraga1, Molahraga2, Molahraga3, Molahraga4, Molahraga5, Molahragaku,
            Tsarapan, Tsiang, Tmalam;
    Button Upbbh1, Upbbh2, Upbbh3, Upbbh4, Upbbh5, Upbbku, Progress, BTsiang, BTmalam, BTsarapan;
    CardView Mhari1,Mhari2,Mhari3,Mhari4,Mhari5, Mhariku, Sehat, Timerdiet ;
    CheckBox Chp1, Chp2,Chp3, Chp4, Chp5, Chpku,
            Chs1, Chs2, Chs3, Chs4, Chs5, Chsku,
            Chm1, Chm2, Chm3, Chm4, Chm5, Chmku,
            Chol1, Chol2, Chol3, Chol4, Chol5, Cholku;

    MaterialDialog mTambah, mProgress;

    private int pHour;
    private int pMinute;
    /** This integer will uniquely define the dialog to be used for displaying time picker.*/
    static final int TIME_DIALOG_ID = 0;

    //final SharedPreferences sp = getActivity().getSharedPreferences("datadiet", Context.MODE_PRIVATE);

    public Monitoring(){

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        final View rootView = inflater.inflate(R.layout.monitoring, container, false);
        BB = (TextView) rootView.findViewById(R.id.Mbb);
        BBideal = (TextView) rootView.findViewById(R.id.BBideal);
        status = (TextView) rootView.findViewById(R.id.Status);
        BBawal = (TextView) rootView.findViewById(R.id.BBawal);

        final View tambah =  LayoutInflater.from(getActivity()).inflate(R.layout.tambahdiet, container, false);
        final View progressdiet =  LayoutInflater.from(getActivity()).inflate(R.layout.progressdiet, container, false);

        Ingat = (FloatingActionButton) rootView.findViewById(R.id.freminder);

        Upbbh1 = (Button) rootView.findViewById(R.id.Upbbh1);
        Upbbh2 = (Button) rootView.findViewById(R.id.Upbbh2);
        Upbbh3 = (Button) rootView.findViewById(R.id.Upbbh3);
        Upbbh4 = (Button) rootView.findViewById(R.id.Upbbh4);
        Upbbh5 = (Button) rootView.findViewById(R.id.Upbbh5);
        Upbbku = (Button) rootView.findViewById(R.id.Upbbku);
        Progress = (Button) rootView.findViewById(R.id.progressDiet);
        BTsarapan = (Button) rootView.findViewById(R.id.bsarapantime);
        BTsiang = (Button) rootView.findViewById(R.id.bsiangtime);
        BTmalam = (Button) rootView.findViewById(R.id.bmalamtime);




        Tsarapan = (TextView) rootView.findViewById(R.id.sarapantime);
        Tsiang = (TextView) rootView.findViewById(R.id.siangtime);
        Tmalam = (TextView) rootView.findViewById(R.id.malamtime);

        Chpku = (CheckBox) rootView.findViewById(R.id.chpagiku);
        Chp1 = (CheckBox) rootView.findViewById(R.id.chpagi1);
        Chp2 = (CheckBox) rootView.findViewById(R.id.chpagi2);
        Chp3 = (CheckBox) rootView.findViewById(R.id.chpagi3);
        Chp4 = (CheckBox) rootView.findViewById(R.id.chpagi4);
        Chp5 = (CheckBox) rootView.findViewById(R.id.chpagi5);

        Chsku = (CheckBox) rootView.findViewById(R.id.chsiangku);
        Chs1 = (CheckBox) rootView.findViewById(R.id.chsiang1);
        Chs2 = (CheckBox) rootView.findViewById(R.id.chsiang2);
        Chs3 = (CheckBox) rootView.findViewById(R.id.chsiang3);
        Chs4 = (CheckBox) rootView.findViewById(R.id.chsiang4);
        Chs5 = (CheckBox) rootView.findViewById(R.id.chsiang5);

        Chmku = (CheckBox) rootView.findViewById(R.id.chmlamku);
        Chm1 = (CheckBox) rootView.findViewById(R.id.chmla11);
        Chm2 = (CheckBox) rootView.findViewById(R.id.chmla12);
        Chm3 = (CheckBox) rootView.findViewById(R.id.chmlam3);
        Chm4 = (CheckBox) rootView.findViewById(R.id.chmlam4);
        Chm5 = (CheckBox) rootView.findViewById(R.id.chmlam5);

        Cholku = (CheckBox) rootView.findViewById(R.id.cholku);
        Chol1 = (CheckBox) rootView.findViewById(R.id.chol1);
        Chol2 = (CheckBox) rootView.findViewById(R.id.chol2);
        Chol3 = (CheckBox) rootView.findViewById(R.id.chol3);
        Chol4 = (CheckBox) rootView.findViewById(R.id.chol4);
        Chol5 = (CheckBox) rootView.findViewById(R.id.chol5);

        Msarapanku = (TextView) rootView.findViewById(R.id.msarapanku);
        Msarapan1 = (TextView) rootView.findViewById(R.id.msarapan1);
        Msarapan2 = (TextView) rootView.findViewById(R.id.msarapan2);
        Msarapan3 = (TextView) rootView.findViewById(R.id.msarapan3);
        Msarapan4 = (TextView) rootView.findViewById(R.id.msarapan4);
        Msarapan5 = (TextView) rootView.findViewById(R.id.msarapan5);

        Msiangku = (TextView) rootView.findViewById(R.id.msiangku);
        Msiang1 = (TextView) rootView.findViewById(R.id.msiang1);
        Msiang2 = (TextView) rootView.findViewById(R.id.msiang2);
        Msiang3 = (TextView) rootView.findViewById(R.id.msiang3);
        Msiang4 = (TextView) rootView.findViewById(R.id.msiang4);
        Msiang5 = (TextView) rootView.findViewById(R.id.msiang5);

        Mmalamku = (TextView) rootView.findViewById(R.id.mmalamku);
        Mmalam1 = (TextView) rootView.findViewById(R.id.mmalam1);
        Mmalam2 = (TextView) rootView.findViewById(R.id.mmalam2);
        Mmalam3 = (TextView) rootView.findViewById(R.id.mmalam3);
        Mmalam4 = (TextView) rootView.findViewById(R.id.mmalam4);
        Mmalam5 = (TextView) rootView.findViewById(R.id.mmalam5);

        Molahragaku = (TextView) rootView.findViewById(R.id.molahragaku);
        Molahraga1 = (TextView) rootView.findViewById(R.id.molahraga1);
        Molahraga2 = (TextView) rootView.findViewById(R.id.molahraga2);
        Molahraga3 = (TextView) rootView.findViewById(R.id.molahraga3);
        Molahraga4 = (TextView) rootView.findViewById(R.id.molahraga4);
        Molahraga5 = (TextView) rootView.findViewById(R.id.molahraga5);

        Mhari1 = (CardView) rootView.findViewById(R.id.Mhari1);
        Mhari2 = (CardView) rootView.findViewById(R.id.Mhari2);
        Mhari3 = (CardView) rootView.findViewById(R.id.Mhari3);
        Mhari4 = (CardView) rootView.findViewById(R.id.Mhari4);
        Mhari5 = (CardView) rootView.findViewById(R.id.Mhari5);
        Sehat = (CardView) rootView.findViewById(R.id.sehat);
        Mhariku = (CardView) rootView.findViewById(R.id.Mhariku);
        Timerdiet = (CardView) rootView.findViewById(R.id.timerdiet);

        Mhariku.setVisibility(View.GONE);
        Mhari1.setVisibility(View.GONE);
        Mhari2.setVisibility(View.GONE);
        Mhari3.setVisibility(View.GONE);
        Mhari4.setVisibility(View.GONE);
        Mhari5.setVisibility(View.GONE);
        Sehat.setVisibility(View.GONE);
        final SharedPreferences sp = getActivity().getSharedPreferences("datadiet", Context.MODE_PRIVATE);
        Integer Status1, Status2;
        Status1 = sp.getInt("StatusSp", 0);






            final DecimalFormat df = new DecimalFormat();
            df.setGroupingUsed(true);
            df.setMaximumIntegerDigits(8);
            df.setMaximumFractionDigits(2);

            final SharedPreferences.Editor ed = sp.edit();

            final Calendar calNow = Calendar.getInstance();
            final Calendar calender = (Calendar) calNow.clone();

        Ingat.setVisibility(View.GONE);


        //((ViewGroup) tambah.getParent()).removeView(tambah);
            scheduleClient = new ScheduleClient(getActivity());
            scheduleClient.doBindService();

            Integer BBawal1 = sp.getInt("BBku", 0);
            final String BBkuu = sp.getString("BBawal","");
            BBawal.setText(String.valueOf(BBawal1));
            BB.setText(sp.getString("BBawal", ""));
            Integer Usia = sp.getInt("Umur", 0);
            String BBjml = sp.getString("Beratbadan", "");
            final String BBMI = sp.getString("BMI", "");
            String Olahraga = sp.getString("Olahraga", "");
            String Sarapanku = sp.getString("Sarapanku","");

            if (Sarapanku.trim().length() == 0){
                Mhariku.setVisibility(View.GONE);
            }
            else {
                Mhariku.setVisibility(View.VISIBLE);
            }

            if (BBawal1 == 0){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setMessage("Anda Belum Melakukan Diagnosa. Apakah Anda Ingin Melakukan Diagnosa Sekarang ?");

                alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getActivity(),"You clicked yes button",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                });

                alertDialogBuilder.setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        else {

                Ingat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTambah = new MaterialDialog(getActivity()).setView(tambah);
                        mTambah.show();

                        final EditText Sarapan = (EditText) tambah.findViewById(R.id.Sarapanku);
                        final EditText Siang = (EditText) tambah.findViewById(R.id.Siangkuku);
                        final EditText Malam = (EditText) tambah.findViewById(R.id.Malamku);
                        final EditText Olahraga3 = (EditText) tambah.findViewById(R.id.Olahragaku);
                        final EditText Prediksi = (EditText) tambah.findViewById(R.id.Prediksi);
                        final RadioButton BBtambah = (RadioButton) tambah.findViewById(R.id.BBtambah);
                        final RadioButton BBkurang = (RadioButton) tambah.findViewById(R.id.BBkurang);


                        Button btambah = (Button) tambah.findViewById(R.id.simpankuu);
                        btambah.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (Sarapan.getText().toString().trim().length() == 0){
                                    Toast.makeText(getActivity(), "Sarapan blum di isi", Toast.LENGTH_LONG).show();
                                }
                                else if (Prediksi.getText().toString().trim().length() == 0){
                                    Toast.makeText(getActivity(), "Prediksi masih kosong", Toast.LENGTH_LONG).show();
                                }
                                else if (Olahraga3.getText().toString().trim().length() == 0){
                                    Toast.makeText(getActivity(), "Olahraga masih kosong", Toast.LENGTH_LONG).show();
                                }
                                else if (Malam.getText().toString().trim().length() == 0){
                                    Toast.makeText(getActivity(), "makan malam masih kosong", Toast.LENGTH_LONG).show();
                                }
                                else if  (Siang.getText().toString().trim().length() == 0){
                                    Toast.makeText(getActivity(), "Siang masih kosong", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    ed.putString("Sarapanku", Sarapan.getText().toString());
                                    ed.putString("Siangku", Siang.getText().toString());
                                    ed.putString("Malamku", Malam.getText().toString());
                                    ed.putString("Olahragaku", Olahraga3.getText().toString());
                                    if (BBtambah.isChecked()){
                                        ed.putInt("Status", 1);
                                        ed.putString("Prediksi", Prediksi.getText().toString());
                                    }
                                    if (BBkurang.isChecked()){
                                        ed.putInt("Status", 3);
                                        ed.putString("Prediksi", Prediksi.getText().toString());
                                    }
                                    ed.commit();
                                    mTambah.dismiss();
                                    ((ViewGroup) tambah.getParent()).removeView(tambah);
                                    getActivity().getSupportFragmentManager().beginTransaction().
                                            replace(R.id.container_body, new MainTab())
                                            .commit();
                                    Toast.makeText(getActivity(),"Berhasil Di Simpan",Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                        Button bbatal = (Button) tambah.findViewById(R.id.batal);
                        bbatal.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Sarapan.setText("");
                                Siang.setText("");
                                Malam.setText("");
                                Olahraga3.setText("");
                                Prediksi.setText("");
                                mTambah.dismiss();
                                ((ViewGroup) tambah.getParent()).removeView(tambah);
                            }
                        });
                    }
                });
                final Integer Statusawal = sp.getInt("Statusawal", 0);
                final Integer Status = sp.getInt("Status", 0);
                Progress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mProgress = new MaterialDialog(getActivity()).setView(progressdiet);
                        mProgress.show();
                        final EditText BBprogress = (EditText) progressdiet.findViewById(R.id.BBprogress);
                        final Button Bcek = (Button) progressdiet.findViewById(R.id.progresscek);
                        final Button Bbatal = (Button) progressdiet.findViewById(R.id.progressbatal);
                        Bcek.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (BBprogress.getText().toString().trim().length() == 0) {
                                    Toast.makeText(getActivity(), "data masih kosong", Toast.LENGTH_LONG).show();
                                } else {
                                    Double BBcek = Double.parseDouble(BBprogress.getText().toString());
                                    String BBawal = sp.getString("BBawal", "");
                                    Double BBawal1 = Double.parseDouble(BBawal);
                                    final Double BMI = Double.parseDouble(BBMI);
                                    if (BBcek == BMI) {
                                        ed.putInt("Status", 2);
                                        ed.commit();
                                    } else if (BBcek != BMI) {
                                        ed.putString("BBawal", String.valueOf(BBcek));
                                        ed.putInt("Status", Statusawal);
                                        ed.commit();
                                        getActivity().getSupportFragmentManager().beginTransaction().
                                                replace(R.id.container_body, new MainTab())
                                                .commit();
                                    }
                                    mProgress.dismiss();
                                    ((ViewGroup) progressdiet.getParent()).removeView(progressdiet);
                                }
                            }
                        });
                        Bbatal.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                BBprogress.setText("");
                                mProgress.dismiss();
                                ((ViewGroup) progressdiet.getParent()).removeView(progressdiet);
                            }
                        });
                    }
                });

                Molahraga1.setText(Olahraga);
                Molahraga2.setText(Olahraga);
                Molahraga3.setText(Olahraga);
                Molahraga4.setText(Olahraga);
                Molahraga5.setText(Olahraga);
                Molahragaku.setText(sp.getString("Olahragaku",""));

                Msarapanku.setText(sp.getString("Sarapanku",""));
                Msarapan1.setText(sp.getString("MenuSarapan1", ""));
                Msarapan2.setText(sp.getString("MenuSarapan2", ""));
                Msarapan3.setText(sp.getString("MenuSarapan3", ""));
                Msarapan4.setText(sp.getString("MenuSarapan4", ""));
                Msarapan5.setText(sp.getString("MenuSarapan5", ""));

                Msiangku.setText(sp.getString("Siangku", ""));
                Msiang1.setText(sp.getString("MenuSiang1", ""));
                Msiang2.setText(sp.getString("MenuSiang2", ""));
                Msiang3.setText(sp.getString("MenuSiang3", ""));
                Msiang4.setText(sp.getString("MenuSiang4", ""));
                Msiang5.setText(sp.getString("MenuSiang5", ""));

                Mmalamku.setText(sp.getString("Malamku", ""));
                Mmalam1.setText(sp.getString("MenuMalam1", ""));
                Mmalam2.setText(sp.getString("MenuMalam2", ""));
                Mmalam3.setText(sp.getString("MenuMalam3", ""));
                Mmalam4.setText(sp.getString("MenuMalam4", ""));
                Mmalam5.setText(sp.getString("MenuMalam5", ""));

                BTsarapan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                ed.putInt("TJsarapan", selectedHour);
                                ed.putInt("TMsarapan", selectedMinute);
                                ed.commit();
                                Tsarapan.setText(selectedHour + ":" + selectedMinute);
                                getActivity().getSupportFragmentManager().beginTransaction().
                                        replace(R.id.container_body, new MainTab())
                                        .commit();
                            }
                        }, hour, minute, true);//Yes 24 hour time
                        mTimePicker.setTitle("Atur Waktu Sarapan");
                        mTimePicker.show();
                    }
                });

                BTsiang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                ed.putInt("TJsiang", selectedHour);
                                ed.putInt("TMsiang", selectedMinute);
                                ed.commit();
                                Tsiang.setText(selectedHour + ":" + selectedMinute);
                                getActivity().getSupportFragmentManager().beginTransaction().
                                        replace(R.id.container_body, new MainTab())
                                        .commit();
                            }
                        }, hour, minute, true);//Yes 24 hour time
                        mTimePicker.setTitle("Atur Waktu Makan Siang");
                        mTimePicker.show();
                    }
                });

                BTmalam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                ed.putInt("TJmalam", selectedHour);
                                ed.putInt("TMmalam", selectedMinute);
                                ed.commit();
                                getActivity().getSupportFragmentManager().beginTransaction().
                                        replace(R.id.container_body, new MainTab())
                                        .commit();

                            }
                        }, hour, minute, true);//Yes 24 hour time
                        mTimePicker.setTitle("Atur Waktu Makan Malam");
                        mTimePicker.show();
                    }
                });

                Integer Progressdiet = sp.getInt("ProgresDiet", 2);

                if (BBMI.trim().length()==0){
                    Toast.makeText(getActivity(),"BBMI masih kosong",Toast.LENGTH_LONG).show();
                }
                else {
                    final Double BMI = Double.parseDouble(BBMI);
                    if ( Status == 1){
                        status.setText("Kurus");
                        BBideal.setText(df.format(BMI) + " KG");
                        Sehat.setVisibility(View.GONE);
                        Ingat.setVisibility(View.VISIBLE);
                        if (Usia<8){
                            Mhari1.setVisibility(View.GONE);
                            Mhari2.setVisibility(View.GONE);
                            Mhari3.setVisibility(View.GONE);
                            Mhari4.setVisibility(View.GONE);
                            Mhari5.setVisibility(View.GONE);
                            Sehat.setVisibility(View.GONE);
                            Mhariku.setVisibility(View.GONE);
                            BB.setText("Umur Tidak Disarankan");
                            BBideal.setText("Umur Tidak Disarankan");
                        }
                        else if (BMI > 15){
                            Mhari1.setVisibility(View.VISIBLE);
                            Mhari2.setVisibility(View.VISIBLE);
                            Mhari3.setVisibility(View.VISIBLE);
                            Mhari4.setVisibility(View.VISIBLE);
                            Mhari5.setVisibility(View.VISIBLE);
                        }
                        else if (BMI < 15){
                            Mhari1.setVisibility(View.VISIBLE);
                            Mhari2.setVisibility(View.VISIBLE);
                            Mhari3.setVisibility(View.VISIBLE);
                            Mhari4.setVisibility(View.GONE);
                            Mhari5.setVisibility(View.GONE);
                        }
                        if (Progressdiet == 2){
                            Progress.setVisibility(View.VISIBLE);
                            Timerdiet.setVisibility(View.VISIBLE);
                        }
                        else {
                            Progress.setVisibility(View.GONE);
                        }
                        if (BMI < Double.parseDouble(BBkuu)) {
                            BBideal.setText("Ideal");
                            status.setText("Normal");
                            ed.putInt("Status", 2);
                            ed.commit();
                            Normal(true);
                            Toast.makeText(getActivity(), "Statsus Normal Weight", Toast.LENGTH_LONG).show();
                        }
                    }
                    else if (Status == 2){
                        BBideal.setText(BBMI);
                        status.setText("Normal");
                        Ingat.setVisibility(View.GONE);
                        Mhariku.setVisibility(View.GONE);
                        Mhari1.setVisibility(View.GONE);
                        Mhari2.setVisibility(View.GONE);
                        Mhari3.setVisibility(View.GONE);
                        Mhari4.setVisibility(View.GONE);
                        Mhari5.setVisibility(View.GONE);
                        Sehat.setVisibility(View.VISIBLE);
                        if (Progressdiet == 2){
                            Progress.setVisibility(View.VISIBLE);
                        }
                        else {
                            Progress.setVisibility(View.GONE);
                        }
                    }
                    else if ( Status == 3){
                        status.setText("Obesitas");
                        BBideal.setText(df.format(BMI) + " KG");
                        Sehat.setVisibility(View.GONE);
                        Ingat.setVisibility(View.VISIBLE);
                        if (Usia<8){
                            Mhari1.setVisibility(View.GONE);
                            Mhari2.setVisibility(View.GONE);
                            Mhari3.setVisibility(View.GONE);
                            Mhari4.setVisibility(View.GONE);
                            Mhari5.setVisibility(View.GONE);
                            Sehat.setVisibility(View.GONE);
                            BB.setText("Umur Tidak Disarankan");
                            BBideal.setText("Umur Tidak Disarankan");
                        }
                        else if (BMI > 15){
                            Mhari1.setVisibility(View.VISIBLE);
                            Mhari2.setVisibility(View.VISIBLE);
                            Mhari3.setVisibility(View.VISIBLE);
                            Mhari4.setVisibility(View.VISIBLE);
                            Mhari5.setVisibility(View.VISIBLE);
                        }
                        else if (BMI < 15){
                            Mhari1.setVisibility(View.VISIBLE);
                            Mhari2.setVisibility(View.VISIBLE);
                            Mhari3.setVisibility(View.VISIBLE);
                            Mhari4.setVisibility(View.GONE);
                            Mhari5.setVisibility(View.GONE);
                        }
                        if (Progressdiet == 2){
                            Progress.setVisibility(View.VISIBLE);
                        }
                        else {
                            Progress.setVisibility(View.GONE);
                        }
                        if (BMI > Double.parseDouble(BBkuu)) {
                            BBideal.setText("Ideal");
                            status.setText("Normal");
                            ed.putInt("Status", 2);
                            ed.commit();
                            Normal(true);
                            Toast.makeText(getActivity(), "Statsus Normal Weight", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                //status.setText(Status);
                //final Integer Status = sp.getInt("Status", 0);


                Upbbku.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ed.putInt("Chpku", 2);
                        ed.putInt("Chsku", 2);
                        ed.putInt("Chmku", 2);
                        ed.putInt("Cholku", 2);
                        ed.commit();

                        String bbku = sp.getString("BBawal", "");
                        String bmi = sp.getString("BMI", "");
                        String prediksi = sp.getString("Prediksi", "");
                        Double BB = Double.parseDouble(bbku);
                        Double BMI = Double.parseDouble(bmi);
                        Double Prediksi = Double.parseDouble(prediksi);
                        Double BBSkrng;
                        Double BMISkrng;
                        CardView Mhari1 = (CardView) rootView.findViewById(R.id.Mhari1);
                        TextView BB1 = (TextView) rootView.findViewById(R.id.Mbb);
                        if (Status == 1){
                            status.setText("Kurus");
                            BBSkrng = BB + Prediksi;
                            ed.putString("BBawal", BBSkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
                            if (BMI < Double.parseDouble(BBkuu)) {
                                ed.putInt("Status", 2);
                                ed.commit();
                            }

                        } else if (Status == 3){
                            status.setText("Gemuk");
                            BBSkrng = BB - Prediksi;
                            ed.putString("BBawal", BBSkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
                            if (BMI > Double.parseDouble(BBkuu)) {
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        }

                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });


                Upbbh1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ed.putInt("Chp1", 2);
                        ed.putInt("Chs1", 2);
                        ed.putInt("Chm1", 2);
                        ed.putInt("Chol1", 2);
                        ed.commit();

                        String bbku = sp.getString("BBawal", "");
                        String bmi = sp.getString("BMI", "");
                        Double BB = Double.parseDouble(bbku);
                        Double BMI = Double.parseDouble(bmi);
                        Double BBSkrng;
                        Double BMISkrng;
                        CardView Mhari1 = (CardView) rootView.findViewById(R.id.Mhari1);
                        TextView BB1 = (TextView) rootView.findViewById(R.id.Mbb);
                        if (Status == 1){
                            status.setText("Kurus");
                            BBSkrng = BB + 1;
                            ed.putString("BBawal", BBSkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
                            if (BMI < Double.parseDouble(BBkuu)) {
                                ed.putInt("Status", 2);
                                ed.commit();
                            }

                        } else if (Status == 3){
                            status.setText("Gemuk");
                            BBSkrng = BB - 1;
                            ed.putString("BBawal", BBSkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
                            if (BMI > Double.parseDouble(BBkuu)) {
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        }

                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();

                        Mhari1.setVisibility(View.GONE);
                        //return rootView;
                    }
                });

                Upbbh2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ed.putInt("Chp2", 2);
                        ed.putInt("Chs2", 2);
                        ed.putInt("Chm2", 2);
                        ed.putInt("Chol2", 2);
                        ed.commit();
                        String bbku = sp.getString("BBawal", "");
                        String bmi = sp.getString("BMI", "");
                        Double BB = Double.parseDouble(bbku);
                        Double BMI = Double.parseDouble(bmi);
                        Double BBSkrng;
                        Double BMISkrng;
                        CardView Mhari2 = (CardView) rootView.findViewById(R.id.Mhari2);
                        TextView BB1 = (TextView) rootView.findViewById(R.id.Mbb);
                        if (Status == 1){
                            status.setText("Kurus");
                            BBSkrng = BB + 1;
                            ed.putString("BBawal", BBSkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
                            if (BMI < Double.parseDouble(BBkuu)) {
                                BBideal.setText("Ideal");
                                status.setText("Normal");
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        } else if (Status == 3){
                            status.setText("Gemuk");
                            BBSkrng = BB - 1;
                            ed.putString("BBawal", BBSkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
                            if (BMI > Double.parseDouble(BBkuu)) {
                                BBideal.setText("Ideal");
                                status.setText("Normal");
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                        Mhari2.setVisibility(View.GONE);
                        //return rootView;
                    }
                });

                Upbbh3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ed.putInt("Chp3", 2);
                        ed.putInt("Chs3", 2);
                        ed.putInt("Chm3", 2);
                        ed.putInt("Chol3", 2);
                        ed.commit();
                        String bbku = sp.getString("BBawal", "");
                        String bmi = sp.getString("BMI", "");
                        Double BB = Double.parseDouble(bbku);
                        Double BMI = Double.parseDouble(bmi);
                        Double BBSkrng;
                        Double BMISkrng;
                        CardView Mhari3 = (CardView) rootView.findViewById(R.id.Mhari3);
                        TextView BB1 = (TextView) rootView.findViewById(R.id.Mbb);
                        if (Status == 1){
                            status.setText("Kurus");
                            BBSkrng = BB + 2;
                            BMISkrng = BMI - 2;
                            ed.putString("BBawal", BBSkrng.toString());
//                    ed.putString("BMI", BMISkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
//                    BBideal.setText(df.format(BMISkrng)+"KG");
                            if (BMI < Double.parseDouble(BBkuu)) {
                                BBideal.setText("Ideal");
                                status.setText("Normal");
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        } else if (Status == 3){
                            status.setText("Gemuk");
                            BBSkrng = BB - 2;
                            BMISkrng = BMI - 2;
                            ed.putString("BBawal", BBSkrng.toString());
//                    ed.putString("BMI", BMISkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
//                    BBideal.setText(df.format(BMISkrng)+"KG");
                            if (BMI > Double.parseDouble(BBkuu)) {
                                BBideal.setText("Ideal");
                                status.setText("Normal");
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                        Mhari3.setVisibility(View.GONE);
                        //return rootView;
                    }
                });

                Upbbh4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ed.putInt("Chp4", 2);
                        ed.putInt("Chs4", 2);
                        ed.putInt("Chm4", 2);
                        ed.putInt("Chol4", 2);
                        ed.commit();
                        String bbku = sp.getString("BBawal", "");
                        String bmi = sp.getString("BMI", "");
                        Double BB = Double.parseDouble(bbku);
                        Double BMI = Double.parseDouble(bmi);
                        Double BBSkrng;
                        Double BMISkrng;
                        CardView Mhari4 = (CardView) rootView.findViewById(R.id.Mhari4);
                        TextView BB1 = (TextView) rootView.findViewById(R.id.Mbb);
                        if (Status == 1){
                            status.setText("Kurus");
                            BBSkrng = BB + 2;
                            BMISkrng = BMI - 2;
                            ed.putString("BBawal", BBSkrng.toString());
//                    ed.putString("BMI", BMISkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
//                    BBideal.setText(df.format(BMISkrng)+"KG");
                            if (BMI < Double.parseDouble(BBkuu)) {
                                BBideal.setText("Ideal");
                                status.setText("Normal");
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        } else if (Status == 3){
                            status.setText("Gemuk");
                            BBSkrng = BB - 2;
                            BMISkrng = BMI - 2;
                            ed.putString("BBawal", BBSkrng.toString());
//                    ed.putString("BMI", BMISkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString()+" KG");
//                    BBideal.setText(df.format(BMISkrng)+"KG");
                            if (BMI > Double.parseDouble(BBkuu)) {
                                BBideal.setText("Ideal");
                                status.setText("Normal");
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                        Mhari4.setVisibility(View.GONE);
                        //return rootView;
                    }
                });

                Upbbh5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ed.putInt("Chp5", 2);
                        ed.putInt("Chs5", 2);
                        ed.putInt("Chm5", 2);
                        ed.putInt("Chol5", 2);
                        ed.commit();
                        String bbku = sp.getString("BBawal", "");
                        String bmi = sp.getString("BMI", "");
                        Double BB = Double.parseDouble(bbku);
                        Double BMI = Double.parseDouble(bmi);
                        Double BBSkrng;
                        Double BMISkrng;
                        CardView Mhari5 = (CardView) rootView.findViewById(R.id.Mhari5);
                        TextView BB1 = (TextView) rootView.findViewById(R.id.Mbb);
                        if (Status == 1) {
                            status.setText("Kurus");
                            BBSkrng = BB + 2;
                            BMISkrng = BMI - 2;
                            ed.putString("BBawal", BBSkrng.toString());
//                    ed.putString("BMI", BMISkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString() + " KG");
//                    BBideal.setText(df.format(BMISkrng) + "KG");
                            if (BMI < Double.parseDouble(BBkuu)) {
                                BBideal.setText("Ideal");
                                status.setText("Normal");
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        } else if (Status == 3) {
                            status.setText("Gemuk");
                            BBSkrng = BB - 2;
                            BMISkrng = BMI - 2;
                            ed.putString("BBawal", BBSkrng.toString());
//                    ed.putString("BMI", BMISkrng.toString());
                            ed.commit();
                            BB1.setText(BBSkrng.toString() + " KG");
//                    BBideal.setText(df.format(BMISkrng) + "KG");
                            if (BMI > Double.parseDouble(BBkuu)) {
                                BBideal.setText("Ideal");
                                status.setText("Normal");
                                ed.putInt("Status", 2);
                                ed.commit();
                            }
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                        Mhari5.setVisibility(View.GONE);
                        //return rootView;
                    }
                });

                final Integer WJsarapan, WTsarapan, WJsiang, WTsiang, WJmalam, WTmalam;
                WJsarapan = sp.getInt("TJsarapan", 0);
                WTsarapan = sp.getInt("TMsarapan", 0);
                WJsiang = sp.getInt("TJsiang", 0);
                WTsiang = sp.getInt("TMsiang", 0);
                WJmalam = sp.getInt("TJmalam", 0);
                WTmalam = sp.getInt("TMmalam", 0);
                if (WJsarapan == 0){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setMessage("Anda Belum Menentukan Jadwal Waktu Diet. Silahkan Atur Sekarang ?");

                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(getActivity(), "Silahkan Tentukan Waktu Di Menu Atur Waktu Notifikasi", Toast.LENGTH_LONG).show();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }


                Tsarapan.setText(WJsarapan +":"+ WTsarapan);
                Tsiang.setText(WJsiang +":"+ WTsiang);
                Tmalam.setText(WJmalam +":"+ WTmalam);

                Chpku.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chpku.isChecked()){
                            ed.putInt("Chpku", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsiang);
                            calender.set(Calendar.MINUTE, WTsiang);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                            //Toast.makeText(getActivity(), "diatur pada jam 18:00", Toast.LENGTH_LONG);
                        }
                        else {
                            ed.putInt("Chpku", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });


                Chp1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chp1.isChecked()){
                            ed.putInt("Chp1", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsiang);
                            calender.set(Calendar.MINUTE, WTsiang);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                            //Toast.makeText(getActivity(), "diatur pada jam 18:00", Toast.LENGTH_LONG);
                        }
                        else {
                            ed.putInt("Chp1", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chp2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chp2.isChecked()){
                            ed.putInt("Chp2", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsiang);
                            calender.set(Calendar.MINUTE, WTsiang);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chp2", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chp3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chp3.isChecked()){
                            ed.putInt("Chp3", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsiang);
                            calender.set(Calendar.MINUTE, WTsiang);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chp3", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chp4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chp4.isChecked()){
                            ed.putInt("Chp4", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsiang);
                            calender.set(Calendar.MINUTE, WTsiang);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chp4", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chp5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chp5.isChecked()){
                            ed.putInt("Chp5", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsiang);
                            calender.set(Calendar.MINUTE, WTsiang);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chp5", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chsku.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chsku.isChecked()){
                            ed.putInt("Chsku", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJmalam);
                            calender.set(Calendar.MINUTE, WTmalam);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chsku", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chs1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chs1.isChecked()){
                            ed.putInt("Chs1", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJmalam);
                            calender.set(Calendar.MINUTE, WTmalam);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chs1", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chs2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chs2.isChecked()){
                            ed.putInt("Chs2", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJmalam);
                            calender.set(Calendar.MINUTE, WTmalam);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chs2", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chs3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chs3.isChecked()){
                            ed.putInt("Chs3", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJmalam);
                            calender.set(Calendar.MINUTE, WTmalam);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chs3", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chs4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chs4.isChecked()){
                            ed.putInt("Chs4", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJmalam);
                            calender.set(Calendar.MINUTE, WTmalam);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chs4", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chs5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chs5.isChecked()){
                            ed.putInt("Chs5", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJmalam);
                            calender.set(Calendar.MINUTE, WTmalam);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chs5", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chmku.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chmku.isChecked()){
                            ed.putInt("Chmku", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsarapan);
                            calender.set(Calendar.MINUTE, WTsarapan);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chmku", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chm1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chm1.isChecked()){
                            ed.putInt("Chm1", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsarapan);
                            calender.set(Calendar.MINUTE, WTsarapan);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chm1", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chm2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chm2.isChecked()){
                            ed.putInt("Chm2", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsarapan);
                            calender.set(Calendar.MINUTE, WTsarapan);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chm2", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chm3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chm3.isChecked()){
                            ed.putInt("Chm3", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsarapan);
                            calender.set(Calendar.MINUTE, WTsarapan);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chm3", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chm4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chm4.isChecked()){
                            ed.putInt("Chm4", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsarapan);
                            calender.set(Calendar.MINUTE, WTsarapan);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chm4", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chm5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chm5.isChecked()){
                            ed.putInt("Chm5", 1);
                            ed.commit();
                            calender.set(Calendar.HOUR_OF_DAY, WJsarapan);
                            calender.set(Calendar.MINUTE, WTsarapan);
                            calender.set(Calendar.SECOND, 0);
                            if (calender.compareTo(calNow) <= 0) {
                                // Today Set time passed, count to tomorrow
                                calender.add(Calendar.DATE, 1);
                                Log.i("hasil", " =<0");
                                Toast.makeText(getActivity(), "Notif diatur Untuk Jam makan siang besok  12:00", Toast.LENGTH_LONG);
                            }
                            Toast.makeText(getActivity(), "diatur pada jam  12:00", Toast.LENGTH_LONG);
                            scheduleClient.setAlarmForNotification(calender);
                        }
                        else {
                            ed.putInt("Chm5", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Cholku.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Cholku.isChecked()){
                            ed.putInt("Cholku", 1);
                            ed.commit();
                        }
                        else {
                            ed.putInt("Cholku", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chol1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chol1.isChecked()){
                            ed.putInt("Chol1", 1);
                            ed.commit();
                        }
                        else {
                            ed.putInt("Chol1", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chol2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chol2.isChecked()){
                            ed.putInt("Chol2", 1);
                            ed.commit();
                        }
                        else {
                            ed.putInt("Chol2", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chol3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chol3.isChecked()){
                            ed.putInt("Chol3", 1);
                            ed.commit();
                        }
                        else {
                            ed.putInt("Chol3", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chol4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chol4.isChecked()){
                            ed.putInt("Chol4", 1);
                            ed.commit();
                        }
                        else {
                            ed.putInt("Chol4", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Chol5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Chol5.isChecked()){
                            ed.putInt("Chol5", 1);
                            ed.commit();
                        }
                        else {
                            ed.putInt("Chol5", 2);
                            ed.commit();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().
                                replace(R.id.container_body, new MainTab())
                                .commit();
                    }
                });

                Integer Chpp1, Chpp2, Chpp3, Chpp4, Chpp5, Chppku,
                        Chss1, Chss2, Chss3, Chss4, Chss5, Chssku,
                        Chmm1,Chmm2, Chmm3, Chmm4, Chmm5, Chmmku,
                        Chool1, Chool2,Chool3, Chool4, Chool5, Choolku ;

                Chppku = sp.getInt("Chpku", 0); Chpp1 = sp.getInt("Chp1", 0); Chpp2 = sp.getInt("Chp2", 0); Chpp3 = sp.getInt("Chp3", 0); Chpp4 = sp.getInt("Chp4", 0); Chpp5 = sp.getInt("Chp5", 0);
                Chssku = sp.getInt("Chsku", 0);Chss1 = sp.getInt("Chs1", 0); Chss2 = sp.getInt("Chs2", 0); Chss3 = sp.getInt("Chs3", 0); Chss4 = sp.getInt("Chs4", 0); Chss5 = sp.getInt("Chs5", 0);
                Chmmku = sp.getInt("Chmku", 0);Chmm1 = sp.getInt("Chm1", 0); Chmm2 = sp.getInt("Chm2", 0); Chmm3 = sp.getInt("Chm3", 0); Chmm4 = sp.getInt("Chm4", 0); Chmm5 = sp.getInt("Chm5", 0);
                Choolku = sp.getInt("Cholku", 0);Chool1 = sp.getInt("Chol1", 0); Chool2 = sp.getInt("Chol2", 0); Chool3 = sp.getInt("Chol3", 0); Chool4 = sp.getInt("Chol4", 0); Chool5 = sp.getInt("Chol5", 0);

                if (Chppku == 1){
                    Chpku.setChecked(true);

                }
                else if (Chppku == 2){
                    Chpku.setChecked(false);
                }

                if (Chpp1 == 1){
                    Chp1.setChecked(true);

                }
                else if (Chpp1 == 2){
                    Chp1.setChecked(false);
                }

                if (Chpp2 == 1){
                    Chp2.setChecked(true);
                }
                else if (Chpp2 == 2){
                    Chp2.setChecked(false);
                }

                if (Chpp3 == 1){
                    Chp3.setChecked(true);
                }
                else if (Chpp3 == 2){
                    Chp3.setChecked(false);
                }

                if (Chpp4 == 1){
                    Chp4.setChecked(true);
                }
                else if (Chpp4 == 2){
                    Chp4.setChecked(false);
                }

                if (Chpp5 == 1){
                    Chp5.setChecked(true);
                }
                else if (Chpp5 == 2){
                    Chp5.setChecked(false);
                }

                if (Chssku == 1){
                    Chsku.setChecked(true);
                }
                else if (Chssku == 2){
                    Chsku.setChecked(false);
                }

                if (Chss1 == 1){
                    Chs1.setChecked(true);
                }
                else if (Chss1 == 2){
                    Chs1.setChecked(false);
                }

                if (Chss2 == 1){
                    Chs2.setChecked(true);
                }
                else if (Chss2 == 2){
                    Chs2.setChecked(false);
                }

                if (Chss3 == 1){
                    Chs3.setChecked(true);
                }
                else if (Chss3 == 2){
                    Chs3.setChecked(false);
                }

                if (Chss4 == 1){
                    Chs4.setChecked(true);
                }
                else if (Chss4 == 2){
                    Chs4.setChecked(false);
                }

                if (Chss5 == 1){
                    Chs5.setChecked(true);
                }
                else if (Chss5 == 2){
                    Chs5.setChecked(false);
                }

                if (Chmmku == 1){
                    Chmku.setChecked(true);
                }
                else if (Chmmku == 2){
                    Chmku.setChecked(false);
                }


                if (Chmm1 == 1){
                    Chm1.setChecked(true);
                }
                else if (Chmm1 == 2){
                    Chm1.setChecked(false);
                }

                if (Chmm2 == 1){
                    Chm2.setChecked(true);
                }
                else if (Chmm2 == 2){
                    Chm2.setChecked(false);
                }

                if (Chmm3 == 1){
                    Chm3.setChecked(true);
                }
                else if (Chmm3 == 2){
                    Chm3.setChecked(false);
                }

                if (Chmm4 == 1){
                    Chm4.setChecked(true);
                }
                else if (Chmm4 == 2){
                    Chm4.setChecked(false);
                }

                if (Chmm5 == 1){
                    Chm5.setChecked(true);
                }
                else if (Chmm5 == 2){
                    Chm5.setChecked(false);
                }

                if (Choolku == 1){
                    Cholku.setChecked(true);
                }
                else if (Choolku == 2){
                    Cholku.setChecked(false);
                }

                if (Chool1 == 1){
                    Chol1.setChecked(true);
                }
                else if (Chool1 == 2){
                    Chol1.setChecked(false);
                }

                if (Chool2 == 1){
                    Chol2.setChecked(true);
                }
                else if (Chool2 == 2){
                    Chol2.setChecked(false);
                }

                if (Chool3 == 1){
                    Chol3.setChecked(true);
                }
                else if (Chool3 == 2){
                    Chol3.setChecked(false);
                }

                if (Chool4 == 1){
                    Chol4.setChecked(true);
                }
                else if (Chool4 == 2){
                    Chol4.setChecked(false);
                }

                if (Chool5 == 1){
                    Chol5.setChecked(true);
                }
                else if (Chool5 == 2){
                    Chol5.setChecked(false);
                }

                Upbbh1.setEnabled(false);
                Upbbh2.setEnabled(false);
                Upbbh3.setEnabled(false);
                Upbbh4.setEnabled(false);
                Upbbh5.setEnabled(false);
                Upbbku.setEnabled(false);

                if (Chpku.isChecked()&&Chsku.isChecked()&&Chmku.isChecked()&& Cholku.isChecked()){
                    Upbbku.setEnabled(true);
                }

                if (Chp1.isChecked()&&Chs1.isChecked()&&Chm1.isChecked()&& Chol1.isChecked()){
                    Upbbh1.setEnabled(true);
                }

                if (Chp2.isChecked()&&Chs2.isChecked()&&Chm2.isChecked()&& Chol2.isChecked()){
                    Upbbh2.setEnabled(true);
                }

                if (Chp3.isChecked()&&Chs3.isChecked()&&Chm3.isChecked()&& Chol3.isChecked()){
                    Upbbh3.setEnabled(true);
                }

                if (Chp4.isChecked()&&Chs4.isChecked()&&Chm4.isChecked()&& Chol4.isChecked()){
                    Upbbh4.setEnabled(true);
                }

                if (Chp5.isChecked()&&Chs5.isChecked()&&Chm5.isChecked()&& Chol5.isChecked()){
                    Upbbh5.setEnabled(true);
                }
            }

        return rootView;
    }

    private void Normal(boolean coba){
        SharedPreferences sp = getActivity().getSharedPreferences("datadiet", Context.MODE_PRIVATE);
        String BBMI = sp.getString("BMI","");
        Integer Progressdiet = sp.getInt("ProgresDiet", 0);
        BBideal.setText(BBMI);
        status.setText("Normal");
        Ingat.setVisibility(View.GONE);
        Mhariku.setVisibility(View.GONE);
        Mhari1.setVisibility(View.GONE);
        Mhari2.setVisibility(View.GONE);
        Mhari3.setVisibility(View.GONE);
        Mhari4.setVisibility(View.GONE);
        Mhari5.setVisibility(View.GONE);
        Sehat.setVisibility(View.VISIBLE);
        if (Progressdiet == 2){
            Progress.setVisibility(View.VISIBLE);
        }
        else {
            Progress.setVisibility(View.GONE);
        }
    }

    private void Kurus(boolean status){

    }

    private void setAlarm(Calendar targetCal, boolean repeat) {

        Intent intent = new Intent(getActivity().getBaseContext(), RecieverNotif.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity().getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);

        if (repeat) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), TimeUnit.MINUTES.toMillis(5), pendingIntent);
            Toast.makeText(getActivity(),
                    "Notifikasi diatur pada " + targetCal.getTime(), Toast.LENGTH_SHORT).show();

        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP,
                    targetCal.getTimeInMillis(),
                    pendingIntent);
            Toast.makeText(getActivity(),

                    "Notifikasi diatur pada " + targetCal.getTime(), Toast.LENGTH_SHORT).show();
        }
    }
}
