package com.example.android.musicalstructure.ui.models;

import java.io.Serializable;

public class Song implements Serializable {

    private String name;
    private int duration;
    private String mediaFile;

    public Song(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.mediaFile = null;
    }

    public Song(String name, int duration, String mediaFile) {

        this.name = name;
        this.duration = duration;
        this.mediaFile = mediaFile;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public String getMediaFile() {
        return mediaFile;
    }

}
