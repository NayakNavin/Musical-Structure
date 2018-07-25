package com.example.android.musicalstructure.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.android.musicalstructure.R;
import com.example.android.musicalstructure.ui.adapters.HomePageAdapter;
import com.example.android.musicalstructure.ui.fragments.AlbumsFragment;
import com.example.android.musicalstructure.ui.fragments.ArtistsFragment;
import com.example.android.musicalstructure.ui.models.Album;
import com.example.android.musicalstructure.ui.models.Artist;

public class HomeActivity extends AppCompatActivity implements ArtistsFragment.OnArtistSelectedListener, AlbumsFragment.OnAlbumSelectedListener {

    public static final String SELECTED_ALBUM = "SELECTED_ALBUM";
    public static final String SELECTED_ARTIST = "SELECTED_ARTIST";

    private ViewPager viewPager;
    private HomePageAdapter homePageAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // To remove the shadow
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }
        actionBar.setDisplayHomeAsUpEnabled(false);

        // Create the tabs
        homePageAdapter = new HomePageAdapter(getSupportFragmentManager());
        homePageAdapter.setPageTitles(initPagesTitles());

        viewPager = findViewById(R.id.container);
        viewPager.setAdapter(homePageAdapter);

        tabLayout = findViewById(R.id.homePageTabs);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabTextColors(getResources().getColor(R.color.white), getResources().getColor(R.color.colorAccent));
        tabLayout.setupWithViewPager(viewPager);
    }

    private String[] initPagesTitles() {
        String[] pageTitles = new String[HomePageAdapter.M_FRAG_COUNT];
        pageTitles[0] = getResources().getString(R.string.albums);
        pageTitles[1] = getResources().getString(R.string.artists);
        return pageTitles;
    }

    @Override
    public void onAlbumSelected(Album album) {
        Intent playActivity = new Intent(HomeActivity.this, NowPlayingActivity.class);
        playActivity.putExtra(SELECTED_ALBUM, album);
        startActivity(playActivity);
    }

    public void onArtistSelected(Artist artist) {
        Intent playActivity = new Intent(HomeActivity.this, NowPlayingActivity.class);
        playActivity.putExtra(SELECTED_ARTIST, artist);
        startActivity(playActivity);
    }
}