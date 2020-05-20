package hu.bme.aut.booksearch;

import android.app.Application;

import hu.bme.aut.booksearch.db.DBModule;
import hu.bme.aut.booksearch.network.NetworkModule;

public class BookSearchApplication extends Application {
    public static BookSearchApplicationComponent injector;

    @Override
    public void onCreate(){
        super.onCreate();

        injector =
                DaggerBookSearchApplicationComponent.builder().
                        dBModule(new DBModule((this))).
                        networkModule(new NetworkModule()).
                        build();
    }
}
