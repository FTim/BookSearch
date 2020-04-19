package hu.bme.aut.booksearch.interactor;

import javax.inject.Inject;

public class WelcomeTextInteractor {
    @Inject
    public WelcomeTextInteractor(){}

    public String getWelcomeText(){
        //TODO: API call if needed for this feature...
        return "Books are good";
    }
}
