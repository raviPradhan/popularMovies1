package com.ravi.popularmovies1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ravi.popularmovies1.model.Movies;

import java.util.ArrayList;

class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movies> movieList;

    /**
     * Creates a MovieAdapter.
     *
     * @param clickHandler The on-click handler for this adapter. This single handler is called
     *                     when an item is clicked.
     */
    MovieAdapter(ArrayList<Movies> list, OnClickHandler clickHandler) {
        this.movieList = list;
        mClickHandler = clickHandler;
    }

    /*
     * An on-click handler that I have defined to make it easy for an Activity to interface with
     * movie list RecyclerView
     */
    private final OnClickHandler mClickHandler;

    /**
     * The interface that receives onClick messages.
     */
    interface OnClickHandler {
        void onClick(Movies movie);
    }

    /**
     * Cache of the children views for a movie list item.
     */
    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final ImageView moviePoster;
        Context context;

        MovieViewHolder(View view) {
            super(view);
            moviePoster = (ImageView) view.findViewById(R.id.iv_grid_item_poster);
            context = view.getContext();
            view.setOnClickListener(this);
        }

        /**
         * This gets called by the child views during a click.
         *
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Movies selectedMovie = movieList.get(adapterPosition);
            mClickHandler.onClick(selectedMovie);
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movies currentItem = movieList.get(position);
        Glide.with(holder.context).load(currentItem.getPosterPath()).into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        if (null == movieList) return 0;
        return movieList.size();
    }

    /**
     * This method is used to set the movie list on a GridAdapter if we've already
     * created one. This is handy when we get new data from the web but don't want to create a
     * new GridAdapter to display it.
     */
    void setMovieData() {
        notifyDataSetChanged();
    }
}
