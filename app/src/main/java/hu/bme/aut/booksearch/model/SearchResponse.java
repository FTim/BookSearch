package hu.bme.aut.booksearch.model;


import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Response for OpenLibrary search, cannot change structure
 **/
public class SearchResponse   {

    @SerializedName("start")
    private Integer start = null;

    @SerializedName("num_found")
    private Integer num_Found = null;

    @SerializedName("numFound")
    private Integer numFound = null;

    @SerializedName("docs")
    private SearchResponseDocs docs = null;



    /**
     **/
    public Integer getStart() {
        return start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }


    /**
     **/
    public Integer getNum_Found() {
        return num_Found;
    }
    public void setNum_Found(Integer numFound) {
        this.num_Found = numFound;
    }


    /**
     **/
    public Integer getNumFound() {
        return numFound;
    }
    public void setNumFound(Integer numFound) {
        this.numFound = numFound;
    }


    /**
     **/
    public SearchResponseDocs getDocs() {
        return docs;
    }
    public void setDocs(SearchResponseDocs docs) {
        this.docs = docs;
    }
}

