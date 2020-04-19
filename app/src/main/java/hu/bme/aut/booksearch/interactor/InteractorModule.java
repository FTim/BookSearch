package hu.bme.aut.booksearch.interactor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public WelcomeTextInteractor provideWelcomeTextInteractor(){return new WelcomeTextInteractor();}

    @Provides
    public BookSearchInteractor provideBookSearchInteractor(){return new BookSearchInteractor();}

    @Provides
    public BookFavInteractor provideBookFavInteractor(){return new BookFavInteractor();}
}
