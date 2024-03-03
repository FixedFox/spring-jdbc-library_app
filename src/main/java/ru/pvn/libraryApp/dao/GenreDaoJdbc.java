package ru.pvn.libraryApp.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.pvn.libraryApp.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao {

    private final NamedParameterJdbcOperations jdbc;

    public GenreDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Genre getById(long genre_id) {
        return jdbc.queryForObject("SELECT * FROM genres WHERE genre_id = :genre_id",
                Map.of("genre_id", genre_id),
                new GenreMapper());
    }

    @Override
    public Genre getLast() {
        return jdbc.queryForObject("SELECT * FROM genres ORDER BY genre_id DESC limit 1",
                (SqlParameterSource) null,
                new GenreMapper());
    }

    @Override
    public void create(Genre genre) {
        jdbc.update("INSERT INTO genres (genre_name) VALUES (:genre_name)",
                Map.of("genre_name", genre.getGenre_name()));
    }

    private static class GenreMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Genre(resultSet.getLong("genre_id"),
                    resultSet.getString("genre_name"));
        }
    }
}
