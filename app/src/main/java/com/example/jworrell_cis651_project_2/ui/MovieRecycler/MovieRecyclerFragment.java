package com.example.jworrell_cis651_project_2.ui.MovieRecycler;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jworrell_cis651_project_2.R;
import java.net.MalformedURLException;

public class MovieRecyclerFragment extends Fragment {
    private RecyclerView MRV;

    public MovieRecyclerFragment(){
        super(R.layout.movie_recycler);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        MRV = view.findViewById(R.id.movie_gallery);
        try {
            this.MRV.setAdapter(new MovieAdapter(view));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        this.MRV.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    }
}
