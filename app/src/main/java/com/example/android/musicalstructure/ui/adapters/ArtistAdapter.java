package com.example.android.musicalstructure.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.android.musicalstructure.R;
import com.example.android.musicalstructure.ui.models.Artist;

import java.util.List;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(@NonNull Context context, int resource, @NonNull List<Artist> artists) {
        super(context, resource, artists);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Artist getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View artistListView = convertView;
        if (artistListView == null) {
            artistListView = LayoutInflater.from(getContext()).inflate(R.layout.artist_item, parent, false);
        }
        return null;
    }
}
