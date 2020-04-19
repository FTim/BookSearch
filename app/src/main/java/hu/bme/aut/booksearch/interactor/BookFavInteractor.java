package hu.bme.aut.booksearch.interactor;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.booksearch.model.Book;

public class BookFavInteractor {
    public BookFavInteractor(){}

    public List<Book> getBooks(){
        ArrayList<Book> result = new ArrayList<Book>();
        //TODO: API call
        //TODO: handle search by title/author differently!!!
        Book b1=new Book();
        b1.setAuthor("Favorite Writer");
        b1.setTitle("Best book");
        b1.setInfoUrl("");

        Book b2 =new Book();
        b2.setAuthor("Second Writer");
        b2.setTitle("Such book, much wow");
        b2.setInfoUrl("");
        result.add(b1);
        result.add(b2);

        return result;
    }

    public void addBookToFavs(Book book){
        //TODO: DB

    }
    public void removeBookFromFavs(Book book){
        //TODO: DB
    }
}
