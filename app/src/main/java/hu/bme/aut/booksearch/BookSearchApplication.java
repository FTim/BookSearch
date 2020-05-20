package hu.bme.aut.booksearch;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;


import android.app.Application;

import hu.bme.aut.booksearch.db.DBModule;
import hu.bme.aut.booksearch.network.NetworkModule;

public class BookSearchApplication extends Application {
    public static BookSearchApplicationComponent injector;

   /* private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;*/

    @Override
    public void onCreate(){
        super.onCreate();

        injector =
                DaggerBookSearchApplicationComponent.builder().
                        dBModule(new DBModule((this))).
                        networkModule(new NetworkModule()).
                        build();

        //sAnalytics = GoogleAnalytics.getInstance(this);

    }

    /*synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }*/

}
