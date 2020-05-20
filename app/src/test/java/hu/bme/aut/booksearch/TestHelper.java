package hu.bme.aut.booksearch;

import org.robolectric.RuntimeEnvironment;

import hu.bme.aut.booksearch.mock.MockDBModule;
import hu.bme.aut.booksearch.mock.MockNetworkModule;

public class TestHelper {

    public static DaggerTestComponent setTestInjector() {
		BookSearchApplication application = (BookSearchApplication) RuntimeEnvironment.application;
		BookSearchApplicationComponent injector = DaggerTestComponent.builder().
				mockDBModule(new MockDBModule(application)).
				mockNetworkModule(new MockNetworkModule()).
				build();
		application.injector = injector;
        return (DaggerTestComponent) injector;
	}
}