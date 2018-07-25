package com.example.android.musicalstructure.ui.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Artist implements Serializable {

    private String name;
    private String photo;
    private ArrayList<Album> albums;

    public Artist(String name, String photo) {
        this.name = name;
        this.photo = photo;
        albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }
}