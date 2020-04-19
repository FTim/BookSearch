package hu.bme.aut.booksearch.ui;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;
    public UIModule(Context context){
        this.context=context;
    }

    @Provides
    public Context getContext() {
        return context;
    }
}
