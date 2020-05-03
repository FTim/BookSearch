package hu.bme.aut.booksearch.interactor;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.booksearch.network.BookSearchApi;

@Module
public class InteractorModule {
    @Inject
    BookSearchApi bookSearchApi;


    @Provides
    public WelcomeTextInteractor provideWelcomeTextInteractor(){return new WelcomeTextInteractor();}

    @Provides
    public BookSearchInteractor provideBookSearchInteractor(){return new BookSearchInteractor(bookSearchApi);}

    @Provides
    public BookFavInteractor provideBookFavInteractor(){return new BookFavInteractor();}
}
