package hu.bme.aut.booksearch.ui.fav;

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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.booksearch.BookSearchApplication;
import hu.bme.aut.booksearch.R;
import hu.bme.aut.booksearch.model.Book;
import hu.bme.aut.booksearch.ui.main.MainActivity;
import hu.bme.aut.booksearch.ui.search.SearchActivity;

public class FavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FavScreen {

    @Inject
    FavPresenter favPresenter;
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    RecyclerView recycleViewBooksFav;
    List<Book> booksList;

    @Inject
    FavAdapter favAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
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
        favAdapter.setBookList(booksList);
        favAdapter.setActivityContext(this);

        recycleViewBooksFav = (RecyclerView) findViewById(
                R.id.recyclerViewFavBooks);
        recycleViewBooksFav.setLayoutManager(new LinearLayoutManager(this));
        recycleViewBooksFav.setAdapter(favAdapter);

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
                Intent intent0=new Intent(FavActivity.this, MainActivity.class);
                startActivity(intent0);
                break;
            case R.id.nav_search:
                Intent intent1=new Intent(FavActivity.this, SearchActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_fav:
                //do nothing, this is the properview
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        favPresenter.attachScreen(this);
        favPresenter.getBooks();
    }

    @Override
    protected void onStop() {
        super.onStop();
        favPresenter.detachScreen();
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
        //TODO: pass correct url
        String url="https://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void removeBook(Book b, int index){
        favPresenter.removeFromFavs(b);
        favAdapter.removeBook(index);
        Snackbar.make(drawer,
                "Removed",
                Snackbar.LENGTH_LONG
        ).setAction(R.string.action_hide, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        }).show();
    }
}
