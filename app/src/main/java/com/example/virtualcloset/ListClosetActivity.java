package com.example.virtualcloset;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.virtualcloset.ListClosetTabs.BottomsTabFragment;
import com.example.virtualcloset.ListClosetTabs.PagerAdapter;
import com.example.virtualcloset.ListClosetTabs.ShoesTabFragment;
import com.example.virtualcloset.ListClosetTabs.TopsTabFragment;

public class ListClosetActivity extends AppCompatActivity implements BottomsTabFragment.OnFragmentInteractionListener,
        TopsTabFragment.OnFragmentInteractionListener, ShoesTabFragment.OnFragmentInteractionListener {

    private Closet closet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_closet);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Tops"));
        tabLayout.addTab(tabLayout.newTab().setText("Bottoms"));
        tabLayout.addTab(tabLayout.newTab().setText("Shoes"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        closet = (Closet) getIntent().getSerializableExtra("closet");

        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), closet);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
