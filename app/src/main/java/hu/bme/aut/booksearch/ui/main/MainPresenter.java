package hu.bme.aut.booksearch.ui.main;

import javax.inject.Inject;

import hu.bme.aut.booksearch.interactor.WelcomeTextInteractor;
import hu.bme.aut.booksearch.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {
    private WelcomeTextInteractor welcomeTextInteractor;

    @Inject
    public MainPresenter(WelcomeTextInteractor welcomeTextInteractor){
        this.welcomeTextInteractor=welcomeTextInteractor;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showWelcomeText() {
        String text = welcomeTextInteractor.getWelcomeText();
        screen.showWelcomeText(text);
    }
}
