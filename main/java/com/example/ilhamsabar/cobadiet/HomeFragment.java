package com.example.ilhamsabar.cobadiet;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by ilham sabar on 10/25/2015.
 */
public class HomeFragment extends Fragment  {

    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public static final int NOTIFICATION_ID = 1284885;
    static final int uniquwID = 1284885;
    NotificationManager notificationManager;
    EditText umur, tinggi, berat;
    TextView Hasil, Olahraga, Kategoribb,jdlkategoribb, makandisarankan, olahragadisarankan, foother;
    RadioButton lk, pr, a, o, b, ab;
    ImageView olahraga,makan, imgkategoribb;
    CheckBox Pmaag,PasamLambung, Pkolestrol,Phipertensi,Pdiabetes;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        umur = (EditText) rootView.findViewById(R.id.umur);
        berat = (EditText) rootView.findViewById(R.id.beratbadan);
        tinggi = (EditText) rootView.findViewById(R.id.tinggibadan);
        lk = (RadioButton) rootView.findViewById(R.id.rblaki);
        pr = (RadioButton) rootView.findViewById(R.id.rbperempuan);
        a = (RadioButton) rootView.findViewById(R.id.golA);
        b = (RadioButton) rootView.findViewById(R.id.golB);
        o = (RadioButton) rootView.findViewById(R.id.golO);
        ab = (RadioButton) rootView.findViewById(R.id.golAB);
//        Hasil = (TextView) rootView.findViewById(R.id.output);
//        Olahraga = (TextView) rootView.findViewById(R.id.olahraga);
//        Kategoribb = (TextView) rootView.findViewById(R.id.kategoribb);

        Pdiabetes = (CheckBox) rootView.findViewById(R.id.PDiabetes);
        PasamLambung = (CheckBox) rootView.findViewById(R.id.PAsamurat);
        Pkolestrol = (CheckBox) rootView.findViewById(R.id.PKolestrol);
        Pmaag = (CheckBox) rootView.findViewById(R.id.PMaag);
        Phipertensi = (CheckBox) rootView.findViewById(R.id.PHipertensi);

        TextView coba = (TextView) rootView.findViewById(R.id.coba);

