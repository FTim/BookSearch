package hu.bme.aut.booksearch.ui.fav;

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
public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTV;
        public TextView authorTV;
        public TextView subtitleTV;
        public TextView yearTV;
        public Button infoBtn;
        public Button removeBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            titleTV = (TextView) itemView.findViewById(R.id.favBookTitle);
            authorTV = (TextView) itemView.findViewById(R.id.favBookAuthor);
            subtitleTV = (TextView) itemView.findViewById(R.id.favBookSubitle);
            yearTV = (TextView) itemView.findViewById(R.id.favBookYear);
            infoBtn = (Button) itemView.findViewById(R.id.favBookInfo);
            removeBtn = (Button) itemView.findViewById(R.id.favBookRemoveFav);
        }
    }
    private List<Book> booksList;
    //private Context context;
    private FavFragment favFragment;

    public void setFavFragment(FavFragment favFragment){
        this.favFragment=favFragment;
    }

    @Inject
    public FavAdapter(){
    }

    public void setBookList(List<Book> booksList){this.booksList=booksList;}
    //public void setActivityContext(Context context){this.context=context;}

    @Override
    public FavAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_favbook, viewGroup, false);
        FavAdapter.ViewHolder vh = new FavAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final FavAdapter.ViewHolder viewHolder, final int position) {
        viewHolder.authorTV.setText(booksList.get(position).getAuthors());
        viewHolder.titleTV.setText(booksList.get(position).getTitle());
        viewHolder.subtitleTV.setText(booksList.get(position).getSubtitle());
        viewHolder.yearTV.setText(booksList.get(position).getFirstPublishYearString());

        viewHolder.infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favFragment.showMoreInfo(booksList.get(viewHolder.getPosition()).getInfoUrl());
            }
        });
        viewHolder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favFragment.removeBook(booksList.get(viewHolder.getPosition()), viewHolder.getPosition());
            }
        });
    }
    public void removeBook(int index) {
        booksList.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

}
