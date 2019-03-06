package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    String posterPath;
    String title;
    String overview;
    double voteAverage;
    int movieId;
    Double popularity;
    String releaseDate;

    // empty constructor needed by the Parceler library
    public Movie() {
    }

    private Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        voteAverage = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
        popularity = jsonObject.getDouble("popularity");
        releaseDate = jsonObject.getString("release_date");
    }

    public String getPosterPath() {
        return  posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i=0;i<movieJsonArray.length();i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public float getVoteAverage() {
        return (float)voteAverage;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getPopularity() {
        return popularity.toString();
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
