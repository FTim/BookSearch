package hu.bme.aut.booksearch.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;
import hu.bme.aut.booksearch.R;

public class MainFragment extends Fragment implements  MainScreen{
    @Inject
    MainPresenter mainPresenter;

    public MainFragment(){
        BookSearchApplication.injector.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void showWelcomeText(String text) {
        TextView welcomeTV= (TextView) getView().findViewById(R.id.WelcomeTV);
        welcomeTV.setText(text);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainPresenter.attachScreen(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.showWelcomeText();
    }

    @Override
    public void onDetach() {
        mainPresenter.detachScreen();
        super.onDetach();
    }
}
