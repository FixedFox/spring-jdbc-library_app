package ru.pvn.libraryApp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.pvn.libraryApp.dao.GenreDaoJdbc;
import ru.pvn.libraryApp.models.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест методов GenreDaoJdbc")
@JdbcTest
@Import(GenreDaoJdbc.class)
public class GenreDaoJdbcTests {

    @Autowired
    private GenreDaoJdbc jdbc;

    @DisplayName("Получение жанра по id")
    @Test
    void shouldGetGenreFromDBById() {
        Genre genre = jdbc.getById(1);
        assertThat(genre).hasFieldOrPropertyWithValue("genre_name", "sci-fi");
    }

    @DisplayName("Возвращение нового созданного жанра")
    @Test
    void shouldReturnNewAGenre () {
        Genre genre = new Genre("manga");
        jdbc.create(genre);
        Genre genreFromDB = jdbc.getLast();
        assertThat(genreFromDB).hasFieldOrPropertyWithValue("genre_name", "manga");
    }

}
