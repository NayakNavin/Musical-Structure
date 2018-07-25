package com.example.android.musicalstructure.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicalstructure.R;
import com.example.android.musicalstructure.ui.models.Artist;
import com.example.android.musicalstructure.ui.sample.SampleContent;

import java.util.List;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    /**
     * Constructor
     *
     * @param context The current context.
     * @param artists The objects to represent in the ListView.
     */
    public ArtistAdapter(@NonNull Context context, @NonNull List<Artist> artists) {
        super(context, 0, artists);
    }

    @Override
    public int getCount() {
        return SampleContent.ITEMS_ARTISTS.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View artistListView = convertView;
        if (artistListView == null) {
            artistListView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_artists, parent, false);
        }

        Artist currentArtist = getItem(position);
        if (currentArtist != null) {
            ImageView artistImageView = artistListView.findViewById(R.id.artist_img);
            artistImageView.setImageResource(getContext().getResources().getIdentifier(
                    currentArtist.getPhoto(), "drawable", getContext().getPackageName()));

            TextView artistTextView = artistListView.findViewById(R.id.artist_name);
            artistTextView.setText(currentArtist.getName());
        }
        return artistListView;
    }
}