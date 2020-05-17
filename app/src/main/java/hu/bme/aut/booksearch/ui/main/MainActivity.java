package hu.bme.aut.booksearch.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import hu.bme.aut.booksearch.R;
import hu.bme.aut.booksearch.ui.fav.FavFragment;
import hu.bme.aut.booksearch.ui.search.SearchFragment;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView nav_view = findViewById(R.id.nav_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MainFragment()).commit();

        nav_view.setCheckedItem(R.id.main_fragment);

        nav_view.setNavigationItemSelectedListener(this);
    }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.nav_main:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
                    break;
                case R.id.nav_fav:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FavFragment()).commit();
                    break;
                case R.id.nav_search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
                    break;
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    public void showSnackbar(String text){
        Snackbar.make(drawerLayout,
                text,
                Snackbar.LENGTH_LONG
        ).setAction(R.string.action_hide, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        }).show();
    }
}
