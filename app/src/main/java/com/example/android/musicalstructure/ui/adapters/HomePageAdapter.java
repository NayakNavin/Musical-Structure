package com.example.android.musicalstructure.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.musicalstructure.ui.fragments.AlbumsFragment;
import com.example.android.musicalstructure.ui.fragments.ArtistsFragment;

public class HomePageAdapter extends FragmentPagerAdapter {

    public static final int M_FRAG_COUNT = 2;
    private String[] pageTitles;

    public HomePageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setPageTitles(String[] pageTitles) {
        this.pageTitles = pageTitles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AlbumsFragment.newInstance();
            case 1:
                return ArtistsFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return M_FRAG_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.pageTitles[position];
    }
}