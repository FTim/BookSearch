package hu.bme.aut.booksearch.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import hu.bme.aut.booksearch.model.Book;

@Database(entities = {Book.class}, version = 1, exportSchema = false)
public abstract class BookDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
}
