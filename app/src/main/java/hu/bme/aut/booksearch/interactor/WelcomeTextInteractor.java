package hu.bme.aut.booksearch.interactor;


import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;

public class WelcomeTextInteractor {
    @Inject
    public WelcomeTextInteractor(){
        BookSearchApplication.injector.inject(this);
    }

    public String getWelcomeText(){
        //TODO: API call if needed for this feature...
        return "Books are good";
    }
}
