package com.example.virtualcloset;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numTabs;
    public PagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                TopsTabFragment topsTab = new TopsTabFragment();
                return topsTab;
            case 1:
                BottomsTabFragment bottomsTab = new BottomsTabFragment();
                return bottomsTab;
            case 2:
                ShoesTabFragment shoesTab = new ShoesTabFragment();
                return shoesTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
