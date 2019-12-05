package com.example.virtualcloset;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottom_nav = findViewById(R.id.bottom_navigation);
        bottom_nav.setOnNavigationItemSelectedListener(navListener);
        if(savedInstanceState == null) {
            bottom_nav.setSelectedItemId(R.id.nav_home);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_closet:
                            selectedFragment = new ClosetFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}