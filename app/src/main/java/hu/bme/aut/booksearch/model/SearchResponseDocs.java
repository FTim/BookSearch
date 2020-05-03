package hu.bme.aut.booksearch.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * List of books
 **/
public class SearchResponseDocs   {

    @SerializedName("author_name")
    private List<String> authorName = new ArrayList<String>();

    @SerializedName("first_publish_year")
    private Integer firstPublishYear = null;

    @SerializedName("subtitle")
    private String subtitle = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("key")
    private String key = null;



    /**
     * Name of the author(s)
     **/
    public List<String> getAuthorName() {
        return authorName;
    }
    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
    }


    /**
     * Publish year to display in the app
     **/
    public Integer getFirstPublishYear() {
        return firstPublishYear;
    }
    public void setFirstPublishYear(Integer firstPublishYear) {
        this.firstPublishYear = firstPublishYear;
    }


    /**
     * Subtitle to display in the app
     **/
    public String getSubtitle() {
        return subtitle;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


    /**
     * Title to display in the app
     **/
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     **/
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
