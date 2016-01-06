package com.example.ilhamsabar.cobadiet;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ilham sabar on 10/25/2015.
 */

public class TipsDietFragment extends Fragment {
    TextView  Out;
    EditText BB, TB;
    String Hasil;

    public TipsDietFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kalkulator, container, false);
        TB = (EditText) rootView.findViewById(R.id.tb);
        BB = (EditText) rootView.findViewById(R.id.bb);
        Out = (TextView) rootView.findViewById(R.id.hasilbb);

        TB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                harusdiisi(TB);
            }
        });

        BB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                harusdiisi(BB);
            }
        });

        Button proses = (Button) rootView.findViewById(R.id.Proses);

        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TB.getText().toString().trim().length()==0){
                    Toast.makeText(getActivity(), "Tinggi Badan belum di isi", Toast.LENGTH_LONG).show();
                }
                else if (BB.getText().toString().trim().length()==0){
                    Toast.makeText(getActivity(), "Berat Badan belum di isi", Toast.LENGTH_LONG).show();
                }
                else {
                    Double Tb = Double.parseDouble(TB.getText().toString());
                    Double Bb = Double.parseDouble(BB.getText().toString());
                    Double hTb = Tb / 100;
                    Double BBIdeal;
                    BBIdeal = (Bb / (hTb*hTb));

                    if (BBIdeal<18){
                        Out.setText("Under Weight/Kurus – Sebaiknya mulai menambah berat badan dan mengkonsumsi makanan berkarbohidrat di imbangi dengan olah raga");
                    }
                    else if (BBIdeal>18 && BBIdeal<25){
                        Out.setText("Normal Weight/Normal – Bagus, berat badan anda termasuk kategori ideal");
                    }
                    else if (BBIdeal>25 && BBIdeal<27){
                        Out.setText("Over Weight/Kegemukan – anda sudah masuk kategori gemuk. sebaiknya hindari makanan berlemak dan mulailah meningkatkan olahraga seminggu minimal 2 kali");
                    }
                    else if (BBIdeal>27){
                        Out.setText("Obesitas – Sebaiknya segera membuat program menurunkan berat badan karena anda termasuk kategori obesitas/ terlalu gemuk dan tidak baik bagi kesehatan");
                    }
                }

            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    public boolean harusdiisi(EditText editText){
        String Tinggi = TB.getText().toString().trim();
        String Berat = BB.getText().toString().trim();
        TB.setError(null);
        BB.setError(null);
        if (Tinggi.length()==0){
            TB.setError(Html.fromHtml("<font color='red'>Tinggi tidak boleh kosong</font>"));
            //Toast.makeText(getActivity(), "umur Harus di isi", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if (Berat.length()==0){
            BB.setError(Html.fromHtml("<font color='red'>Berat tidak boleh kosong</font>"));
            //Toast.makeText(getActivity(), "Tinggi Badan Harus di isi", Toast.LENGTH_SHORT).show();
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