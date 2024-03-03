package ru.pvn.libraryApp.dao;

import ru.pvn.libraryApp.models.Genre;

public interface GenreDao {
    Genre getById(long id);
    Genre getLast();
    void create(Genre genre);


}
