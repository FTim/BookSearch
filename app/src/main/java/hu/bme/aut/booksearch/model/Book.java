package hu.bme.aut.booksearch.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.booksearch.utilities.Utilities;

@Entity
public class Book {
    @SerializedName("author_name")
    @Ignore
    private List<String> authorName = new ArrayList<String>();

    @SerializedName("first_publish_year")
    @ColumnInfo(name = "year")
    private Integer firstPublishYear = null;

    @SerializedName("subtitle")
    @ColumnInfo(name = "subtitle")
    private String subtitle = null;

    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title = null;

    @SerializedName("key")
    @PrimaryKey
    @NonNull
    private String key;

    @ColumnInfo(name = "authors")
    private String authors = "";

    public String getAuthors() {
        if(!authors.isEmpty()) return authors;
        for(int i=0;i<authorName.size();i++) {
            if (i == authorName.size() - 1) authors = authors.concat(authorName.get(i));
            else {
                authors = authors.concat(authorName.get(i));
                authors = authors.concat(", ");
            }
        }
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
        String result= Utilities.BASE_ADDRESS;
        result=result.concat(key);
        return  result;
    }

    public List<String> getAuthorName() { return authorName; }
    public void setAuthorName(List<String> authorName) { this.authorName = authorName; }

    public Integer getFirstPublishYear() { return firstPublishYear; }
    public void setFirstPublishYear(Integer firstPublishYear) { this.firstPublishYear = firstPublishYear; }
    public String getFirstPublishYearString(){if (firstPublishYear==null)return ""; else return firstPublishYear.toString();}

    public String getSubtitle() { return subtitle; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
}
