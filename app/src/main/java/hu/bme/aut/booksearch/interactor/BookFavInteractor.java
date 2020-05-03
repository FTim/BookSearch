package hu.bme.aut.booksearch.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;
import hu.bme.aut.booksearch.db.BookDao;
import hu.bme.aut.booksearch.model.Book;

public class BookFavInteractor {
    BookDao dao;
    @Inject
    public BookFavInteractor(BookDao dao){
        this.dao=dao;
        BookSearchApplication.injector.inject(this);
    }

    public List<Book> getBooks(){
        List<Book> result = dao.getAll();

        return result;
    }

    public void addBookToFavs(Book book){
        dao.insertAll(book);

    }
    public void removeBookFromFavs(Book book){
        dao.delete(book);
    }
}
