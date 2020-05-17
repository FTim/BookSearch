package hu.bme.aut.booksearch.ui.search;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;
import hu.bme.aut.booksearch.R;
import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.ui.main.MainActivity;

import static android.support.v4.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements SearchScreen {
    private RecyclerView recycleViewBooksFound;
    private List<Book> booksList;
    private RadioButton byTitleRBtn;
    private RadioButton byAuthorRBtn;
    private EditText searchValue;
    @Inject
    SearchAdapter searchAdapter;

    @Inject
    SearchPresenter searchPresenter;


    public SearchFragment() {
        BookSearchApplication.injector.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        booksList = new ArrayList<Book>();

        byTitleRBtn=view.findViewById((R.id.searchBookTitle));
        byAuthorRBtn=view.findViewById(R.id.searchBookAuthor);
        searchValue=view.findViewById(R.id.searchBookValue);

        Button searchBtn=view.findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity =(MainActivity) getActivity();
                activity.hideKeyboard();
                searchPresenter.getBooks(byTitleRBtn.isChecked(), byAuthorRBtn.isChecked(),searchValue.getText().toString());
            }
        });

        searchAdapter.setBookList(booksList);
        //searchAdapter.setActivityContext(container.getContext());
        searchAdapter.setSearchFragment(this);

        recycleViewBooksFound = (RecyclerView) view.findViewById(
                R.id.recyclerViewFoundBooks);
        recycleViewBooksFound.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recycleViewBooksFound.setAdapter(searchAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        searchPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        searchPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public void getBooks(List<Book> books) {
        booksList.clear();
        booksList.addAll(books);
        searchAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoreInfo(String uri){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(uri));
        startActivity(i);
    }

    @Override
    public void addToFavs(Book book){
        searchPresenter.addToFavs(book);
    }

    @Override
    public void addedToFavs(String result) {
        MainActivity activity =(MainActivity) getActivity();
        activity.showSnackbar(result);
    }
}
