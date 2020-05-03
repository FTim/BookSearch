package hu.bme.aut.booksearch.ui.search;

import android.os.AsyncTask;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.interactor.BookFavInteractor;
import hu.bme.aut.booksearch.interactor.BookSearchInteractor;
import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.ui.Presenter;
import hu.bme.aut.booksearch.utilities.Utilities;

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
        String type = "";
        if (authorChecked == true) type = Utilities.AUTHOR;
        else type = Utilities.TITLE;
        GetFoundBooksAsync getFoundBooksAsync=new GetFoundBooksAsync();
        getFoundBooksAsync.execute(new BookRequest(type, value));
    }

    public void addToFavs(Book book){
        bookFavInteractor.addBookToFavs(book);
    }


    //push network execution to another thread
    private class GetFoundBooksAsync extends AsyncTask<BookRequest, Void, List<Book>> {

        @Override
        protected List<Book> doInBackground(BookRequest... bookRequests) {
            List<Book> result = bookSearchInteractor.getBooks(bookRequests[0].value, bookRequests[0].type);
            return result;
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            screen.getBooks(books);
        }
    }

    private class BookRequest{
        public String type;
        public String value;
        public BookRequest(String type, String value){
            this.type=type;
            this.value=value;
        }
    }


}
