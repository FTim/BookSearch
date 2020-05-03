package hu.bme.aut.booksearch.model;


import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Response for OpenLibrary search, cannot change structure
 **/
public class SearchResponse {

    /**
     * Starting index - used for paging
     * Not used in the app
     **/
    @SerializedName("start")
    private Integer start = null;

    /**
     * Number of books found
     * Not used in the app
     **/
    @SerializedName("num_found")
    private Integer num_Found = null;

    @SerializedName("numFound")
    private Integer numFound = null;

    /**
     * List of books
     * docs = books
     **/
    @SerializedName("docs")
    private List<Book> docs = null;

    public Integer getStart() {
        return start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getNum_Found() {
        return num_Found;
    }
    public void setNum_Found(Integer numFound) {
        this.num_Found = numFound;
    }

    public Integer getNumFound() {
        return numFound;
    }
    public void setNumFound(Integer numFound) {
        this.numFound = numFound;
    }

    public List<Book> getDocs() {
        return docs;
    }
    public void setDocs(List<Book> docs) {
        this.docs = docs;
    }
}

