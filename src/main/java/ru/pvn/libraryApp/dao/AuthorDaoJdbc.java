package ru.pvn.libraryApp.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.pvn.libraryApp.models.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations jdbc;

    public AuthorDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Author getById(long id) {
        final Map<String,Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.queryForObject("SELECT * FROM authors WHERE author_id = :id",
                Map.of("id", id),
                new AuthorMapper());
    }

    @Override
    public Author getByFio(String author_fio) {
        return jdbc.queryForObject("SELECT * FROM authors WHERE author_fio = :name",
                Map.of("name", author_fio),
                new AuthorMapper());
    }

    @Override
    public void create(Author author) {
        jdbc.update("INSERT INTO authors (author_fio) VALUES (:author_fio)",
                Map.of("author_fio", author.getAuthor_fio()));
        }

    private static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Author(resultSet.getInt("author_id"),resultSet.getString("author_fio"));
        }
    }
}


