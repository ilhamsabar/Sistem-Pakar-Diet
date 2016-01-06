package com.example.ilhamsabar.cobadiet;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ilham sabar on 11/15/2015.
 */
public class LayoutOcd extends Fragment {
    DBHelperAtkins dbHelper;
    PeraturanOCD peraturanOCD;
    protected Cursor cursor;

    public LayoutOcd(){

    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ocd,container,false);
        TextView Puasa16 = (TextView) v.findViewById(R.id.puasa16);
        TextView Puasa18 = (TextView) v.findViewById(R.id.puasa18);
        TextView Puasa20 = (TextView) v.findViewById(R.id.puasa20);
        TextView Puasa24 = (TextView) v.findViewById(R.id.puasa24);
//        DBHelperOcd db = new DBHelperOcd(getActivity().getApplicationContext());
//        try {
//            db.CreateDataBase();
//            Toast.makeText(getActivity(), "db berhasil dibuat", Toast.LENGTH_LONG).show();
//        }catch (IOException ioe){
//            throw new Error("Tidak dapat membuat database");
//        }
        dbHelper = new DBHelperAtkins(this.getActivity());
        dbHelper.openDataBase();
        peraturanOCD = new PeraturanOCD();
        peraturanOCD = dbHelper.Get_peraturan();
        Puasa16.setText(peraturanOCD.getPuasa16());
        Puasa18.setText(peraturanOCD.getPuasa18());
        Puasa20.setText(peraturanOCD.getPuasa20());
        Puasa24.setText(peraturanOCD.getPuasa24());

//        if (db.open()) {
//            //Toast.makeText(getActivity(), " berhasil mengambil database", Toast.LENGTH_SHORT).show();
//            List<PeraturanOCD> peraturans_OCD = db.getPeraturansOCD();
//
//            for (int x=0; x< peraturans_OCD.size(); x++) {
//                String PUASA16 = peraturans_OCD.get(x).puasa16;
//                String PUASA18 = peraturans_OCD.get(x).puasa18;
//                String PUASA20 = peraturans_OCD.get(x).puasa20;
//                String PUASA24 = peraturans_OCD.get(x).puasa24;
//                p16 = p16  + "Aturan : " + PUASA16 + "\n";
//                p18 = p18  + "Aturan : " + PUASA18 + "\n";
//                p20 = p20  + "Aturan : " + PUASA20 + "\n";
//                p24 = p24  + "Aturan : " + PUASA24 + "\n";
//            }
//        }
//        else {
//            Toast.makeText(getActivity(), "Eror membuka database", Toast.LENGTH_SHORT).show();
//        }


        return v;
    }
}
