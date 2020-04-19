package hu.bme.aut.booksearch.ui.search;

import java.util.List;

import hu.bme.aut.booksearch.model.Book;

public interface SearchScreen {
    void getBooks(List<Book> books);

    void showMoreInfo(String uri);

    void addToFavs(Book book);

}
