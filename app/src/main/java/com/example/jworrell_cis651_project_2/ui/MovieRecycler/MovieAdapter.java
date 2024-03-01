package com.example.jworrell_cis651_project_2.ui.MovieRecycler;

import static com.example.jworrell_cis651_project_2.Movies.getMovies;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jworrell_cis651_project_2.MovieModel;
import com.example.jworrell_cis651_project_2.R;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

// This code adapts the movie data for the recylerview.
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>{
    private ArrayList<MovieModel> movies  = getMovies();
    private MovieModel movieHolder;
    private ImageView img;
    private  Context context;
    @SuppressLint("CutPasteId")
    public MovieAdapter(@NonNull View itemView) throws MalformedURLException {
        this.img = itemView.findViewById(R.id.movie_image);
    }
    @Override
    @NonNull
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.movie_card, parent, false);
        return new MovieHolder(view);
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        // makes the tile a movie poster.
        holder.getImg().setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), movies.get(position).getMovieBox(), null));

        // onClick listener for the popUp
        holder.itemView.setOnClickListener(v -> {
            // This bit makes the tiles rotate.
            movieHolder = movies.get(position);
            Collections.rotate(movies.subList(position, getItemCount()), -1);
            notifyItemMoved(position, getItemCount() - 1);

            // The -ness of the popup
            final Dialog moviePopup = new Dialog(v.getContext(), R.style.Theme_JWorrell_CIS651_Project_2_PopupOverlay);
            moviePopup.setContentView(R.layout.detail_card);

            // Initializes View items in movie_detail fragment.
            TextView title = moviePopup.requireViewById(R.id.movie_detail_title);
            TextView stars = moviePopup.requireViewById(R.id.movie_detail_stars);
            TextView rating = moviePopup.requireViewById(R.id.movie_detail_rating);
            TextView date = moviePopup.requireViewById(R.id.movie_detail_date);
            TextView description = moviePopup.requireViewById(R.id.movie_detail_description);
            ImageView poster = moviePopup.requireViewById(R.id.movie_detail_poster);

            // Populates data in detail views.
            title.setText(movieHolder.getTitle());
            stars.setText(String.valueOf(movieHolder.getStars()));
            rating.setText(movieHolder.getRating());
            date.setText(movieHolder.getDate());
            description.setText(movieHolder.getDisc());
            poster.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), movieHolder.getMovieBox(), null));

            //popup background is not allowed to be null
            Objects.requireNonNull(moviePopup.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));

            //makes it possible  to close the popUp and also show()
            moviePopup.setCancelable(true);
            moviePopup.setCanceledOnTouchOutside(true);
            moviePopup.show();

        });
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }
    public static class MovieHolder extends RecyclerView.ViewHolder {
        private final ImageView img;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            this.img = itemView.findViewById(R.id.movie_image);
        }
        public ImageView getImg() {
            return img;
        }
    }
}
