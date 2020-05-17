package hu.bme.aut.booksearch.ui.search;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hu.bme.aut.booksearch.R;
import hu.bme.aut.booksearch.model.Book;

@Singleton
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTV;
        public TextView authorTV;
        public TextView subtitleTV;
        public TextView yearTV;
        public Button infoBtn;
        public Button addBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            titleTV = (TextView) itemView.findViewById(R.id.foundBookTitle);
            authorTV = (TextView) itemView.findViewById(R.id.foundBookAuthor);
            subtitleTV = (TextView) itemView.findViewById(R.id.foundBookSubitle);
            yearTV = (TextView) itemView.findViewById(R.id.foundBookYear);
            infoBtn = (Button) itemView.findViewById(R.id.foundBookInfo);
            addBtn = (Button) itemView.findViewById(R.id.foundBookAddFav);
        }
    }

    private List<Book> booksList;
    private SearchFragment searchFragment;

    @Inject
    public SearchAdapter(){
    }

    /*public void setActivityContext(Context context){
        this.context=context;
    }*/
    public void setSearchFragment(SearchFragment searchFragment){
        this.searchFragment=searchFragment;
    }


    public void setBookList(List<Book> booksList) {
        this.booksList = booksList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_foundbook, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.authorTV.setText(booksList.get(position).getAuthors());
        viewHolder.titleTV.setText(booksList.get(position).getTitle());
        viewHolder.subtitleTV.setText(booksList.get(position).getSubtitle());
        viewHolder.yearTV.setText(booksList.get(position).getFirstPublishYearString());

        viewHolder.infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchFragment.showMoreInfo(booksList.get(viewHolder.getPosition()).getInfoUrl());
            }
        });
        viewHolder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchFragment.addToFavs(booksList.get(viewHolder.getPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }
}

