package ru.pvn.libraryApp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.pvn.libraryApp.dao.AuthorDaoJdbc;
import ru.pvn.libraryApp.models.Author;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест методов AuthorDaoJdbc")
@JdbcTest
@Import(AuthorDaoJdbc.class)
public class AuthorDaoJdbcTests {

    @Autowired
    private AuthorDaoJdbc jdbc;

    @DisplayName("Получает ФИО автора по id")
    @Test
    void shouldGetAuthorFromDBById() {
        Author author = jdbc.getById(1);
        assertThat(author).hasFieldOrPropertyWithValue("author_fio", "Philip Kindred Dick");
    }

    @DisplayName("Получает ID автора по ФИО")
    @Test
    void shouldGetAuthorFromDBByFio() {
        Author author = jdbc.getByFio("Herbert George Wells");
        assertThat(author).hasFieldOrPropertyWithValue("author_id", 3L);
    }

    @DisplayName("Возвращает добавленного автора")
    @Test
    void shouldReturnNewAuthor () {
        Author newAuthor = new Author("Иванов Иван Иванович");
        jdbc.create(newAuthor);
        Author authorFromDB = jdbc.getByFio("Иванов Иван Иванович");
        assertThat(authorFromDB).hasFieldOrPropertyWithValue("author_fio", "Иванов Иван Иванович");
    }

}
