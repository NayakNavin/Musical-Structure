package com.example.android.musicalstructure.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicalstructure.R;
import com.example.android.musicalstructure.ui.models.Album;
import com.example.android.musicalstructure.ui.sample.SampleContent;

import java.util.List;

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(@NonNull Context context, @NonNull List<Album> albums) {
        super(context, 0, albums);
    }

    @Override
    public int getCount() {
        return SampleContent.ITEMS_ALBUMS.size();
    }

    //
//    @Override
//    public Album getItem(int position) {
//        return null;
//    }
//
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View albumGridView = convertView;
        if (albumGridView == null) {
            albumGridView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_album, parent, false);
        }


        Album currentAlbum = getItem(position);

        if (currentAlbum != null) {
            ImageView albumImageView = albumGridView.findViewById(R.id.album_img);
            albumImageView.setImageResource(getContext().getResources().getIdentifier(
                    currentAlbum.getCover(), "drawable", getContext().getPackageName()));

            TextView albumTextView = albumGridView.findViewById(R.id.albumName);
            albumTextView.setText(currentAlbum.getName());

            TextView artistTextView = albumGridView.findViewById(R.id.artistName);
            artistTextView.setText(currentAlbum.getArtist().getName());
        }

        return albumGridView;
    }


}
