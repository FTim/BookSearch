package hu.bme.aut.booksearch.network;

import hu.bme.aut.booksearch.model.SearchResponse;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;


public interface BookSearchApi {

    /**
     * Find books with given author or title
     *
     * @param author Search books with this author
     * @param title Search books with this title
     * @return Call<SearchResponse>
     */

    @GET("search.json")
    Call<SearchResponse> searchJsonGet(
            @Query("author") String author, @Query("title") String title
    );


}