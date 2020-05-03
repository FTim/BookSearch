package hu.bme.aut.booksearch;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.booksearch.interactor.InteractorModule;
import hu.bme.aut.booksearch.network.NetworkModule;
import hu.bme.aut.booksearch.ui.UIModule;
import hu.bme.aut.booksearch.ui.fav.FavActivity;
import hu.bme.aut.booksearch.ui.main.MainActivity;
import hu.bme.aut.booksearch.ui.main.MainPresenter;
import hu.bme.aut.booksearch.ui.search.SearchActivity;
import hu.bme.aut.booksearch.ui.search.SearchPresenter;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, NetworkModule.class})
public interface BookSearchApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(SearchActivity searchActivity);

    void inject(FavActivity favActivity);
}
