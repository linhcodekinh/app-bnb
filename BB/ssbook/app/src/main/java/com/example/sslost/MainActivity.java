package com.example.sslost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.sslost.Fragment.FragmentCategory;
import com.example.sslost.Fragment.FragmentHome;
import com.example.sslost.Fragment.FragmentLibrary;
import com.example.sslost.Fragment.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    final Fragment fragment1 = FragmentHome.newInstance();
    final Fragment fragment2 = FragmentCategory.newInstance();
    final Fragment fragment3 = FragmentLibrary.newInstance();
    final Fragment fragment4 = FragmentProfile.newInstance();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm.beginTransaction().add(R.id.fl_fragment_container, fragment4, "4").hide(fragment4).commit();
        fm.beginTransaction().add(R.id.fl_fragment_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.fl_fragment_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.fl_fragment_container, fragment1, "1").commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNav_Bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ll_tab_home:
                        fm.beginTransaction().hide(active).show(fragment1).commit();
                        active = fragment1;
                        return true;
                    case R.id.ll_tab_category:
                        fm.beginTransaction().hide(active).show(fragment2).commit();
                        active = fragment2;
                        return true;
                    case R.id.ll_tab_library:
                        fm.beginTransaction().hide(active).show(fragment3).commit();
                        active = fragment3;
                        return true;
                    case R.id.ll_tab_profile:
                        fm.beginTransaction().hide(active).show(fragment4).commit();
                        active = fragment4;
                        return true;
                }
                item.setChecked(true);
                return false;
            }
        });
    }
}
