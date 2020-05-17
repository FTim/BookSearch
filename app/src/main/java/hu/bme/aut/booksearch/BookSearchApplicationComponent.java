package hu.bme.aut.booksearch;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.booksearch.db.DBModule;
import hu.bme.aut.booksearch.interactor.BookFavInteractor;
import hu.bme.aut.booksearch.interactor.BookSearchInteractor;
//import hu.bme.aut.booksearch.interactor.InteractorModule;
import hu.bme.aut.booksearch.interactor.WelcomeTextInteractor;
import hu.bme.aut.booksearch.network.BookSearchApi;
import hu.bme.aut.booksearch.network.NetworkModule;
import hu.bme.aut.booksearch.ui.UIModule;
//import hu.bme.aut.booksearch.ui.fav.FavActivity;
import hu.bme.aut.booksearch.ui.fav.FavFragment;
import hu.bme.aut.booksearch.ui.fav.FavPresenter;
import hu.bme.aut.booksearch.ui.main.MainActivity;
import hu.bme.aut.booksearch.ui.main.MainFragment;
import hu.bme.aut.booksearch.ui.main.MainPresenter;
//import hu.bme.aut.booksearch.ui.search.SearchActivity;
import hu.bme.aut.booksearch.ui.search.SearchFragment;
import hu.bme.aut.booksearch.ui.search.SearchPresenter;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, DBModule.class})
public interface BookSearchApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(MainFragment mainFragment);
    void inject(SearchFragment searchFragment);
    void inject(FavFragment favFragment);

    void inject(MainPresenter mainPresenter);
    void inject(SearchPresenter searchPresenter);
    void inject(FavPresenter favPresenter);

    void inject(BookSearchInteractor bookSearchInteractor);
    void inject(WelcomeTextInteractor welcomeTextInteractor);
    void inject(BookFavInteractor bookFavInteractor);

    void inject(BookSearchApi bookSearchApi);
}
