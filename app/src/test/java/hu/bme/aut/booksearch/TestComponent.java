package hu.bme.aut.booksearch;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.booksearch.mock.MockDBModule;
import hu.bme.aut.booksearch.mock.MockNetworkModule;
import hu.bme.aut.booksearch.network.NetworkModule;
import hu.bme.aut.booksearch.tests.MainUnitTests;

@Singleton
@Component(modules = {MockNetworkModule.class, MockDBModule.class})
public interface TestComponent extends BookSearchApplicationComponent {
    void inject(MainUnitTests  mainUnitTests);
}
