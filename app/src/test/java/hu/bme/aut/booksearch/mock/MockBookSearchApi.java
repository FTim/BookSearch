package hu.bme.aut.booksearch.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.model.SearchResponse;
import hu.bme.aut.booksearch.network.BookSearchApi;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockBookSearchApi implements BookSearchApi {
    @Override
    public Call<SearchResponse> searchJsonGetAuthor(String author) {
        final SearchResponse response=new SearchResponse();

        ArrayList<String> authors1=new ArrayList<String>();
        authors1.add("Author A");
        /*ArrayList<String> authors2=new ArrayList<String>();
        authors1.add("Writer B");*/
        ArrayList<String> authors3=new ArrayList<String>();
        authors1.add("Author A, Copy C");

        List<Book> books=new ArrayList<Book>();
        Book b1=new Book();
        b1.setTitle("Book one");
        b1.setAuthorName(authors1);
        b1.setKey("1");
        b1.setFirstPublishYear(2020);
        b1.setSubtitle("");

        /*Book b2=new Book();
        b2.setTitle("Another book");
        b2.setAuthorName(authors2);
        b2.setKey("2");
        b2.setFirstPublishYear(null);
        b2.setSubtitle("Just another thing to read");*/

        Book b3=new Book();
        b3.setTitle("No B-letter word here");
        b3.setAuthorName(authors3);
        b3.setKey("3");
        b3.setFirstPublishYear(2000);
        b3.setSubtitle("");

        books.add(b1);
        books.add(b3);

        response.setNum_Found(2);
        response.setNumFound(2);
        response.setStart(0);
        response.setDocs(books);


        Call<SearchResponse> call = new Call<SearchResponse>() {
            @Override
            public Response<SearchResponse> execute() throws IOException {
                return Response.success(response);
            }

            @Override
            public void enqueue(Callback<SearchResponse> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<SearchResponse> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }

    @Override
    public Call<SearchResponse> searchJsonGetTitle(String title) {
        final SearchResponse response=new SearchResponse();

        ArrayList<String> authors1=new ArrayList<String>();
        authors1.add("Author A");
        ArrayList<String> authors2=new ArrayList<String>();
        authors1.add("Writer B");
        /*ArrayList<String> authors3=new ArrayList<String>();
        authors1.add("Author A, Copy C");*/

        List<Book> books=new ArrayList<Book>();
        Book b1=new Book();
        b1.setTitle("Book one");
        b1.setAuthorName(authors1);
        b1.setKey("1");
        b1.setFirstPublishYear(2020);
        b1.setSubtitle("");

        Book b2=new Book();
        b2.setTitle("Another book");
        b2.setAuthorName(authors2);
        b2.setKey("2");
        b2.setFirstPublishYear(null);
        b2.setSubtitle("Just another thing to read");

        /*Book b3=new Book();
        b3.setTitle("No B-letter word here");
        b3.setAuthorName(authors3);
        b3.setKey("3");
        b3.setFirstPublishYear(2000);
        b3.setSubtitle("");*/

        books.add(b1);
        books.add(b2);

        response.setNum_Found(2);
        response.setNumFound(2);
        response.setStart(0);
        response.setDocs(books);


        Call<SearchResponse> call = new Call<SearchResponse>() {
            @Override
            public Response<SearchResponse> execute() throws IOException {
                return Response.success(response);
            }

            @Override
            public void enqueue(Callback<SearchResponse> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<SearchResponse> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };

        return call;
    }
}
