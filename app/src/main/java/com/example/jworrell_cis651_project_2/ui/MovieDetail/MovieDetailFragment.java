package com.example.jworrell_cis651_project_2.ui.MovieDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.example.jworrell_cis651_project_2.R;

public class MovieDetailFragment extends Fragment {
    DetailAdapter DA;
    private
    ViewPager2 movieDetail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.movie_detail, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        DA = new DetailAdapter(this);
        movieDetail = view.findViewById(R.id.detail_pager);
        movieDetail.setAdapter(DA);
    }
}
