package com.example.virtualcloset;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CollectionsActivity extends AppCompatActivity implements FavoritesTabFragment.OnFragmentInteractionListener,
        SpringTabFragment.OnFragmentInteractionListener, SummerTabFragment.OnFragmentInteractionListener,
        FallTabFragment.OnFragmentInteractionListener, WinterTabFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);

        TabLayout collectionsTabLayout = (TabLayout) findViewById(R.id.collectionstablayout);
        collectionsTabLayout.addTab(collectionsTabLayout.newTab().setText("Favorites"));
        collectionsTabLayout.addTab(collectionsTabLayout.newTab().setText("Spring"));
        collectionsTabLayout.addTab(collectionsTabLayout.newTab().setText("Summer"));
        collectionsTabLayout.addTab(collectionsTabLayout.newTab().setText("Fall"));
        collectionsTabLayout.addTab(collectionsTabLayout.newTab().setText("Winter"));
        collectionsTabLayout.setTabGravity(collectionsTabLayout.GRAVITY_CENTER);
        collectionsTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        final ViewPager collectionsViewPager = (ViewPager) findViewById(R.id.collections_pager);
        final CollectionsPagerAdapter collectionsAdapter = new CollectionsPagerAdapter(getSupportFragmentManager(), collectionsTabLayout.getTabCount());
        collectionsViewPager.setAdapter(collectionsAdapter);
        collectionsViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(collectionsTabLayout));

        collectionsTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                collectionsViewPager.setCurrentItem(tab.getPosition());
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
