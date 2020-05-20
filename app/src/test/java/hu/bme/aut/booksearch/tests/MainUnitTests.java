package hu.bme.aut.booksearch.tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static hu.bme.aut.booksearch.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import hu.bme.aut.booksearch.DaggerTestComponent;
import hu.bme.aut.booksearch.interactor.WelcomeTextInteractor;
import hu.bme.aut.booksearch.ui.main.MainFragment;
import hu.bme.aut.booksearch.ui.main.MainPresenter;

@RunWith(RobolectricTestRunner.class)
public class MainUnitTests {
    @Inject
    MainPresenter mainPresenter;

    @Inject
    MainFragment mainFragment;

    private WelcomeTextInteractor welcomeTextInteractor;


    @Before
    public void setup(){
        DaggerTestComponent injector = setTestInjector();
        injector.inject(this);

        welcomeTextInteractor=mock(WelcomeTextInteractor.class);
        when(welcomeTextInteractor.getWelcomeText()).thenReturn("Hello");

        mainPresenter.attachScreen(mainFragment);

    }

    @Test
    public void testWelcome(){
        mainPresenter.showWelcomeText();
        verify(mainFragment).showWelcomeText("Hello");
    }

    @After
    public void tearDown(){
        mainPresenter.detachScreen();
    }
}
