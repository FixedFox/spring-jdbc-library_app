package ru.pvn.libraryApp.models;


import lombok.*;

import java.util.Date;

@Data
public class Author {

    private long author_id;

    private String author_fio;

    public Author(String author_fio) {
        this.author_fio = author_fio;
    }

    public Author(long author_id, String author_fio) {
        this.author_id = author_id;
        this.author_fio = author_fio;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public String getAuthor_fio() {
        return author_fio;
    }

    @Override
    public String toString() {
        return "Автор: " +
                "author_id=" + author_id +
                ", author_fio=" + author_fio;
    }
}
