package hu.bme.aut.booksearch.ui.search;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;
import hu.bme.aut.booksearch.R;
import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.ui.fav.FavActivity;
import hu.bme.aut.booksearch.ui.main.MainActivity;

public class SearchActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SearchScreen {


    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private RecyclerView recycleViewBooksFound;
    private List<Book> booksList;
    private RadioButton byTitleRBtn;
    private RadioButton byAuthorRBtn;
    private EditText searchValue;
    @Inject
    SearchAdapter searchAdapter;
    @Inject
    SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BookSearchApplication.injector.inject(this);

        booksList = new ArrayList<Book>();

        byTitleRBtn=findViewById((R.id.searchBookTitle));
        byAuthorRBtn=findViewById(R.id.searchBookAuthor);
        searchValue=findViewById(R.id.searchBookValue);
        Button searchBtn=findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPresenter.getBooks(byTitleRBtn.isChecked(), byAuthorRBtn.isChecked(),searchValue.getText().toString());
            }
        });

        searchAdapter.setBookList(booksList);
        searchAdapter.setActivityContext(this);

        recycleViewBooksFound = (RecyclerView) findViewById(
                R.id.recyclerViewFoundBooks);
        recycleViewBooksFound.setLayoutManager(new LinearLayoutManager(this));
        recycleViewBooksFound.setAdapter(searchAdapter);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.nav_main:
                Intent intent0=new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent0);
                break;
            case R.id.nav_search:
                //do nothing, this is the proper view
                break;
            case R.id.nav_fav:
                Intent intent2= new Intent(SearchActivity.this, FavActivity.class);
                startActivity(intent2);
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        searchPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        searchPresenter.detachScreen();
    }

    @Override
    public void onResume(){
        super.onResume();
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
        Snackbar.make(drawer,
                result,
                Snackbar.LENGTH_LONG
        ).setAction(R.string.action_hide, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        }).show();
    }
}
