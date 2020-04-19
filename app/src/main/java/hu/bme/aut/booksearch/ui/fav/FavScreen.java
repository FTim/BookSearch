package hu.bme.aut.booksearch.ui.fav;

import java.util.List;

import hu.bme.aut.booksearch.model.Book;


public interface FavScreen {
    void getBooks(List<Book> books);

    void showMoreInfo(String uri);

    void removeBook(Book b, int index);
}
