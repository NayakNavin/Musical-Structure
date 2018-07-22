package com.example.android.musicalstructure.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.android.musicalstructure.R;
import com.example.android.musicalstructure.ui.models.Album;

import java.util.List;

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(@NonNull Context context, int resource, @NonNull List<Album> objects) {
        super(context, resource, objects);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Album getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View albumGridView = convertView;
        if (albumGridView == null) {
            albumGridView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }
        return null;
    }
}
