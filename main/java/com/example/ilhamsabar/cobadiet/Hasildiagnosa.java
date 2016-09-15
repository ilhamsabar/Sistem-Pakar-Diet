package com.example.ilhamsabar.cobadiet;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ilham sabar on 2/10/2016.
 */
public class Hasildiagnosa extends Fragment {

    TextView jenispenyakit, kategoribb, pantangan, makan, olahraga,bb;
    public Hasildiagnosa(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.hasildiagnosa, container, false);

        jenispenyakit = (TextView) rootView.findViewById(R.id.jenispenyakit);
        kategoribb = (TextView) rootView.findViewById(R.id.kategoribb);
        pantangan = (TextView) rootView.findViewById(R.id.pantangan);
        makan = (TextView) rootView.findViewById(R.id.makanan);
        olahraga = (TextView) rootView.findViewById(R.id.olahraga);
        //bb = (TextView) rootView.findViewById(R.id.Bbku);

        SharedPreferences sp = getActivity().getSharedPreferences("datadiet", Context.MODE_PRIVATE);
        String Olahraga =  sp.getString("Olahraga", "");
        String Kategoribb = sp.getString("DiagnosaBerat","");
        String MakananDisarankan = sp.getString("Makanan", "");
        String JenisPenyakit = sp.getString("JenisPenyakit", "");
        String Pantangan = sp.getString("Pantangan","");
        String BB = sp.getString("Beratbadan","");
        makan.setText(MakananDisarankan);
        olahraga.setText(Olahraga);
        kategoribb.setText(Kategoribb);
        jenispenyakit.setText(JenisPenyakit);
        pantangan.setText(Pantangan);
        //bb.setText(BB);

//        ed.putString("Olahraga", OlahragaDisarankan);
//        ed.putString("Makanan", MakananDisarankan);
//        ed.putString("DiagnosaBerat", HailDiagnosaBerat);
//        ed.putString("JenisPenyakit", JenisPenyakit);
//        ed.putString("Pantangan", Pantangan);
        return rootView;
    }
}
