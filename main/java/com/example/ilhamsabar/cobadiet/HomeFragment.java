package com.example.ilhamsabar.cobadiet;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
        Hasil = (TextView) rootView.findViewById(R.id.output);
        Olahraga = (TextView) rootView.findViewById(R.id.olahraga);
        Kategoribb = (TextView) rootView.findViewById(R.id.kategoribb);

        olahraga = (ImageView) rootView.findViewById(R.id.olahragaimage);
        makan = (ImageView) rootView.findViewById(R.id.makanan);
        imgkategoribb = (ImageView) rootView.findViewById(R.id.imgkategoribb);
        jdlkategoribb = (TextView) rootView.findViewById(R.id.jdlkategoribb);
        makandisarankan = (TextView) rootView.findViewById(R.id.makandisarankan);
        olahragadisarankan = (TextView) rootView.findViewById(R.id.olahragadisarankan);
        foother = (TextView) rootView.findViewById(R.id.foother);

        olahraga.setVisibility(View.GONE);
        makan.setVisibility(View.GONE);
        imgkategoribb.setVisibility(View.GONE);
        jdlkategoribb.setVisibility(View.GONE);
        makandisarankan.setVisibility(View.GONE);
        olahragadisarankan.setVisibility(View.GONE);
        foother.setVisibility(View.GONE);



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
                    Double Tb = Double.parseDouble(tinggi.getText().toString());
                    Double Bb = Double.parseDouble(berat.getText().toString());
                    Integer usia = Integer.parseInt(umur.getText().toString());

                    Double hTb = Tb / 100;
                    Double BBIdeal;
                    BBIdeal = (Bb / (hTb*hTb));
                    String HailDiagnosaBerat ="";
                    String OlahragaDisarankan="";
                    String MakananDisarankan="";
                    String KategoriUmur = "";
                    String MetodedietDisarankan="" ;

                    if (BBIdeal<18){
                        HailDiagnosaBerat ="Under Weight/Kurus – Sebaiknya mulai menambah berat badan dan mengkonsumsi makanan berkarbohidrat di imbangi dengan olah raga";
                        if (usia < 8){
                            MakananDisarankan ="Kategori Usia Tidak Disarankan";
                            if (pr.isChecked()){
                                OlahragaDisarankan = "permainan outdor ";
                            }
                            else if (lk.isChecked()){
                                OlahragaDisarankan = "Permainan Outdor, Lari Lari Kecil";
                            }

                        }
                        else if (usia>8){
                            MakananDisarankan ="Perbanyak Mengkonsumsi makanan berkarbonhidrat dan tinggi protein, Minuman suplemen yang disarankan :sus beruang ";
                            OlahragaDisarankan = "Permainan Outdor, Lari Lari Kecil";

                        }
                    }

                    else if (BBIdeal>18 && BBIdeal<25){
                        HailDiagnosaBerat = "Normal Weight/Normal – Bagus, berat badan anda termasuk kategori ideal ";
                        OlahragaDisarankan = "Pertahankan Olahraga Teratur";
                        MakananDisarankan = "Anda Tidak di sarankan melakukan diet, Pertahankan Pola Makan anda";
                    }



                    else if (BBIdeal>25 && BBIdeal<27){
                        HailDiagnosaBerat = "Over Weight/Kegemukan – anda sudah masuk kategori gemuk. sebaiknya hindari makanan berlemak dan mulailah meningkatkan olahraga seminggu minimal 2 kali";
                        if (usia<8){
                            KategoriUmur ="Kategori Usia Tidak Disarankan";
                            if (pr.isChecked()){
                                OlahragaDisarankan = KategoriUmur;
                                MakananDisarankan = KategoriUmur;
                            }
                            else if (lk.isChecked()){
                                OlahragaDisarankan = KategoriUmur;
                                MakananDisarankan = KategoriUmur;
                            }
                        }

                        else if (usia>12 && usia<16){
                            if (a.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : Fitnes, Yoga, Senam, Tai Chi, Berjalan Cepat, dan Aktivitas Outdor Minimal 30 Menit/Hari";
                                MakananDisarankan = "Makanan dan Sayuran Yang Disarankan : ikan tuna, telur, roti gandum, kurma dan daging ayam";
                            }
                            else if (b.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : dance, balet dan Senam";
                                MakananDisarankan="Makanan dan Sayuran Yang Disarankan : aneka ikan laut, olahan susu seperti keju dan yoghurt, brokoli, wortel, dan terong";
                            }
                            else if (o.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : jogging, bersepeda, atau berenang";
                                MakananDisarankan="Makanan dan Sayuuran Yang Disarankan : sayuran hijau, makanan dengan kadar protein hewani yang tinggi, dan seafood. \n Makanan Yang Dihindari : sayuran seperti misalnya terong, kentang, jamur, dan tauge atau jenis sayuran yang mengandung banyak lektin.";
                            }
                            else if (ab.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : jogging, bersepeda, atau berenang";
                                MakananDisarankan="Makanan dan Sayuuran Yang Disarankan : perbanyak mengkonsumsi susu kambing, ikan tuna, krim asam rendah kalori, dan buah anggur merah. \n Makanan dan Minuman Yang Dihindari : telur bebek, kepiting, buah pisang, dan air soda";
                            }
                        }

                        else {
                            if (a.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : Fitnes, Yoga, Senam, Tai Chi, Berjalan Cepat, dan Aktivitas Outdor Minimal 30 Menit/Hari";
                                MakananDisarankan = "Makanan dan Sayuran Yang Disarankan : ikan tuna, telur, roti gandum, kurma dan daging ayam";
                            }
                            else if (b.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : dance, balet dan Senam";
                                MakananDisarankan="Makanan dan Sayuran Yang Disarankan : aneka ikan laut, olahan susu seperti keju dan yoghurt, brokoli, wortel, dan terong";
                            }
                            else if (o.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : jogging, bersepeda, atau berenang";
                                MakananDisarankan="Makanan dan Sayuuran Yang Disarankan : sayuran hijau, makanan dengan kadar protein hewani yang tinggi, dan seafood. \n Makanan Yang Dihindari : sayuran seperti misalnya terong, kentang, jamur, dan tauge atau jenis sayuran yang mengandung banyak lektin.";
                            }
                            else if (ab.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : jogging, bersepeda, atau berenang";
                                MakananDisarankan="Makanan dan Sayuuran Yang Disarankan : perbanyak mengkonsumsi susu kambing, ikan tuna, krim asam rendah kalori, dan buah anggur merah. \n Makanan dan Minuman Yang Dihindari : telur bebek, kepiting, buah pisang, dan air soda";
                            }
                        }
                    }

                    else if (BBIdeal>27){
                        HailDiagnosaBerat = "Obesitas – Sebaiknya segera membuat program menurunkan berat badan karena anda termasuk kategori obesitas/ terlalu gemuk dan tidak baik bagi kesehatan";
                        if (usia<8){
                            KategoriUmur ="Kategori Usia Tidak Disarankan";
                            if (pr.isChecked()){
                                OlahragaDisarankan = KategoriUmur;
                                MakananDisarankan = KategoriUmur;
                            }
                            else if (lk.isChecked()){
                                OlahragaDisarankan = KategoriUmur;
                                MakananDisarankan = KategoriUmur;
                            }

                        }
                        else if (usia>12 && usia<16){
                            if (a.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : Fitnes, Yoga, Senam, Tai Chi, Berjalan Cepat, dan Aktivitas Outdor Minimal 30 Menit/Hari";
                                MakananDisarankan = "Makanan dan Sayuran Yang Disarankan : ikan tuna, telur, roti gandum, kurma dan daging ayam";
                            }
                            else if (b.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : dance, balet dan Senam";
                                MakananDisarankan="Makanan dan Sayuran Yang Disarankan : aneka ikan laut, olahan susu seperti keju dan yoghurt, brokoli, wortel, dan terong";
                            }
                            else if (o.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : jogging, bersepeda, atau berenang";
                                MakananDisarankan="Makanan dan Sayuuran Yang Disarankan : sayuran hijau, makanan dengan kadar protein hewani yang tinggi, dan seafood. \n Makanan Yang Dihindari : sayuran seperti misalnya terong, kentang, jamur, dan tauge atau jenis sayuran yang mengandung banyak lektin.";
                            }
                            else if (ab.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : jogging, bersepeda, atau berenang";
                                MakananDisarankan="Makanan dan Sayuuran Yang Disarankan : perbanyak mengkonsumsi susu kambing, ikan tuna, krim asam rendah kalori, dan buah anggur merah. \n Makanan dan Minuman Yang Dihindari : telur bebek, kepiting, buah pisang, dan air soda";
                            }
                        }

                        else {
                            if (a.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : Fitnes, Yoga, Senam, Tai Chi, Berjalan Cepat, dan Aktivitas Outdor Minimal 30 Menit/Hari";
                                MakananDisarankan = "Makanan dan Sayuran Yang Disarankan : ikan tuna, telur, roti gandum, kurma dan daging ayam";
                            }
                            else if (b.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : dance, balet dan Senam";
                                MakananDisarankan="Makanan dan Sayuran Yang Disarankan : aneka ikan laut, olahan susu seperti keju dan yoghurt, brokoli, wortel, dan terong";
                            }
                            else if (o.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : jogging, bersepeda, atau berenang";
                                MakananDisarankan="Makanan dan Sayuuran Yang Disarankan : sayuran hijau, makanan dengan kadar protein hewani yang tinggi, dan seafood. \n Makanan Yang Dihindari : sayuran seperti misalnya terong, kentang, jamur, dan tauge atau jenis sayuran yang mengandung banyak lektin.";
                            }
                            else if (ab.isChecked()){
                                OlahragaDisarankan = "Olahraga Yang Disarankan : jogging, bersepeda, atau berenang";
                                MakananDisarankan="Makanan dan Sayuuran Yang Disarankan : perbanyak mengkonsumsi susu kambing, ikan tuna, krim asam rendah kalori, dan buah anggur merah. \n Makanan dan Minuman Yang Dihindari : telur bebek, kepiting, buah pisang, dan air soda";
                            }
                        }
                    }

                    olahraga.setVisibility(View.VISIBLE);
                    makan.setVisibility(View.VISIBLE);
                    imgkategoribb.setVisibility(View.VISIBLE);
                    jdlkategoribb.setVisibility(View.VISIBLE);
                    makandisarankan.setVisibility(View.VISIBLE);
                    olahragadisarankan.setVisibility(View.VISIBLE);
                    foother.setVisibility(View.VISIBLE);

                    Hasil.setText(MakananDisarankan);
                    Olahraga.setText(OlahragaDisarankan);
                    Kategoribb.setText(HailDiagnosaBerat);

                    olahraga.setImageResource(R.drawable.lari);
                    makan.setImageResource(R.drawable.makanan);
                    imgkategoribb.setImageResource(R.drawable.weight);

                    jdlkategoribb.setText("Kategori Berat Badan");
                    jdlkategoribb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    olahragadisarankan.setText("Olahraga Disarankan");
                    olahragadisarankan.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    makandisarankan.setText("Makanan Disarankan");
                    makandisarankan.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    foother.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }

            }
        });
        //String beratbadan = (bb.getText()).toString();

        // Inflate the layout for this fragment
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
//        else if (Umur.length()==0&&Tinggi.length()==0&&Berat.length()==0){
//            umur.setError(Html.fromHtml("<font color='red'>Berat tidak boleh kosong</font>"));
//        }
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
