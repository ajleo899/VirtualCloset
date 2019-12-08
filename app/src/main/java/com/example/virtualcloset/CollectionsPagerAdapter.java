package com.example.virtualcloset;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CollectionsPagerAdapter extends FragmentStatePagerAdapter {

    int numTabs;
    public CollectionsPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                FavoritesTabFragment favoritesTab = new FavoritesTabFragment();
                return favoritesTab;
            case 1:
                SpringTabFragment springTab = new SpringTabFragment();
                return springTab;
            case 2:
                SummerTabFragment summerTab = new SummerTabFragment();
                return summerTab;
            case 3:
                FallTabFragment fallTab = new FallTabFragment();
                return fallTab;
            case 4:
                WinterTabFragment winterTab = new WinterTabFragment();
                return winterTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
