package com.example.jworrell_cis651_project_2.ui.MovieDetail;

import static com.example.jworrell_cis651_project_2.Movies.getMovies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.jworrell_cis651_project_2.MovieModel;

import java.util.ArrayList;

public class DetailAdapter extends FragmentStateAdapter{

    ArrayList<MovieModel> movies = getMovies();
    public DetailAdapter(MovieDetailFragment movObj) {
        super(movObj);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
       Fragment detFrag = new MovieDetailObjectFragment();
       Bundle det = new Bundle();
       det.putString("Input1", movies.get(position).getTitle());
       det.putInt("Input2", movies.get(position).getMovieBox());
       det.putString("Input3", movies.get(position).getDate());
       det.putString("Input4", movies.get(position).getRating());
       det.putString("Input5", movies.get(position).getDisc());
       det.putString("Input6", String.valueOf(movies.get(position).getStars()));
       detFrag.setArguments(det);
       return detFrag;
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }
}
