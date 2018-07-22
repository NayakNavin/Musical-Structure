package com.example.android.musicalstructure.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.android.musicalstructure.R;

public class NowPlayingActivity extends AppCompatActivity {
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_play);
        actionBar = getSupportActionBar();

        actionBar.setTitle("Now Playing");
        actionBar.setDisplayHomeAsUpEnabled(true);
//        Button libraryButton = (Button) findViewById(R.id.library_button);
//        libraryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent libraryIntent = new Intent(NowPlayingActivity.this, LibraryActivity.class);
//                startActivity(libraryIntent);
//            }
//        });
    }
}
