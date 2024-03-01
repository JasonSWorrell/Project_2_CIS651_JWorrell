package com.example.jworrell_cis651_project_2.ui.MovieDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.example.jworrell_cis651_project_2.R;

public class MovieDetailObjectFragment extends Fragment {
// this code is the Fragment Object we recreate in the replicated details.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_card, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle dets = getArguments();
        assert dets != null;
        ((TextView) view.findViewById(R.id.movie_detail_title)).setText(dets.getString("Input1"));
        ((ImageView) view.findViewById(R.id.movie_detail_poster)).setImageDrawable(ResourcesCompat.getDrawable(getResources(),dets.getInt("Input2"),null));
        ((TextView) view.findViewById(R.id.movie_detail_date)).setText(dets.getString("Input3"));
        ((TextView) view.findViewById(R.id.movie_detail_rating)).setText(dets.getString("Input4"));
        ((TextView) view.findViewById(R.id.movie_detail_description)).setText(dets.getString("Input5"));
        ((TextView) view.findViewById(R.id.movie_detail_stars)).setText(dets.getString("Input6"));
       }
}
