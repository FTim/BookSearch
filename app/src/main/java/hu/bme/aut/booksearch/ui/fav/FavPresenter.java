package hu.bme.aut.booksearch.ui.fav;

import android.os.AsyncTask;

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
        GetFavBooksAsync getFavBooksAsync=new GetFavBooksAsync();
        getFavBooksAsync.execute();
    }

    public void removeFromFavs(Book b){
        RemoveFavBookAsync removeFavBookAsync=new RemoveFavBookAsync();
        removeFavBookAsync.execute(b);
    }

    //push DB access to another thread
    private class GetFavBooksAsync extends AsyncTask<Void, Void, List<Book>> {

        @Override
        protected List<Book> doInBackground(Void... voids) {
            List<Book> result = bookFavInteractor.getBooks();
            return result;
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            screen.getBooks(books);
        }
    }

    private class RemoveFavBookAsync extends AsyncTask<Book, Void, String>{

        @Override
        protected String doInBackground(Book... books) {
            String result = bookFavInteractor.removeBookFromFavs(books[0]);
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            screen.removedBook(result);
        }
    }

}
