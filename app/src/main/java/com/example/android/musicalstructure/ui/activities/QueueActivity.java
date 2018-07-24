package com.example.android.musicalstructure.ui.activities;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.musicalstructure.R;
import com.example.android.musicalstructure.ui.adapters.SongAdapter;
import com.example.android.musicalstructure.ui.models.Album;
import com.example.android.musicalstructure.ui.models.Artist;
import com.example.android.musicalstructure.ui.models.Song;

import java.util.ArrayList;
import java.util.Random;

public class QueueActivity extends AppCompatActivity {
    private static final String REMAINING_TIME = "REMAINING_TIME";
    private static final String IS_PLAYING = "IS_PLAYING";
    private static final String IS_PLAYING_RANDOM = "IS_PLAYING_RANDOM";
    private static final String CURRENT_SONG_POS = "CURRENT_SONG_POS";
    // Interval to refresh the countDownTimer in milliseconds
    private final long TIMER_INTERVAL = 1000;
    private TextView elapsedTimeTV;
    private TextView remainingTimeTV;
    private ImageView coverIV;
    private ListView listLV;
    private ImageView playStopIV;
    private SeekBar seekBar;
    private ImageView nextIconIV;
    private ImageView previousIconIV;
    private ImageView replayIV;
    private ImageView randomIV;

    private Album selectedAlbum;
    private Artist selectedArtist;
    private ArrayList<Song> songs;
    private Song currentSong;
    private boolean isPlaying;
    private long remainingTime;
    private boolean isPlayingRandom;
    private Random random;
    private MediaPlayer mediaPlayer;

    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_queue);


        int currentSongPos = 0;
        if (savedInstanceState != null) {
            currentSongPos = savedInstanceState.getInt(CURRENT_SONG_POS);
        }

        // Fill the list of songs
        listLV = findViewById(R.id.list);
        SongAdapter songAdapter = new SongAdapter(this, songs);
        listLV.setAdapter(songAdapter);
        listLV.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        selectSong((Song) listLV.getItemAtPosition(currentSongPos));

        // Set the listeners
        listLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectSong((Song) parent.getItemAtPosition(position));
                view.setSelected(true);
            }
        });

    }


    private void selectSong(Song selection) {
        currentSong = selection;

        int resIdMedia = 0;
        if (currentSong.getMediaFile() != null) {
            resIdMedia = getResources().getIdentifier(currentSong.getMediaFile(), "raw", getPackageName());
        }

        if (resIdMedia == 0) {
            Toast.makeText(this, R.string.noFile, Toast.LENGTH_SHORT).show();
        }
    }


}
