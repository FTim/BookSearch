package hu.bme.aut.booksearch.db;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DBModule {
    Context context;

    @Inject
    public DBModule(Context context){
        this.context=context;
    }

    @Provides
    @Singleton
    public BookDao provideBookDao(){
        BooksDatabase db = Room.databaseBuilder(context,
                BooksDatabase.class, "book-database").fallbackToDestructiveMigration().build();
        return db.bookDao();
    }
}
