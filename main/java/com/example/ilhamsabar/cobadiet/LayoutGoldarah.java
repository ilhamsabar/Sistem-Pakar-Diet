package com.example.ilhamsabar.cobadiet;

import android.support.v4.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ilham sabar on 11/21/2015.
 */
public class LayoutGoldarah extends Fragment {
    DBHelperAtkins dbHelper;
    PeraturanGoldarah peraturanGoldarah;
    protected Cursor cursor;
    TextView Gola, Golb, Golo, Golab;


    public LayoutGoldarah(){

    }

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_goldarah, container, false);
        Gola = (TextView) rootView.findViewById(R.id.golA);
        Golb = (TextView) rootView.findViewById(R.id.golB);
        Golo = (TextView) rootView.findViewById(R.id.golO);
        Golab = (TextView) rootView.findViewById(R.id.golAB);

        dbHelper = new DBHelperAtkins(this.getActivity());
        dbHelper.openDataBase();
        peraturanGoldarah = new PeraturanGoldarah();
        peraturanGoldarah = dbHelper.Get_peraturanGoldarah();

        Gola.setText(peraturanGoldarah.getGola());
        Golb.setText(peraturanGoldarah.getGolb());
        Golo.setText(peraturanGoldarah.getGolo());
        Golab.setText(peraturanGoldarah.getGolab());


        return rootView;
    }
}
