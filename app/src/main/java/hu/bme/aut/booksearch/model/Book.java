package hu.bme.aut.booksearch.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.booksearch.utilities.Utilities;

public class Book {
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

    private String authors;
    private String infoUrl;


    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }


    public List<String> getAuthorName() { return authorName; }
    public void setAuthorName(List<String> authorName) {
        this.authorName = authorName;
        this.authors="";
        for(int i=0;i<authorName.size();i++) {
            if (i == authorName.size() - 1) authors = authors.concat(authorName.get(i));
            else {
                authors = authors.concat(authorName.get(i));
                authors = authors.concat(", ");
            }
        }
    }

    public Integer getFirstPublishYear() { return firstPublishYear; }
    public void setFirstPublishYear(Integer firstPublishYear) { this.firstPublishYear = firstPublishYear; }

    public String getSubtitle() { return subtitle; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

    public String getKey() { return key; }
    public void setKey(String key) {
        this.key = key;
        String url= Utilities.BASE_ADDRESS;
        url=url.concat(key);
        this.setInfoUrl(url);
    }
}
