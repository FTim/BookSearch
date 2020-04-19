package hu.bme.aut.booksearch;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.booksearch.ui.UIModule;
import hu.bme.aut.booksearch.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface BookSearchApplicationComponent {
    void inject(MainActivity mainActivity);
}
