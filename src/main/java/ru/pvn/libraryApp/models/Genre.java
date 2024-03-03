package ru.pvn.libraryApp.models;

import lombok.*;

@Data
public class Genre {

    private long genre_id;

    private String genre_name;

    public Genre(String genre_name) {
        this.genre_name = genre_name;
    }

    public Genre(long genre_id, String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }

    public long getGenre_id() {
        return genre_id;
    }

    public String getGenre_name() {
        return genre_name;
    }
}
