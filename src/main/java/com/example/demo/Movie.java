package com.example.demo;

import java.io.Serializable;
import java.time.Year;

public class Movie implements Serializable {

    private String title;
    private String production;
    private String genre;

    public Movie(String title, String production, String genre) {
        this.title = title;
        this.production = production;
        this.genre = genre;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
