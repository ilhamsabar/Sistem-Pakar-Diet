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
public class LayoutFood extends Fragment {

    DBHelperAtkins dbHelper;
    PeraturanFood peraturanFood;
    protected Cursor cursor;
    TextView Sarapan, Makansiang, Makansore, Makanmalam;
    String sarapan, makansiang, makanmalam;

    public LayoutFood(){

    }

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_food, container, false);
        Sarapan = (TextView) rootView.findViewById(R.id.sarapan);
        Makansiang = (TextView) rootView.findViewById(R.id.makansiang);
        Makansore = (TextView) rootView.findViewById(R.id.makansore);
        Makanmalam = (TextView) rootView.findViewById(R.id.makanmalam);

        dbHelper = new DBHelperAtkins(this.getActivity());
        dbHelper.openDataBase();
        peraturanFood = new PeraturanFood();
        peraturanFood = dbHelper.Get_peraturanFood();
        Sarapan.setText(peraturanFood.getSarapan());
        Makansiang.setText(peraturanFood.getMakansiang());
        Makanmalam.setText(peraturanFood.getMakanmalam());
        Makansore.setText(peraturanFood.getMakansore());

        return rootView;
    }

}
