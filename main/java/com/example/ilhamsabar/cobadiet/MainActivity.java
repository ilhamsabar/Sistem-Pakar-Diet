package com.example.ilhamsabar.cobadiet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

        private Toolbar mToolbar;
        private FragmentDrawer drawerFragment;
        EditText ilham;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                mToolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(mToolbar);
                getSupportActionBar().setDisplayShowHomeEnabled(true);

//                SharedPreferences sp = getSharedPreferences("datadiet", Context.MODE_PRIVATE);
//                SharedPreferences.Editor ed = sp.edit();

                drawerFragment = (FragmentDrawer)
                        getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
                drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
                drawerFragment.setDrawerListener(this);

                displayView(0);
        }



//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//                // Inflate the menu; this adds items to the action bar if it is present.
//                getMenuInflater().inflate(R.menu.menu_main, menu);
//                return true;
//        }
//
//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//                // Handle action bar item clicks here. The action bar will
//                // automatically handle clicks on the Home/Up button, so long
//                // as you specify a parent activity in AndroidManifest.xml.
//                int id = item.getItemId();
//
//                //noinspection SimplifiableIfStatement
////                if (id == R.id.action_settings) {
////                        return true;
////                }
//
//                return super.onOptionsItemSelected(item);
//        }

        @Override
        public void onDrawerItemSelected(View view, int position) {
                displayView(position);
        }

        private void displayView(int position) {
                Fragment fragment = null;
                String title = getString(R.string.app_name);
                switch (position) {
                        case 0:
                                fragment = new HomeFragment();
                                title = "Diagnosa";
                                break;
                        case 1:
                                fragment = new MainTab();
                                title = "Diagnosa dan Monitoring";
                                break;
                        case 2:
                                fragment = new MetodeDietFragment();
                                title = "Metode Diet";
                                break;
                        case 3:
                                fragment = new TipsDietFragment();
                                title = "Kalkulator BMI";
                                break;
                        case 4:
                                fragment = new AboutFragment();
                                title = "Tentang";
                                break;
                        default:
                                break;
                }

                if (fragment != null) {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_body, fragment);
                        fragmentTransaction.commit();
                        // set the toolbar title
                        getSupportActionBar().setTitle(title);
                }
        }
}