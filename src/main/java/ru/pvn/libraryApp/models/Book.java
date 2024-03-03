package ru.pvn.libraryApp.models;

public class Book {

    private long book_id;

    private String book_name;

    private long author_id;

    private long genre_id;



    public Book(long book_id, String book_name, long author_id, long genre_id) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author_id = author_id;
        this.genre_id = genre_id;
    }
    public Book(String book_name, long author_id, long genre_id) {
        this.book_name = book_name;
        this.author_id = author_id;
        this.genre_id = genre_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public long getGenre_id() {
        return genre_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public void setGenre_id(long genre_id) {
        this.genre_id = genre_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", author_id='" + getAuthor_id() + '\'' +
                ", genre_id=" + getGenre_id() +
                '}';
    }
}
