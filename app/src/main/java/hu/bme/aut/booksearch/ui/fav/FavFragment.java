package hu.bme.aut.booksearch.ui.fav;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;
import hu.bme.aut.booksearch.R;
import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.ui.main.MainActivity;
import hu.bme.aut.booksearch.utilities.Utilities;


public class FavFragment extends Fragment implements FavScreen{

    @Inject
    FavPresenter favPresenter;
    RecyclerView recycleViewBooksFav;
    List<Book> booksList;

    @Inject
    FavAdapter favAdapter;

    public FavFragment() {
        // Required empty public constructor
        BookSearchApplication.injector.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_fav, container, false);

        booksList = new ArrayList<Book>();
        favAdapter.setBookList(booksList);
        favAdapter.setFavFragment(this);

        recycleViewBooksFav = (RecyclerView) view.findViewById(
                R.id.recyclerViewFavBooks);
        recycleViewBooksFav.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recycleViewBooksFav.setAdapter(favAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        favPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        favPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public void onResume(){
        super.onResume();
        favPresenter.getBooks();
    }

    @Override
    public void getBooks(List<Book> books) {
        booksList.clear();
        booksList.addAll(books);
        favAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoreInfo(String uri){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(uri));
        startActivity(i);
    }

    private int removeIndex;
    @Override
    public void removeBook(Book b, int index){
        favPresenter.removeFromFavs(b);
        removeIndex=index;
    }

    @Override
    public void removedBook(String result){
        if(result.equals(Utilities.REMOVED)) favAdapter.removeBook(removeIndex);
        MainActivity activity =(MainActivity) getActivity();
        activity.showSnackbar(result);
    }
}
