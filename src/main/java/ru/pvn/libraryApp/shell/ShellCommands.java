package ru.pvn.libraryApp.shell;

import org.h2.tools.Console;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.pvn.libraryApp.dao.AuthorDaoJdbc;
import ru.pvn.libraryApp.dao.BookDaoJdbc;
import ru.pvn.libraryApp.dao.GenreDaoJdbc;
import ru.pvn.libraryApp.models.Author;
import ru.pvn.libraryApp.models.Book;
import ru.pvn.libraryApp.models.Genre;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ShellComponent
public class ShellCommands {

    private final AuthorDaoJdbc jdbcAuthor;
    private final GenreDaoJdbc jdbcGenreDao;
    private final BookDaoJdbc jdbcBookDao;

    public ShellCommands(AuthorDaoJdbc jdbcAuthor, GenreDaoJdbc jdbcGenreDao, BookDaoJdbc jdbcBookDao) {
        this.jdbcAuthor = jdbcAuthor;
        this.jdbcGenreDao = jdbcGenreDao;
        this.jdbcBookDao = jdbcBookDao;
    }

    @ShellMethod(value = "run H2 console", key = {"console"})
    public String runConsoleH2() throws SQLException {
        Console.main();
        return "Консоль H2 запущена";
    }

    @ShellMethod(value = "add Author to DB", key = {"add-author"})
    public String addAuthor(@ShellOption String fio) throws SQLException, ParseException {
        Author author = new Author(fio);
        jdbcAuthor.create(author);
        return String.format("Автор %s добавлен", author);
    }

    @ShellMethod(value = "get Author from DB by ID", key = {"get-author"})
    public String getAuthor(@ShellOption long id) throws SQLException, ParseException {
        Author author = jdbcAuthor.getById(id);
        return author.toString();
    }

    //Пользователь вводит имя произведения и список id авторов,
    //в дальнейшем не сложно переделать что будет вводить ФИО
    //Без фанатизма (с)

    @ShellMethod(value = "delete book from DB", key = {"delete-book"})
    public String deleteBook(@ShellOption long id) throws SQLException {
        jdbcBookDao.deleteById(id);
        return String.format("Книга id=%s удалена", id);
    }

    @ShellMethod(value = "get book from DB", key = {"get-book"})
    public String getBook(@ShellOption long id) throws SQLException {
        Book book = jdbcBookDao.getById(id);
        return book.toString();
    }

    @ShellMethod(value = "get all book from DB", key = {"get-book-all"})
    public String getAllBook() throws SQLException {
        List<Book> books = jdbcBookDao.getAll();
        return books.toString();
    }

    @ShellMethod(value = "get genre from DB by id", key = {"get-genre"})
    public String getGenre(@ShellOption long id) throws SQLException {
        Genre genre = jdbcGenreDao.getById(id);
        return genre.toString();
    }


    @ShellMethod(value = "add book to DB", key = {"add-book"})
    public String addBook(@ShellOption String name,
                          @ShellOption int author_id,
                          @ShellOption int genre_id) throws SQLException {
        Book book = new Book(name, author_id, genre_id);
        jdbcBookDao.create(book);
        return "Книга " + book.toString() + "добавлена!";
    }

    @ShellMethod(value = "update book in DB", key = {"update-book"})
    public String updateBookById(@ShellOption long id,
                                 @ShellOption String name,
                                 @ShellOption long author_id,
                                 @ShellOption long genre_id) throws SQLException {

            Book bookForUpdate = new Book(id,name,author_id,genre_id);
            jdbcBookDao.update(bookForUpdate);
            return "Книга " + bookForUpdate.toString() + "обновлена!";
        }
}






