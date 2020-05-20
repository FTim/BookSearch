package hu.bme.aut.booksearch.mock;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.booksearch.db.BookDao;
import hu.bme.aut.booksearch.db.BooksDatabase;

@Module
public class MockDBModule {
    Context context;

    @Inject
    public MockDBModule(Context context){
        this.context=context;
    }

    @Provides
    @Singleton
    public BookDao provideBookDao(){
        BooksDatabase db = Room.inMemoryDatabaseBuilder(context, BooksDatabase.class).build();

        return db.bookDao();
    }
}
