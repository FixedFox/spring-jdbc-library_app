package ru.pvn.libraryApp.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.pvn.libraryApp.models.Author;
import ru.pvn.libraryApp.models.Book;
import ru.pvn.libraryApp.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    private final String selectBooks = "SELECT bks.book_id,\n" +
            "                       bks.book_name, \n" +
            "                       gnrs.genre_id,\n" +
            "                       gnrs.genre_name,\n" +
            "                       aut.author_id,\n" +
            "                       aut.author_fio,\n" +
            "        FROM books bks\n" +
            "        JOIN authors aut ON aut.author_id = bks.author_id\n" +
            "        JOIN genres gnrs ON gnrs.genre_id = bks.genre_id\n";

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc, GenreDaoJdbc genreJdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Book getById(long book_id) {
        return jdbc.query(selectBooks +
                        "WHERE bks.book_id = :book_id",
                Map.of("book_id", book_id),
                new BookExtractor());
    }

    @Override
    public Book getLast() {
        return jdbc.query("SELECT * FROM books ORDER BY book_id DESC limit 1",
                (SqlParameterSource) null,
                new BookExtractor());
    }

    @Override
    public void create(Book book) {
        jdbc.update( "INSERT INTO books (book_name, author_id, genre_id) VALUES (:name, :author, :genre)",
                Map.of("name", book.getBook_name(),
                        "author", book.getAuthor_id(),
                        "genre", book.getGenre_id()));
    }

    @Override
    public void update(Book book) {
        jdbc.update("UPDATE books SET book_name = :name , author_id = :author, genre_id = :genre WHERE book_id = :id",
                Map.of("id", book.getBook_id(),
                        "name", book.getBook_name(),
                        "author", book.getAuthor_id(),
                        "genre", book.getGenre_id()));
    }


    @Override
    public void deleteById(long book_id) {
        jdbc.update("DELETE FROM books WHERE book_id = :book_id", Map.of("book_id", book_id));
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query(selectBooks +
                " ORDER BY book_id", new BooksExtractor());
    }


    private class BookExtractor implements ResultSetExtractor<Book> {
        @Override
        public Book extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Book> books = new BooksExtractor().extractData(resultSet);
            if (books.isEmpty()) return null;
            else return books.iterator().next();
        }
    }

    private class BooksExtractor implements ResultSetExtractor<List<Book>> {
        @Override
        public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Map<Long, Book> books = new HashMap<>();
            while (resultSet.next()) {
                Book book = books.get(resultSet.getLong("book_id"));
                if (book == null) {
                    book = new Book(
                            resultSet.getLong("book_id"),
                            resultSet.getString("book_name"),
                            resultSet.getInt("author_id"),
                            resultSet.getLong("genre_id"));
                    books.put(resultSet.getLong("book_id"), book);
                }
            }
            return new ArrayList<>(books.values());
        }
    }
}

