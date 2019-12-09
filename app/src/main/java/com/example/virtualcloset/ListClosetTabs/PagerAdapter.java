package com.example.virtualcloset.ListClosetTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.virtualcloset.Closet;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numTabs;
    Closet closet;
    Bundle bundle;

    public PagerAdapter(FragmentManager fm, int numTabs, Closet closet) {
        super(fm);
        this.numTabs = numTabs;
        this.closet = closet;
        bundle = new Bundle();
        bundle.putSerializable("closet", closet);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                TopsTabFragment topsTab = new TopsTabFragment();
                topsTab.setArguments(bundle);
                return topsTab;
            case 1:
                BottomsTabFragment bottomsTab = new BottomsTabFragment();
                bottomsTab.setArguments(bundle);
                return bottomsTab;
            case 2:
                ShoesTabFragment shoesTab = new ShoesTabFragment();
                shoesTab.setArguments(bundle);
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
