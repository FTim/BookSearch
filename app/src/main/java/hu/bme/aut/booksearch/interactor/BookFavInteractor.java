package hu.bme.aut.booksearch.interactor;

import android.database.sqlite.SQLiteConstraintException;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;
import hu.bme.aut.booksearch.db.BookDao;
import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.utilities.Utilities;

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

    public String addBookToFavs(Book book){
        try{
            dao.insertAll(book);
            return Utilities.ADDED;
        }catch (Exception e){
            if(e.getClass()== SQLiteConstraintException.class){
                return Utilities.EXISTS;
            }

        }
        return Utilities.DBEROOR;

    }
    public String removeBookFromFavs(Book book){
        try{
            dao.delete(book);
            return Utilities.REMOVED;
        }catch (Exception e)
        {
            return Utilities.DBEROOR;
        }

    }
}
