package com.example.android.musicalstructure.ui.models;

import java.io.Serializable;

public class Song implements Serializable {

    private String name;


    private int duration;

    public Song(String name, int duration) {
        this.name = name;
        this.duration = duration;

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




















}
