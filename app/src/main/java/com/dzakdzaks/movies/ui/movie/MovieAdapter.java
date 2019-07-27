package com.dzakdzaks.movies.ui.movie;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.dzakdzaks.movies.R;
import com.dzakdzaks.movies.data.Movie;
import com.dzakdzaks.movies.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final Activity activity;
    private List<Movie> movies = new ArrayList<>();

    public MovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<Movie> getMovies() {
        return movies;
    }

    void setMovies(List<Movie> movieList) {
        if (movieList == null) return;
        this.movies.clear();
        this.movies.addAll(movieList);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.tvTitle.setText(getMovies().get(position).getMovieTitle());
        holder.tvDate.setText(getMovies().get(position).getMovieReleaseDate());
        holder.tvOverview.setText(getMovies().get(position).getMovieOverview());
        holder.tvVote.setText(getMovies().get(position).getMovieVote() + "/10");

        GlideApp.with(holder.itemView.getContext())
                .load(getMovies().get(position).getMovieImage())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_circle).error(R.drawable.ic_broken_image_black))
                .into(holder.imgPoster);
        GlideApp.with(holder.itemView.getContext())
                .load(getMovies().get(position).getMovieImage())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_circle).error(R.drawable.ic_broken_image_black))
                .into(holder.imgBg);

        holder.itemView.setOnClickListener(view ->
                Toast.makeText(activity, movies.get(position).getMovieTitle(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return getMovies().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvOverview;
        final TextView tvDate;
        final TextView tvVote;
        final ImageView imgPoster;
        final ImageView imgBg;

        MovieViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textMovieTitle);
            imgPoster = itemView.findViewById(R.id.imageMovie);
            imgBg = itemView.findViewById(R.id.imageMovieBg);
            tvOverview = itemView.findViewById(R.id.textMovieOverview);
            tvDate = itemView.findViewById(R.id.textMovieReleaseDate);
            tvVote = itemView.findViewById(R.id.textMovieVoteAverage);

        }
    }
}
