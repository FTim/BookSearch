package hu.bme.aut.booksearch.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;
import hu.bme.aut.booksearch.model.Book;

public class BookFavInteractor {
    @Inject
    public BookFavInteractor(){
        BookSearchApplication.injector.inject(this);
    }

    public List<Book> getBooks(){
        ArrayList<Book> result = new ArrayList<Book>();
        //TODO: API call
        //TODO: handle search by title/author differently!!!


        return result;
    }

    public void addBookToFavs(Book book){
        //TODO: DB

    }
    public void removeBookFromFavs(Book book){
        //TODO: DB
    }
}
