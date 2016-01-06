package com.example.ilhamsabar.cobadiet;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

/**
 * Created by ilham sabar on 10/25/2015.
 */

public class MetodeDietFragment extends Fragment {
    protected Cursor cursor;

    String[] diet = new String[] { "Diet Mayo","Diet OCD", "Diet Atkins", "Diet Food Combining", "Diet Golongan Darah", "Diet Paleo"};

    public MetodeDietFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_metode_diet, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listmetode);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1 , diet);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new LayoutMayo();
                        break;
                    case 1:
                        fragment = new LayoutOcd();
                        break;
                    case 2:
                        fragment = new LayoutAtkins();
                        break;
                    case 3:
                        fragment = new LayoutFood();
                        break;
                    case 4:
                        fragment = new LayoutGoldarah();
                        break;
                    default:
                        break;
                }

                if (fragment != null) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

            }
        });

        DBHelper db = new DBHelper(getActivity().getApplicationContext());

        try {
            db.CreateDataBase();
        }catch (IOException ioe){
            throw new Error("Tidak dapat membuat database");
        }

//        TextView h1isi = (TextView) rootView.findViewById(R.id.mayoH1);
//        TextView h2tisi = (TextView) rootView.findViewById(R.id.mayoH2);


        //String buffer = "";
        String h1 ="";
        String h2 ="";
        String j1 ="";

        if (db.open()){
            List<Peraturan> peraturans = db.getPeraturans();
            for (int x=0; x< peraturans.size(); x++){
                Integer ID = peraturans.get(x).id;
                String h1PAGI = peraturans.get(x).pagi;
                String h1SIANG = peraturans.get(x).siang;
                String h1MALAM = peraturans.get(x).malam;
                j1 = j1 + "Hari Ke-"+ID;
                h1 = h1  + "Menu Makan Pagi " + h1PAGI + "\n";
                h1 = h1  + "Menu Makan Siang " + h1SIANG + "\n";
                h1 = h1  + "Menu Makan Malam " + h1MALAM + "\n";
            }

// //               String ID = peraturans.get(x).id;
//                    String h1PAGI = peraturans.get(0).pagi;
//                    String h1SIANG = peraturans.get(0).siang;
//                    String h1MALAM = peraturans.get(0).malam;
//                    h1 = h1  + "Menu Makan Pagi " + h1PAGI + "\n";
//                    h1 = h1  + "Menu Makan Siang " + h1SIANG + "\n";
//                    h1 = h1  + "Menu Makan Malam " + h1MALAM + "\n";
//            String h2PAGI = peraturans.get(1).pagi;
//            String h2SIANG = peraturans.get(1).siang;
//            String h2MALAM = peraturans.get(1).malam;
//            h2 = h2  + "Menu Makan Pagi " + h2PAGI + "\n";
//            h2 = h2  + "Menu Makan Siang " + h2SIANG + "\n";
//            h2 = h2  + "Menu Makan Malam " + h2MALAM + "\n";






        }
        else {
            Toast.makeText(getActivity(), "Eror membuka database", Toast.LENGTH_SHORT).show();
        }
//        h1isi.setText(h1);
//        h2tisi.setText(j1);


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static void onBackPressed()
    {

    }
}