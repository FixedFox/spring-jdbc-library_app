package ru.pvn.libraryApp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.pvn.libraryApp.dao.AuthorDaoJdbc;
import ru.pvn.libraryApp.dao.BookDaoJdbc;
import ru.pvn.libraryApp.dao.GenreDaoJdbc;
import ru.pvn.libraryApp.models.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест методов BookDaoJdbc")
@JdbcTest
@Import({AuthorDaoJdbc.class, BookDaoJdbc.class, GenreDaoJdbc.class})
public class BookDaoJdbcTests {

    @Autowired
    private AuthorDaoJdbc authorJdbc;
    @Autowired
    private BookDaoJdbc bookJdbc;
    @Autowired
    private GenreDaoJdbc genreJdbc;

    @DisplayName("Получение книги по id")
    @Test
    void shouldGetBookFromDBById() {
        Book book = bookJdbc.getById(1);
        assertThat(book).hasFieldOrPropertyWithValue("book_name", "Do Androids Dream of Electric Sheep?");
    }

    @DisplayName("Добавление книги")
    @Test
    void shouldCreateBook() {
        Book newBook = new Book("Шедевры", 1, 1);
        bookJdbc.create(newBook);
        var bookForCheck = bookJdbc.getLast();
        assertThat(bookForCheck).hasFieldOrPropertyWithValue("book_name", "Шедевры");
    }

    @DisplayName("Обновление книги")
    @Test
    void shouldUpdateBook() {
        Book book = bookJdbc.getById(2);
        book.setBook_name("Ужасы говнокода!");
        bookJdbc.update(book);
        book = bookJdbc.getById(2);
        assertThat(book).hasFieldOrPropertyWithValue("book_name", "Ужасы говнокода!");
    }

    @DisplayName("Удаление книги")
    @Test
    void shouldDeleteBook() {
        bookJdbc.deleteById(1);
        Assertions.assertThat(bookJdbc.getById(1)).isNull();
    }

    @DisplayName("Получение всех книг")
    @Test
    void shouldGetAllBook() {
        List<Book> books = bookJdbc.getAll();
        assertThat(books).hasSizeGreaterThanOrEqualTo(15);
    }


}
