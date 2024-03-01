package com.example.jworrell_cis651_project_2;

import android.graphics.drawable.Drawable;

public class MovieModel{
        private String title;
        private String date;
        private int stars;
        private String disc;
        private String rating;
        private int movieBox;

        public MovieModel(String title, String date, int stars, String disc, String rating, int movieBox){
            this.title = title;
            this.date = date;
            this.stars = stars;
            this.disc = disc;
            this.rating = rating;
            this.movieBox = movieBox;
        }
        public String getTitle(){
            return title;
        }
        public String getDate(){
            return date;
        }
        public int getStars(){
            return stars;
        }
        public String getDisc(){
            return disc;
        }
        public String getRating(){
            return rating;
        }
        public int getMovieBox(){
            return movieBox;
        }
}
