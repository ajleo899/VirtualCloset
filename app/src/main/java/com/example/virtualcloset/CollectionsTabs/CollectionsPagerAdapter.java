package com.example.virtualcloset.CollectionsTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.virtualcloset.Closet;

public class CollectionsPagerAdapter extends FragmentStatePagerAdapter {

    Closet closet;
    int numTabs;
    Bundle bundle;

    public CollectionsPagerAdapter(FragmentManager fm, int numTabs, Closet closet) {
        super(fm);
        this.numTabs = numTabs;
        this.closet = closet;
        bundle = new Bundle();
        bundle.putSerializable("closet",closet);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                FavoritesTabFragment favoritesTab = new FavoritesTabFragment();
                favoritesTab.setArguments(bundle);
                return favoritesTab;
            case 1:
                SpringTabFragment springTab = new SpringTabFragment();
                springTab.setArguments(bundle);
                return springTab;
            case 2:
                SummerTabFragment summerTab = new SummerTabFragment();
                summerTab.setArguments(bundle);
                return summerTab;
            case 3:
                FallTabFragment fallTab = new FallTabFragment();
                fallTab.setArguments(bundle);
                return fallTab;
            case 4:
                WinterTabFragment winterTab = new WinterTabFragment();
                winterTab.setArguments(bundle);
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
