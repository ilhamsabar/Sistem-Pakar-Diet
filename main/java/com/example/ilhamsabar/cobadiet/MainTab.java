package com.example.ilhamsabar.cobadiet;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ilham sabar on 2/18/2016.
 */
public class MainTab extends Fragment {
    public MainTab(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.maintab, container, false);

  //      Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar1);
//        toolbar.setTitle("Material Tab");
 //       ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Monitoring Harian"));
        tabLayout.addTab(tabLayout.newTab().setText("Diagnosa Anda"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        final TabPagerAdapter adapter = new TabPagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return rootView;
    }
}
