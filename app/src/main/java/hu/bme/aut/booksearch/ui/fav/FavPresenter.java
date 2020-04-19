package hu.bme.aut.booksearch.ui.fav;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.interactor.BookFavInteractor;
import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.ui.Presenter;

public class FavPresenter extends Presenter<FavScreen> {
    private BookFavInteractor bookFavInteractor;

    @Inject
    public FavPresenter(BookFavInteractor bookFavInteractror){

        this.bookFavInteractor=bookFavInteractror;
    }

    @Override
    public void attachScreen(FavScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getBooks(){

        List<Book> results = bookFavInteractor.getBooks();
        screen.getBooks(results);
    }

    public void removeFromFavs(Book b){
        bookFavInteractor.removeBookFromFavs(b);
    }

}
