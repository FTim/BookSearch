package hu.bme.aut.booksearch.interactor;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;
import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.model.SearchResponse;
import hu.bme.aut.booksearch.network.BookSearchApi;
import hu.bme.aut.booksearch.utilities.Utilities;
import retrofit2.Call;
import retrofit2.Response;

public class BookSearchInteractor {

    BookSearchApi bookSearchApi;

    @Inject
    public BookSearchInteractor(BookSearchApi bookSearchApi) {
        this.bookSearchApi=bookSearchApi;
    }

    public List<Book> getBooks(String value, String querryType){
        ArrayList<Book> result = new ArrayList<Book>();
        Call<SearchResponse> booksQueryCall= null;
        if (querryType==Utilities.AUTHOR)
            booksQueryCall = bookSearchApi.searchJsonGetAuthor(value);
        else{
            booksQueryCall = bookSearchApi.searchJsonGetTitle(value);
        }
        try {
            Response<SearchResponse> response = booksQueryCall.execute();

            if (response.code() != 200) {
                throw new Exception("Response code is not 200!");
            } else {
                result.addAll(response.body().getDocs());
            }
        } catch (Exception e) {
            Log.d("BookSearchInteractor", e.getMessage());
            return result;
        }
        return result;
    }
}