        SharedPreferences sp = getActivity().getSharedPreferences("datadiet", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        

//        olahraga = (ImageView) rootView.findViewById(R.id.olahragaimage);
//        makan = (ImageView) rootView.findViewById(R.id.makanan);
//        imgkategoribb = (ImageView) rootView.findViewById(R.id.imgkategoribb);
//        jdlkategoribb = (TextView) rootView.findViewById(R.id.jdlkategoribb);
//        makandisarankan = (TextView) rootView.findViewById(R.id.makandisarankan);
//        olahragadisarankan = (TextView) rootView.findViewById(R.id.olahragadisarankan);
//        foother = (TextView) rootView.findViewById(R.id.foother);
//
//        olahraga.setVisibility(View.GONE);
//        makan.setVisibility(View.GONE);
//        imgkategoribb.setVisibility(View.GONE);
//        jdlkategoribb.setVisibility(View.GONE);
//        makandisarankan.setVisibility(View.GONE);
//        olahragadisarankan.setVisibility(View.GONE);
//        foother.setVisibility(View.GONE);



        umur.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                harusdiisi(umur);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

        });
        tinggi.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                harusdiisi(tinggi);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


        });
        berat.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                harusdiisi(berat);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                harusdiisi(berat);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

        });

        Button proses = (Button)rootView.findViewById(R.id.Proses);
        proses.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){

                if ((umur.getText().toString().trim().length() == 0)&&(berat.getText().toString().trim().length() == 0)&&(tinggi.getText().toString().trim().length() == 0)){
                    Toast.makeText(getActivity(), "data belum lengkap", Toast.LENGTH_LONG).show();
                }
                else if (umur.getText().toString().trim().length()==0){
                    Toast.makeText(getActivity(), "Umur belum diisi", Toast.LENGTH_LONG).show();
                }
                else if (berat.getText().toString().trim().length()==0){
                    Toast.makeText(getActivity(), "Berat belum diisi", Toast.LENGTH_LONG).show();
                }
                else if (tinggi.getText().toString().trim().length()==0){
                    Toast.makeText(getActivity(), "TInggi belum diisi", Toast.LENGTH_LONG).show();
                }
                else {

                    final ProgressDialog ringProgressDialog = ProgressDialog.show(getActivity(), "Mohon Tunggu", "Mendiagnosa...", true);
                    ringProgressDialog.setCancelable(true);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                // Here you should write your time consuming task...
                                // Let the progress ring for 10 seconds..
                                Thread.sleep(3000);
                            } catch (Exception e) {

                            }
                            ringProgressDialog.dismiss();
                            Double Tb = Double.parseDouble(tinggi.getText().toString());
                            Double Bb = Double.parseDouble(berat.getText().toString());
                            Integer usia = Integer.parseInt(umur.getText().toString());

                            DecimalFormat df = new DecimalFormat();
                            df.setGroupingUsed(true);
                            df.setMaximumIntegerDigits(8);
                            df.setMaximumFractionDigits(2);

                            Double hTb = Tb / 100;
                            Double BBIdeal;
                            Double  BBidealBorca = null;
                            Double Beratbadan = null;
                            BBIdeal = (Bb / (hTb*hTb));

                            SharedPreferences sp = getActivity().getSharedPreferences("datadiet", Context.MODE_PRIVATE);
                            SharedPreferences.Editor ed = sp.edit();
                            ed.putInt("StatusSp", 2);

//                            if (pr.isChecked()){
//                                BBidealBorca = ((Tb-100)-(0.15*(Tb-100)));
//                                ed.putString("BMI", String.valueOf(BBidealBorca));
//                                ed.putString("Beratbadan", "+" + String.valueOf(df.format(Beratbadan)));
//                            }
//                            else if (lk.isChecked()){
//                                BBidealBorca = ((Tb-100)-(0.10*(Tb-100)));
//                                Beratbadan = Bb - BBidealBorca;
//                                Beratbadan = -1 * Beratbadan;
//                                ed.putString("BMI", String.valueOf(BBidealBorca));
//                                ed.putString("Beratbadan", "+" + String.valueOf(df.format(Beratbadan)));
//                            }

                            String HailDiagnosaBerat ="";
                            String OlahragaDisarankan="";
                            String MakananDisarankan="";
                            String KategoriUmur = "";
                            String MetodedietDisarankan="" ;
                            String MenuSarapan1 = ""; String MenuSarapan2 = ""; String MenuSarapan3 = ""; String MenuSarapan4 = ""; String MenuSarapan5 = "";
                            String MenuSiang1 = ""; String MenuSiang2 = ""; String MenuSiang3 = ""; String MenuSiang4 = "";String MenuSiang5 = "";
                            String MenuMalam1 = "";String MenuMalam2 = ""; String MenuMalam3 = ""; String MenuMalam4 = "";String MenuMalam5 = "";
                            String Suplemen = "";
                            Fragment fragment = null;
                            fragment = new Hasildiagnosa();
                            if (fragment != null){
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container_body, fragment);
                                //fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                            ed.putInt("Chp1", 2); ed.putInt("Chp2", 2); ed.putInt("Chp3", 2); ed.putInt("Chp4", 2); ed.putInt("Chp5", 2);
                            ed.putInt("Chs1", 2); ed.putInt("Chs2", 2); ed.putInt("Chs3", 2); ed.putInt("Chs4", 2); ed.putInt("Chs5", 2);
                            ed.putInt("Chm1", 2); ed.putInt("Chm2", 2); ed.putInt("Chm3", 2); ed.putInt("Chm4", 2); ed.putInt("Chm5", 2);
                            ed.putInt("Chol1", 2); ed.putInt("Chol2", 2); ed.putInt("Chol3", 2); ed.putInt("Chol4", 2); ed.putInt("Chol5", 2);
                            ed.putString("BBawal", berat.getText().toString());
                            ed.putInt("BBawal1", Integer.parseInt(berat.getText().toString()));
                            ed.putInt("BBku", Integer.parseInt(berat.getText().toString()));
                            ed.putInt("Umur", usia);
                            ed.putInt("ProgresDiet", 1);
                            String Pantangan,JenisPenyakit;
                            JenisPenyakit = "Tidak ada Pantangan Makanan \n Berdasarkan Riwayat Penyakit";
                            Pantangan = "";
                            if (Pmaag.isChecked()){
                                JenisPenyakit = "Maag/Maag Kronis";
                                Pantangan = getString(R.string.maag);

                            }
                            if (Phipertensi.isChecked()){
                                JenisPenyakit = "Hipertensi";
                                Pantangan = getString(R.string.hipertensi);
                            }
                            if(PasamLambung.isChecked()){
                                JenisPenyakit = "Asam Lambung";
                                Pantangan = getString(R.string.asam_lambung);
                            }
                            if(Pkolestrol.isChecked()){
                                JenisPenyakit = "Kolestrol";
                                Pantangan = getString(R.string.kolestrol);
                            }
                            if (Pdiabetes.isChecked()){
                                JenisPenyakit = "Diabetes";
                                Pantangan = getString(R.string.diabetes);
                            }
                            if ((Pmaag.isChecked())&&(Pdiabetes.isChecked())){
                                JenisPenyakit = "Maag dan Diabetes";
                                Pantangan = getString(R.string.maagdiabetes);
                            }
                            if ((Pmaag.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Maag dan Kolestrol";
                                Pantangan = getString(R.string.maagkolestrol);
                            }
                            if((Pmaag.isChecked())&&(Phipertensi.isChecked())){
                                JenisPenyakit = "Maag dan Hipertensi";
                                Pantangan = getString(R.string.maaghipertensi);
                            }
                            if ((Pmaag.isChecked())&&(PasamLambung.isChecked())){
                                JenisPenyakit = "Maag dan asam Lambung";
                                Pantangan = getString(R.string.maagasamlambung);
                            }
                            if ((Pdiabetes.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Diabetes dan kolestrol";
                                Pantangan = getString(R.string.diabeteskolestrol);
                            }
                            if ((Pdiabetes.isChecked())&&(PasamLambung.isChecked())){
                                JenisPenyakit = "Diabetes dan Asam Lambung";
                                Pantangan = getString(R.string.diabetesasamlambung);
                            }
                            if ((Pdiabetes.isChecked())&&(Phipertensi.isChecked())){
                                JenisPenyakit = "Diabetes dan Hipertensi";
                                Pantangan = getString(R.string.diabeteshipertensi);
                            }
                            if((Pkolestrol.isChecked())&&(Phipertensi.isChecked())){
                                JenisPenyakit = "Kolestrol dan Hipertensi";
                                Pantangan = getString(R.string.kolestrolhipertensi);
                            }
                            if ((Pkolestrol.isChecked())&&(PasamLambung.isChecked())){
                                JenisPenyakit = "Kolestrol dan Asam Lambung";
                                Pantangan = getString(R.string.kolestrolasamlambung);
                            }
                            if ((Phipertensi.isChecked())&&(PasamLambung.isChecked())){
                                JenisPenyakit= "Hipertensi dan Asam Lambung";
                                Pantangan = getString(R.string.hipertensiasamlambung);
                            }
                            if((Pmaag.isChecked())&&(Pdiabetes.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Maag, Diabetes, dan Kolestrol";
                                Pantangan = getString(R.string.maagdiabeteskolestrol);
                            }
                            if((Phipertensi.isChecked())&&(Pmaag.isChecked())&&(Pdiabetes.isChecked())){
                                JenisPenyakit = "Hipertensi, Maag, dan Diabetes";
                                Pantangan = getString(R.string.hipertensimaagdiabetes);
                            }
                            if((Phipertensi.isChecked())&&(Pmaag.isChecked())&&(PasamLambung.isChecked())){
                                JenisPenyakit = "Hipertensi, Maag, dan Asam Lambung";
                                Pantangan = getString(R.string.hipertensimaagasamlambung);
                            }
                            if ((Phipertensi.isChecked())&&(Pmaag.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Hipertensi, Maag, dan Kolestrol";
                                Pantangan = getString(R.string.hipertensimaagkolestrol);
                            }
                            if((Phipertensi.isChecked())&&(Pdiabetes.isChecked())&&(PasamLambung.isChecked())){
                                JenisPenyakit = "Hipertensi, Diabetes, dan Asam Lambung";
                                Pantangan = getString(R.string.hipertensi)+getString(R.string.diabetes)+getString(R.string.asam_lambung);
                            }
                            if ((Phipertensi.isChecked())&&(PasamLambung.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Hipertensi, Asam Lambung, dan Kolestrol";
                                Pantangan = getString(R.string.hipertensi)+getString(R.string.asam_lambung)+getString(R.string.kolestrol);
                            }
                            if ((Phipertensi.isChecked())&&(Pdiabetes.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Hipertensi, Diabetes, dan Kolestrol";
                                Pantangan = getString(R.string.hipertensi)+getString(R.string.diabetes)+getString(R.string.kolestrol);
                            }
                            if((Pmaag.isChecked())&&(Pdiabetes.isChecked())&&(PasamLambung.isChecked())){
                                JenisPenyakit = "Maag, Diabetes, dan Asam Lambung";
                                Pantangan = getString(R.string.maag)+getString(R.string.diabetes)+getString(R.string.asam_lambung);
                            }
                            if((Pmaag.isChecked())&&(PasamLambung.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Maag, Asam Lambung, dan Kolestrol";
                                Pantangan = getString(R.string.maag)+getString(R.string.asam_lambung)+getString(R.string.kolestrol);
                            }
                            if ((Pdiabetes.isChecked())&&(PasamLambung.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Diabetes, Asam Lambung, dan Kolestrol";
                                Pantangan = getString(R.string.diabetes)+getString(R.string.asam_lambung)+getString(R.string.kolestrol);
                            }
                            if ((Phipertensi.isChecked())&&(Pmaag.isChecked())&&(Pdiabetes.isChecked())&&(PasamLambung.isChecked())){
                                JenisPenyakit = "Hipertensi, Maag, Diabetes, dan Asam Lambung";
                                Pantangan = getString(R.string.hipertensi)+getString(R.string.maag)+getString(R.string.diabetes)+getString(R.string.asam_lambung);
                            }
                            if ((Phipertensi.isChecked())&&(Pmaag.isChecked())&&(Pdiabetes.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Hipertensi, Maag, Diabetes, dan Kolestrol";
                                Pantangan = getString(R.string.hipertensi)+getString(R.string.maag)+getString(R.string.diabetes)+getString(R.string.kolestrol);
                            }
                            if ((Phipertensi.isChecked())&&(Pdiabetes.isChecked())&&(PasamLambung.isChecked())&&(Pkolestrol.isChecked())){
                                JenisPenyakit = "Hipertensi, Diabetes, Asam Lambung, dan Kolestrol";
                                Pantangan = getString(R.string.hipertensi)+getString(R.string.diabetes)+getString(R.string.asam_lambung)+getString(R.string.kolestrol);
                            }
                            if ((Phipertensi.isChecked())&&(PasamLambung.isChecked())&&(Pkolestrol.isChecked())&&(Pmaag.isChecked())) {
                                JenisPenyakit = "Hipertensi, Asam Lambung, Kolestrol, dan Maag";
                                Pantangan = getString(R.string.hipertensi)+getString(R.string.asam_lambung)+getString(R.string.kolestrol)+getString(R.string.maag);
                            }
                            if ((Pmaag.isChecked())&&(Pdiabetes.isChecked())&&(PasamLambung.isChecked())&&(Pkolestrol.isChecked())) {
                                JenisPenyakit = "Maag, Asam Lambung, Kolestrol, dan Diabetes";
                                Pantangan = getString(R.string.hipertensi)+getString(R.string.diabetes)+getString(R.string.asam_lambung)+getString(R.string.kolestrol);
                            }

                            if (BBIdeal<18){
                                HailDiagnosaBerat = getString(R.string.kurus);
                                ed.putInt("ProgresDiet", 2);
                                if (usia < 8){
                                    KategoriUmur ="Kategori Usia Tidak Disarankan";
                                    if (pr.isChecked()){
                                        OlahragaDisarankan = KategoriUmur;
                                        MakananDisarankan = KategoriUmur;
                                        BBidealBorca = ((Tb-100)-(0.15*(Tb-100)));
                                        ed.putString("BMI", String.valueOf(BBidealBorca));
                                        ed.putString("Beratbadan", "+" + String.valueOf(df.format(Beratbadan)));
                                    }
                                    else if (lk.isChecked()){
                                        OlahragaDisarankan = KategoriUmur;
                                        MakananDisarankan = KategoriUmur;
                                        BBidealBorca = ((Tb-100)-(0.10*(Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        Beratbadan = -1 * Beratbadan;
                                        ed.putString("BMI", String.valueOf(BBidealBorca));
                                        ed.putString("Beratbadan", "+" + String.valueOf(df.format(Beratbadan)));
                                    }
                                }
                                else if (usia>8){
                                    ed.putInt("Status", 1);
                                    ed.putInt("Statusawal", 1);
                                    if (pr.isChecked()){
                                        BBidealBorca = ((Tb-100)-(0.15*(Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        Beratbadan = -1 * Beratbadan;
                                        ed.putString("BMI", String.valueOf(BBidealBorca));
                                        ed.putString("Beratbadan", "+" + String.valueOf(df.format(Beratbadan)));
                                    }
                                    else if (lk.isChecked()) {
                                        BBidealBorca = ((Tb - 100) - (0.10 * (Tb - 100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        Beratbadan = -1 * Beratbadan;
                                        ed.putString("BMI", String.valueOf(BBidealBorca));
                                        ed.putString("Beratbadan", "+" + String.valueOf(df.format(Beratbadan)));
                                    }
                                    MakananDisarankan = getString(R.string.kurus_makanandisarankan);
                                    MenuSarapan1 = getString(R.string.kurus_menusarapan1);MenuSiang1 = getString(R.string.kurus_menusiang1);MenuMalam1 = getString(R.string.kurus_menumalam1);
                                    MenuSarapan2= getString(R.string.kurus_menusarapan2);;MenuSiang2 = getString(R.string.kurus_menusiang2);MenuMalam2 = getString(R.string.kurus_menumalam2);
                                    MenuSarapan3= getString(R.string.kurus_menusarapan3);MenuSiang3 = getString(R.string.kurus_menusiang3);MenuMalam3 = getString(R.string.kurus_menumalam3);
                                    MenuSarapan4= getString(R.string.kurus_menusarapan4);MenuSiang4 = getString(R.string.kurus_menusiang4);MenuMalam4 = getString(R.string.kurus_menumalam4);
                                    MenuSarapan5 = getString(R.string.kurus_menusarapan5);MenuSiang5 = getString(R.string.kurus_menusiang5);MenuMalam5 = getString(R.string.kurus_menumalam5);
                                    if (Pmaag.isChecked()){
                                        MakananDisarankan = getString(R.string.kurus_maag_makanan);
                                    }
                                    if (Pkolestrol.isChecked()){
                                        MakananDisarankan = getString(R.string.kurus_kolestrolmakanan);
                                    }
                                    if (Phipertensi.isChecked()){
                                        MakananDisarankan = getString(R.string.kurus_hipertensimakanan);
                                    }
                                    if (Pdiabetes.isChecked()){
                                        MakananDisarankan = getString(R.string.kurus_diabetesmakanan);
                                    }
                                    if (PasamLambung.isChecked()){
                                        MakananDisarankan = getString(R.string.kurus_asamlambungmakanan);
                                    }

                                    if (a.isChecked()){
                                        OlahragaDisarankan = getString(R.string.golA_olahraga);
                                        MakananDisarankan = getString(R.string.golA_makanan);
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golA_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golA_olahragalaki);
                                        }
                                    }
                                    else if (b.isChecked()){
                                        MakananDisarankan = getString(R.string.golB_makanan);
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golB_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golB_olahragalaki);
                                        }
                                    }
                                    else if (o.isChecked()){
                                        MakananDisarankan = getString(R.string.golO_makanan);
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golO_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golO_olahragalaki);
                                        }
                                    }
                                    else if (ab.isChecked()){
                                        MakananDisarankan = getString(R.string.golAB_makanan);
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golAB_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golAB_olahragalaki);
                                        }
                                    }
                                }
                            }

                            else if (BBIdeal>18 && BBIdeal<25){
                                HailDiagnosaBerat = getString(R.string.normal_kategori);
                                OlahragaDisarankan = getString(R.string.normal_olahragadisarankan);
                                MakananDisarankan = getString(R.string.normal_makanandisarankan);
                                ed.putString("Beratbadan","Normal");
                                ed.putInt("Status", 2);
                                ed.putInt("Statusawal", 2);
                                ed.putInt("ProgresDiet", 1);
                            }

                            else if (BBIdeal>25 && BBIdeal<27){
                                ed.putInt("Status", 3);
                                ed.putInt("Statusawal", 3);
                                ed.putInt("ProgresDiet", 2);
                                HailDiagnosaBerat = getString(R.string.gemuk_kategori);
                                if (usia<8){
                                    KategoriUmur =getString(R.string.kategoriumur);
                                    if (pr.isChecked()){
                                        OlahragaDisarankan = KategoriUmur;
                                        MakananDisarankan = KategoriUmur;
                                        BBidealBorca = ((Tb-100)-(0.15*(Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        ed.putString("BMI", String.valueOf(BBidealBorca));
                                        ed.putString("Beratbadan", "-" + String.valueOf(df.format(Beratbadan)));
                                        //ed.commit();
                                    }
                                    else if (lk.isChecked()){
                                        OlahragaDisarankan = KategoriUmur;
                                        MakananDisarankan = KategoriUmur;
                                        BBidealBorca = ((Tb-100)-(0.10 * (Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        ed.putString("BMI", String.valueOf(BBidealBorca));
                                        ed.putString("Beratbadan", "-" + String.valueOf(df.format(Beratbadan)));
//                                ed.commit();
                                    }

                                }

                                else {

                                    if (pr.isChecked()){
                                        BBidealBorca = ((Tb-100)-(0.15*(Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        ed.putString("Beratbadan", "-" + String.valueOf(df.format(Beratbadan)));
                                    }
                                    if (lk.isChecked()){
                                        BBidealBorca = ((Tb-100)-(0.10*(Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        ed.putString("Beratbadan", "-" + String.valueOf(df.format(Beratbadan)));
                                    }

                                    if (a.isChecked()){
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golA_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golAB_olahragalaki);
                                        }
                                        MakananDisarankan = getString(R.string.gemuk_golA);
                                        MenuSarapan1 = getString(R.string.golA_gemuk_sarapan1);MenuSiang1 = getString(R.string.golA_gemuk_siang1);MenuMalam1 = getString(R.string.golA_gemuk_malam1);
                                        MenuSarapan2= getString(R.string.golA_gemuk_sarapan2);MenuSiang2 = getString(R.string.golA_gemuk_siang2);MenuMalam2 = getString(R.string.golA_gemuk_malam2);
                                        MenuSarapan3= getString(R.string.golA_gemuk_sarapan3);MenuSiang3 = getString(R.string.golA_gemuk_siang3);MenuMalam3 = getString(R.string.golA_gemuk_malam3);
                                        MenuSarapan4=getString(R.string.golA_gemuk_sarapan4);MenuSiang4 = getString(R.string.golA_gemuk_siang4);MenuMalam4 = getString(R.string.golA_gemuk_malam4);
                                        MenuSarapan5 = getString(R.string.golA_gemuk_sarapan5);MenuSiang5 = getString(R.string.golA_gemuk_siang5);MenuMalam5 = getString(R.string.golA_gemuk_malam5);
                                    }
                                    else if (b.isChecked()){
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golB_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golB_olahragalaki);
                                        }
                                        MakananDisarankan= getString(R.string.gemuk_golB);
                                        MenuSarapan1 = getString(R.string.golB_gemuk_sarapan1);MenuSiang1 = getString(R.string.golB_gemuk_siang1);MenuMalam1 = getString(R.string.golB_gemuk_malam1);
                                        MenuSarapan2= getString(R.string.golB_gemuk_sarapan2);MenuSiang2 = getString(R.string.golB_gemuk_siang2);MenuMalam2 = getString(R.string.golB_gemuk_malam2);
                                        MenuSarapan3= getString(R.string.golB_gemuk_sarapan3);MenuSiang3 = getString(R.string.golB_gemuk_siang3);MenuMalam3 = getString(R.string.golB_gemuk_malam3);
                                        MenuSarapan4= getString(R.string.golB_gemuk_sarapan4);MenuSiang4 = getString(R.string.golB_gemuk_siang4);MenuMalam4 = getString(R.string.golB_gemuk_malam4);
                                        MenuSarapan5 = getString(R.string.golB_gemuk_sarapan5);MenuSiang5 = getString(R.string.golB_gemuk_siang5);MenuMalam5 = getString(R.string.golB_gemuk_malam5);
                                    }
                                    else if (o.isChecked()){
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golO_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golO_olahragalaki);
                                        }
                                        MakananDisarankan= getString(R.string.gemuk_golO);
                                        MenuSarapan1 =  getString(R.string.golO_sarapan1);MenuSiang1 = getString(R.string.golO_siang1);MenuMalam1 = getString(R.string.golO_malam1);
                                        MenuSarapan2= getString(R.string.golO_sarapan2);MenuSiang2 = getString(R.string.golO_siang2);MenuMalam2 = getString(R.string.golO_malam2);
                                        MenuSarapan3= getString(R.string.golO_sarapan3);MenuSiang3 = getString(R.string.golO_siang3);MenuMalam3 = getString(R.string.golO_malam3);
                                        MenuSarapan4= getString(R.string.golO_sarapan4);MenuSiang4 = getString(R.string.golO_siang4);MenuMalam4 = getString(R.string.golO_malam4);
                                        MenuSarapan5 = getString(R.string.golO_sarapan5);MenuSiang5 = getString(R.string.golO_siang5);MenuMalam5 = getString(R.string.golO_malam5);
                                    }
                                    else if (ab.isChecked()){
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golAB_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golAB_olahragalaki);
                                        }
                                        MakananDisarankan= getString(R.string.gemuk_golB);
                                        MenuSarapan1 = getString(R.string.golAB_sarapan1);MenuSiang1 = getString(R.string.golAB_siang1);MenuMalam1 = getString(R.string.golAB_malam1);
                                        MenuSarapan2= getString(R.string.golAB_sarapan2);MenuSiang2 = getString(R.string.golAB_siang2);MenuMalam2 = getString(R.string.golAB_malam2);
                                        MenuSarapan3= getString(R.string.golAB_sarapan3);MenuSiang3 = getString(R.string.golAB_siang3);MenuMalam3 = getString(R.string.golAB_malam3);
                                        MenuSarapan4= getString(R.string.golAB_sarapan4);MenuSiang4 = getString(R.string.golAB_siang4);MenuMalam4 = getString(R.string.golAB_malam4);
                                        MenuSarapan5 = getString(R.string.golAB_sarapan5);MenuSiang5 = getString(R.string.golAB_siang5);MenuMalam5 = getString(R.string.golAB_malam5);
                                    }
                                }
                            }

                            else if (BBIdeal>27){
                                HailDiagnosaBerat = getString(R.string.overweight);
                                ed.putInt("Status", 3);
                                ed.putInt("ProgresDiet", 2);
                                ed.putInt("Statusawal", 3);
                                if (usia<8){
                                    KategoriUmur = getString(R.string.kategoriumur);
                                    if (pr.isChecked()){
                                        OlahragaDisarankan = KategoriUmur;
                                        MakananDisarankan = KategoriUmur;
                                        BBidealBorca = ((Tb-100)-(0.15*(Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        ed.putString("Beratbadan", "");
                                    }
                                    else if (lk.isChecked()){
                                        OlahragaDisarankan = KategoriUmur;
                                        MakananDisarankan = KategoriUmur;
                                        BBidealBorca = ((Tb-100)-(0.10*(Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        ed.putString("Beratbadan", "");
                                    }
                                }
                                else{
                                    if (pr.isChecked()){
                                        BBidealBorca = ((Tb-100)-(0.15*(Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        ed.putString("BMI", String.valueOf(BBidealBorca));
                                        ed.putString("Beratbadan", "-" + String.valueOf(df.format(Beratbadan)));
                                    }
                                    if (lk.isChecked()){
                                        BBidealBorca = ((Tb-100)-(0.10*(Tb-100)));
                                        Beratbadan = Bb - BBidealBorca;
                                        ed.putString("BMI", String.valueOf(BBidealBorca));
                                        ed.putString("Beratbadan", "-" + String.valueOf(df.format(Beratbadan)));
                                    }
                                    if (a.isChecked()){
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golA_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golAB_olahragalaki);
                                        }
                                        MakananDisarankan = getString(R.string.gemuk_golA);
                                        MenuSarapan1 = getString(R.string.golA_gemuk_sarapan1);MenuSiang1 = getString(R.string.golA_gemuk_siang1);MenuMalam1 = getString(R.string.golA_gemuk_malam1);
                                        MenuSarapan2= getString(R.string.golA_gemuk_sarapan2);MenuSiang2 = getString(R.string.golA_gemuk_siang2);MenuMalam2 = getString(R.string.golA_gemuk_malam2);
                                        MenuSarapan3= getString(R.string.golA_gemuk_sarapan3);MenuSiang3 = getString(R.string.golA_gemuk_siang3);MenuMalam3 = getString(R.string.golA_gemuk_malam3);
                                        MenuSarapan4=getString(R.string.golA_gemuk_sarapan4);MenuSiang4 = getString(R.string.golA_gemuk_siang4);MenuMalam4 = getString(R.string.golA_gemuk_malam4);
                                        MenuSarapan5 = getString(R.string.golA_gemuk_sarapan5);MenuSiang5 = getString(R.string.golA_gemuk_siang5);MenuMalam5 = getString(R.string.golA_gemuk_malam5);
                                    }
                                    else if (b.isChecked()){
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golB_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golB_olahragalaki);
                                        }
                                        MakananDisarankan= getString(R.string.gemuk_golB);
                                        MenuSarapan1 = getString(R.string.golB_gemuk_sarapan1);MenuSiang1 = getString(R.string.golB_gemuk_siang1);MenuMalam1 = getString(R.string.golB_gemuk_malam1);
                                        MenuSarapan2= getString(R.string.golB_gemuk_sarapan2);MenuSiang2 = getString(R.string.golB_gemuk_siang2);MenuMalam2 = getString(R.string.golB_gemuk_malam2);
                                        MenuSarapan3= getString(R.string.golB_gemuk_sarapan3);MenuSiang3 = getString(R.string.golB_gemuk_siang3);MenuMalam3 = getString(R.string.golB_gemuk_malam3);
                                        MenuSarapan4= getString(R.string.golB_gemuk_sarapan4);MenuSiang4 = getString(R.string.golB_gemuk_siang4);MenuMalam4 = getString(R.string.golB_gemuk_malam4);
                                        MenuSarapan5 = getString(R.string.golB_gemuk_sarapan5);MenuSiang5 = getString(R.string.golB_gemuk_siang5);MenuMalam5 = getString(R.string.golB_gemuk_malam5);
                                    }
                                    else if (o.isChecked()){
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golO_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golO_olahragalaki);
                                        }
                                        MakananDisarankan= getString(R.string.gemuk_golO);
                                        MenuSarapan1 =  getString(R.string.golO_sarapan1);MenuSiang1 = getString(R.string.golO_siang1);MenuMalam1 = getString(R.string.golO_malam1);
                                        MenuSarapan2= getString(R.string.golO_sarapan2);MenuSiang2 = getString(R.string.golO_siang2);MenuMalam2 = getString(R.string.golO_malam2);
                                        MenuSarapan3= getString(R.string.golO_sarapan3);MenuSiang3 = getString(R.string.golO_siang3);MenuMalam3 = getString(R.string.golO_malam3);
                                        MenuSarapan4= getString(R.string.golO_sarapan4);MenuSiang4 = getString(R.string.golO_siang4);MenuMalam4 = getString(R.string.golO_malam4);
                                        MenuSarapan5 = getString(R.string.golO_sarapan5);MenuSiang5 = getString(R.string.golO_siang5);MenuMalam5 = getString(R.string.golO_malam5);
                                    }
                                    else if (ab.isChecked()){
                                        if (pr.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golAB_olahragaperempuan);
                                        }
                                        else if (lk.isChecked()){
                                            OlahragaDisarankan = getString(R.string.golAB_olahragalaki);
                                        }
                                        MakananDisarankan= getString(R.string.gemuk_golB);
                                        MenuSarapan1 = getString(R.string.golAB_sarapan1);MenuSiang1 = getString(R.string.golAB_siang1);MenuMalam1 = getString(R.string.golAB_malam1);
                                        MenuSarapan2= getString(R.string.golAB_sarapan2);MenuSiang2 = getString(R.string.golAB_siang2);MenuMalam2 = getString(R.string.golAB_malam2);
                                        MenuSarapan3= getString(R.string.golAB_sarapan3);MenuSiang3 = getString(R.string.golAB_siang3);MenuMalam3 = getString(R.string.golAB_malam3);
                                        MenuSarapan4= getString(R.string.golAB_sarapan4);MenuSiang4 = getString(R.string.golAB_siang4);MenuMalam4 = getString(R.string.golAB_malam4);
                                        MenuSarapan5 = getString(R.string.golAB_sarapan5);MenuSiang5 = getString(R.string.golAB_siang5);MenuMalam5 = getString(R.string.golAB_malam5);
                                    }
                                }

                            }

                            if (usia<8){
                                Pantangan="";
                                JenisPenyakit=getString(R.string.kategoriumur);
                            }

                            ed.putString("Olahraga", OlahragaDisarankan);
                            ed.putString("Makanan", MakananDisarankan);
                            ed.putString("DiagnosaBerat", HailDiagnosaBerat);
                            ed.putString("JenisPenyakit", JenisPenyakit);
                            ed.putString("Pantangan", Pantangan);
                            ed.putString("MenuSarapan1", MenuSarapan1);ed.putString("MenuSarapan2", MenuSarapan2);ed.putString("MenuSarapan3", MenuSarapan3);ed.putString("MenuSarapan4", MenuSarapan4);ed.putString("MenuSarapan5", MenuSarapan5);
                            ed.putString("MenuSiang1", MenuSiang1);ed.putString("MenuSiang2", MenuSiang2);ed.putString("MenuSiang3", MenuSiang3);ed.putString("MenuSiang4", MenuSiang4);ed.putString("MenuSiang5", MenuSiang5);
                            ed.putString("MenuMalam1", MenuMalam1);ed.putString("MenuMalam2", MenuMalam2);ed.putString("MenuMalam3", MenuMalam3);ed.putString("MenuMalam4", MenuMalam4);ed.putString("MenuMalam5", MenuMalam5);
                            ed.commit();
                        }
                    }).start();


                }

            }
        });
        return rootView;
    }

    public boolean harusdiisi(EditText editText){
        String Umur = umur.getText().toString().trim();
        String Tinggi = tinggi.getText().toString().trim();
        String Berat = berat.getText().toString().trim();
        umur.setError(null);
        tinggi.setError(null);
        berat.setError(null);

        if (Umur.length()==0){
            umur.setError(Html.fromHtml("<font color='red'>Umur tidak boleh kosong</font>"));
            //Toast.makeText(getActivity(), "umur Harus di isi", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if (Tinggi.length()==0){
            tinggi.setError(Html.fromHtml("<font color='red'>Tinggi tidak boleh kosong</font>"));
            //Toast.makeText(getActivity(), "Tinggi Badan Harus di isi", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (Berat.length()==0){
            berat.setError(Html.fromHtml("<font color='red'>Berat tidak boleh kosong</font>"));
            //Toast.makeText(getActivity(), "Berat Badan Harus di isi", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
