package hu.bme.aut.booksearch.ui.search;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.interactor.BookFavInteractor;
import hu.bme.aut.booksearch.interactor.BookSearchInteractor;
import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.ui.Presenter;

public class SearchPresenter extends Presenter<SearchScreen> {
    private BookSearchInteractor bookSearchInteractor;
    private BookFavInteractor bookFavInteractor;

    @Inject
    public SearchPresenter(BookSearchInteractor bookSearchInteractror, BookFavInteractor bookFavInteractor){
        this.bookSearchInteractor=bookSearchInteractror;
        this.bookFavInteractor=bookFavInteractor;
    }

    @Override
    public void attachScreen(SearchScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getBooks(boolean titleChecked, boolean authorChecked, String value){
        String type="";
        if(authorChecked == true) type="author";
        else type="title";
        List<Book> results = bookSearchInteractor.getBooks(value, type);
        screen.getBooks(results);
    }

    public void addToFavs(Book book){
        bookFavInteractor.addBookToFavs(book);
    }


}
