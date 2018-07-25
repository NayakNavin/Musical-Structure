package com.example.android.musicalstructure.ui.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
import java.util.Locale;
import java.util.Random;

public class NowPlayingActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private static final String REMAINING_TIME = "REMAINING_TIME";
    private static final String IS_PLAYING = "IS_PLAYING";
    private static final String IS_PLAYING_RANDOM = "IS_PLAYING_RANDOM";
    private static final String CURRENT_SONG_POS = "CURRENT_SONG_POS";

    // Interval to refresh the countDownTimer in milliseconds
    private final long TIMER_INTERVAL = 1000;
    private TextView elapsedTimeTextView;
    private TextView remainingTimeTextView;
    private CountDownTimer countDownTimer;

    private ImageView coverImageView;
    private ListView listListView;
    private SeekBar seekBar;
    private ImageView playStopImageView;
    private ImageView nextIconImageView;
    private ImageView previousIconImageView;
    private ImageView replayImageView;
    private ImageView shuffleImageView;

    private Album selectedAlbum;
    private Artist selectedArtist;
    private ArrayList<Song> songs;
    private Song currentSong;
    private boolean isPlaying;
    private long remainingTime;
    private boolean isPlayingRandom;
    private Random random;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_play);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Now Playing");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        // Get all the necessary views
        elapsedTimeTextView = findViewById(R.id.elapsedTime);
        remainingTimeTextView = findViewById(R.id.remainingTime);
        coverImageView = findViewById(R.id.cover);
        playStopImageView = findViewById(R.id.playStopIcon);
        seekBar = findViewById(R.id.seekBar);
        nextIconImageView = findViewById(R.id.nextIcon);
        previousIconImageView = findViewById(R.id.previousIcon);
        replayImageView = findViewById(R.id.replayIcon);
        shuffleImageView = findViewById(R.id.shuffleIcon);

        // Get the information from the intent
        Intent intent = getIntent();
        selectedAlbum = (Album) intent.getSerializableExtra(HomeActivity.SELECTED_ALBUM);
        selectedArtist = (Artist) intent.getSerializableExtra(HomeActivity.SELECTED_ARTIST);

        // Init variables
        currentSong = null;
        isPlaying = false;
        countDownTimer = initCountDownTimer(0);
        isPlayingRandom = false;
        random = new Random();
        mediaPlayer = null;

        int currentSongPos = 0;
        if (savedInstanceState != null) {
            currentSongPos = savedInstanceState.getInt(CURRENT_SONG_POS);
        }

        // Get all the songs to be played, depending if we have an album or an artist
        if (selectedAlbum != null) {
            songs = selectedAlbum.getSongs();
            setTitle(selectedAlbum.getName());
            coverImageView.setImageResource(getResources().getIdentifier(selectedAlbum.getCover(), "drawable", getPackageName()));
        } else if (selectedArtist != null) {
            songs = new ArrayList<>();
            for (Album album : selectedArtist.getAlbums()) {
                songs.addAll(album.getSongs());
            }
            setTitle(selectedArtist.getName());
            coverImageView.setImageResource(getResources().getIdentifier(selectedArtist.getPhoto(), "drawable", getPackageName()));
        }

        // Fill the list of songs
        listListView = findViewById(R.id.list);
        SongAdapter songAdapter = new SongAdapter(this, songs);
        listListView.setAdapter(songAdapter);
        listListView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        selectSong((Song) listListView.getItemAtPosition(currentSongPos));

        // Set the listeners
        listListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectSong((Song) parent.getItemAtPosition(position));
                view.setSelected(true);
            }
        });

        playStopImageView.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                playPause();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * Notification that the progress level has changed. Clients can use the fromUser parameter
             * to distinguish user-initiated changes from those that occurred programmatically.
             *
             * @param seekBar  The SeekBar whose progress has changed
             * @param progress The current progress level.
             * @param fromUser True if the progress change was initiated by the user.
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Refresh the time displayed
                remainingTime = (currentSong.getDuration() - seekBar.getProgress())
                        * TIMER_INTERVAL;
                refreshTime();
            }

            /**
             * Notification that the user has started a touch gesture. Clients may want to use this
             * to disable advancing the seekbar.
             *
             * @param seekBar The SeekBar in which the touch gesture began
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                countDownTimer.cancel();
            }

            /**
             * Notification that the user has finished a touch gesture. Clients may want to use this
             * to re-enable advancing the seekbar.
             *
             * @param seekBar The SeekBar in which the touch gesture began
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                countDownTimer = initCountDownTimer((currentSong.getDuration() -
                        seekBar.getProgress()) * TIMER_INTERVAL);
                countDownTimer.onTick(remainingTime);

                // seek function doesn't works
                if (mediaPlayer != null && isPlaying) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        mediaPlayer.seekTo(seekBar.getProgress() * 1000, MediaPlayer.SEEK_CLOSEST);
                    } else {
                        mediaPlayer.seekTo(seekBar.getProgress() * 1000);
                    }
                }
                if (isPlaying) {
                    countDownTimer.start();
                }
            }
        });

        nextIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextSong();
            }
        });

        previousIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousSong();
            }
        });

        replayImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectSong(currentSong);
            }
        });

        shuffleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlayingRandom) {
                    shuffleImageView.setImageResource(R.drawable.ic_shuffle);
                } else {
                    shuffleImageView.setImageResource(R.drawable.ic_dehaze);
                }
                isPlayingRandom = !isPlayingRandom;
            }
        });

        if (savedInstanceState != null) {
            remainingTime = savedInstanceState.getLong(REMAINING_TIME);
            countDownTimer = initCountDownTimer(remainingTime);

            isPlayingRandom = savedInstanceState.getBoolean(IS_PLAYING_RANDOM);
            if (isPlayingRandom) {
                shuffleImageView.setImageResource(R.drawable.ic_dehaze);
            }
            if (savedInstanceState.getBoolean(IS_PLAYING)) {
                // this will update isPlaying to true
                playPause();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(REMAINING_TIME, remainingTime);
        outState.putBoolean(IS_PLAYING, isPlaying);
        outState.putBoolean(IS_PLAYING_RANDOM, isPlayingRandom);
        outState.putInt(CURRENT_SONG_POS, songs.indexOf(currentSong));
    }

    /**
     * Obtain an {@link Intent} that will launch an explicit target activity
     * specified by sourceActivity's {@link NavUtils#PARENT_ACTIVITY} &lt;meta-data&gt;
     * element in the application's manifest. If the device is running
     * Jellybean or newer, the android:parentActivityName attribute will be preferred
     * if it is present.
     *
     * @return a new Intent targeting the defined parent activity of sourceActivity
     */
    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        return super.getSupportParentActivityIntent();
    }

    /**
     * Init a countDownTimer for the duration of the selected song
     *
     * @param duration in millisecond
     * @return the countDownTimer
     */
    private CountDownTimer initCountDownTimer(final long duration) {

        remainingTime = duration;
        return new CountDownTimer(duration, TIMER_INTERVAL) {

            public void onTick(long millisUntilFinished) {
                remainingTime = millisUntilFinished;
                refreshTime();

                // Update the seekBar
                seekBar.setProgress(currentSong.getDuration() - (int) (millisUntilFinished / TIMER_INTERVAL));
            }

            public void onFinish() {
                nextSong();
            }
        };
    }

    /**
     * Refresh the display of the time
     */
    private void refreshTime() {
        // Display the remaining time of the song
        long minutes = remainingTime / 1000 / 60;
        remainingTimeTextView.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes,
                (remainingTime - (minutes * 60 * 1000)) / 1000));

        // Display the elapsed time of the song
        long elapsedTime = currentSong.getDuration() - (remainingTime / 1000);
        minutes = elapsedTime / 60;
        elapsedTimeTextView.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes,
                (elapsedTime - (minutes * 60))));
    }

    /**
     * Select the song to play
     *
     * @param selection the selected song
     */
    private void selectSong(Song selection) {
        currentSong = selection;

        int resIdMedia = 0;
        if (currentSong.getMediaFile() != null) {
            resIdMedia = getResources().getIdentifier(currentSong.getMediaFile(), "raw", getPackageName());
        }
        if (resIdMedia == 0) {
            Toast.makeText(this, R.string.noFile, Toast.LENGTH_SHORT).show();
        }
        countDownTimer.cancel();

        // initialization of the elapsed time of the current song
        long durationMS = selection.getDuration() * TIMER_INTERVAL;
        countDownTimer = initCountDownTimer(durationMS);
        countDownTimer.onTick(durationMS);

        // initialization of the seekBar
        seekBar.setMax(selection.getDuration());
        seekBar.setProgress(0);

        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer = null;
        }
        if (resIdMedia != 0) {
            mediaPlayer = MediaPlayer.create(this, resIdMedia);
        }
        if (isPlaying) {
            countDownTimer.start();
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        }
    }

    /**
     * Play or pause the current song
     */
    private void playPause() {

        if (isPlaying) {
            playStopImageView.setImageResource(R.drawable.ic_play_circle_filled);
            countDownTimer.cancel();
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        } else {
            playStopImageView.setImageResource(R.drawable.ic_pause_circle_filled);
            countDownTimer = initCountDownTimer(remainingTime);
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
            countDownTimer.start();
        }
        isPlaying = !isPlaying;
    }

    /**
     * Select the next song
     */
    private void nextSong() {
        int currentPosition = songs.indexOf(currentSong);

        // Deselect the current item
        int firstDisplayedPosition = listListView.getFirstVisiblePosition();
        listListView.getChildAt(currentPosition - firstDisplayedPosition).setSelected(false);

        if (isPlayingRandom) {
            int i = random.nextInt(listListView.getChildCount());
            currentPosition = firstDisplayedPosition + i;
        } else {
            currentPosition++;
            // When we are at the bottom, we go back to the top
            if (currentPosition == songs.size()) {
                currentPosition = 0;
                firstDisplayedPosition = 0;
                listListView.setSelectionAfterHeaderView();
            }
        }
        selectSong((Song) listListView.getItemAtPosition(currentPosition));
        listListView.getChildAt(currentPosition - firstDisplayedPosition).setSelected(true);
        listListView.smoothScrollToPosition(currentPosition + 1 - firstDisplayedPosition);
    }

    /**
     * Select the previous song
     */
    private void previousSong() {
        int currentPosition = songs.indexOf(currentSong);

        // Deselect the current item
        int firstDisplayedPosition = listListView.getFirstVisiblePosition();
        listListView.getChildAt(currentPosition - firstDisplayedPosition).setSelected(false);

        if (isPlayingRandom) {
            int i = random.nextInt(listListView.getChildCount());
            currentPosition = firstDisplayedPosition + i;
        } else {
            currentPosition--;
            // When we are at the top, we go to the bottom of the list
            if (currentPosition == -1) {
                currentPosition = songs.size() - 1;
                listListView.smoothScrollToPosition(currentPosition);
                firstDisplayedPosition = listListView.getFirstVisiblePosition();
            }
        }
        selectSong((Song) listListView.getItemAtPosition(currentPosition));

        // Trick because when going too the last element of the list, the View item doesn't exists
        if (currentPosition <= listListView.getLastVisiblePosition()) {
            listListView.getChildAt(currentPosition - firstDisplayedPosition).setSelected(true);
            listListView.smoothScrollToPosition(currentPosition - 1 - firstDisplayedPosition);
        }
    }
}