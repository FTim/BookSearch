package hu.bme.aut.booksearch.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

import hu.bme.aut.booksearch.model.Book;

@Database(entities = {Book.class}, version = 2, exportSchema = false)
public abstract class BooksDatabase extends RoomDatabase {
    public abstract BookDao bookDao();

}
