package com.dzakdzaks.movies.ui.tvshow;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.dzakdzaks.movies.R;
import com.dzakdzaks.movies.data.TvShow;
import com.dzakdzaks.movies.ui.detail.tvshow.DetailShowActivity;
import com.dzakdzaks.movies.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.MovieViewHolder> {

    private final Activity activity;
    private List<TvShow> movies = new ArrayList<>();

    public TvShowAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvShow> getMovies() {
        return movies;
    }

    void setMovies(List<TvShow> tvShowList) {
        if (tvShowList == null) return;
        this.movies.clear();
        this.movies.addAll(tvShowList);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.tvTitle.setText(getMovies().get(position).getTvShowTitle());
        holder.tvDate.setText(getMovies().get(position).getTvShowReleaseDate());
        holder.tvOverview.setText(getMovies().get(position).getTvShowOverview());
        holder.tvVote.setText(getMovies().get(position).getTvShowVote() + "/10");

        GlideApp.with(holder.itemView.getContext())
                .load(getMovies().get(position).getTvShowImage())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_circle).error(R.drawable.ic_broken_image_black))
                .into(holder.imgPoster);
        GlideApp.with(holder.itemView.getContext())
                .load(getMovies().get(position).getTvShowImage())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_circle).error(R.drawable.ic_broken_image_black))
                .into(holder.imgBg);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(activity, DetailShowActivity.class);
            intent.putExtra(DetailShowActivity.EXTRA_TV_SHOW, getMovies().get(position).getTvShowId());
            activity.startActivity(intent);
        });
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
