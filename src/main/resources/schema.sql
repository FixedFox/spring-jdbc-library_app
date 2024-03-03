DROP TABLE IF EXISTS authors;
CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    author_fio VARCHAR(255));

DROP TABLE IF EXISTS genres;
CREATE TABLE genres (
    genre_id SERIAL PRIMARY KEY,
    genre_name VARCHAR(255) UNIQUE);

DROP TABLE IF EXISTS books;
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    book_name VARCHAR(255) UNIQUE,
    author_id INTEGER REFERENCES authors,
    genre_id INTEGER REFERENCES genres);