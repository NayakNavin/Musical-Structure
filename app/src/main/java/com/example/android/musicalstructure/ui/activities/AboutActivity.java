package com.example.android.musicalstructure.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.android.musicalstructure.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);
        Button playButton = (Button) findViewById(R.id.now_playing_button);
        playButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(AboutActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

    }
}