package hu.bme.aut.booksearch.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.booksearch.network.Network;
import hu.bme.aut.booksearch.ui.main.MainPresenter;

@Module
public class UIModule {
    private Context context;
    //private MainPresenter mainPresenter;
    public UIModule(Context context
            //, MainPresenter mainPresenter
    ){
        this.context=context;
        //this.mainPresenter=mainPresenter;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }


   // @Provides
    //public MainPresenter provideMainPresenter(){return  this.mainPresenter;}
}
