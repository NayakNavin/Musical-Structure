package com.example.android.musicalstructure.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.musicalstructure.R;
import com.example.android.musicalstructure.ui.models.Song;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {
    /**
     * Constructor
     *
     * @param context The current context.
     * @param songs   The songs to represent in the ListView.
     */
    public SongAdapter(@NonNull Context context, @NonNull List<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View songItemView = convertView;
        if (songItemView == null) {
            songItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list, parent, false);
        }

        Song currentSong = getItem(position);
        if (currentSong != null) {
            TextView nameTextView = songItemView.findViewById(R.id.default_text_view);
            nameTextView.setText(currentSong.getName());
        }
        return songItemView;
    }
}
