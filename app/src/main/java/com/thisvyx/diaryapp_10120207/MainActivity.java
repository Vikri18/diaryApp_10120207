
/**
 * NIM : 10120207
 * Nama : Vikri Frediansyah
 * Kelas : IF-5
 */

package com.thisvyx.diaryapp_10120207;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.thisvyx.diaryapp_10120207.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ViewPager2 pagerMain; // viewpager
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi
        pagerMain = findViewById(R.id.pagerMain);
        bottomNav = findViewById(R.id.bottomNavigationView);

        fragmentArrayList.add(new ProfileFragment());
        fragmentArrayList.add(new MenuFragment());
        fragmentArrayList.add(new InfoFragment());

        VpAdapter adapterViewPager = new VpAdapter(this,fragmentArrayList);
        //set adapter
        pagerMain.setAdapter(adapterViewPager);
        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNav.setSelectedItemId(R.id.person);
                        break;
                    case 1:
                        bottomNav.setSelectedItemId(R.id.menu);
                        break;
                    case 2:
                        bottomNav.setSelectedItemId(R.id.info);
                        break;
                }

                super.onPageSelected(position);
            }
        });

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.person:
                        pagerMain.setCurrentItem(0);
                        break;
                    case R.id.menu:
                        pagerMain.setCurrentItem(1);
                        break;
                    case R.id.info:
                        pagerMain.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }//end on create

}