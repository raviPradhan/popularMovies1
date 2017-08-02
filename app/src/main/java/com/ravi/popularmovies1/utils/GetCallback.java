package com.ravi.popularmovies1.utils;

import android.content.Context;

import com.ravi.popularmovies1.model.Movies;

import java.util.ArrayList;

public interface GetCallback {
    void onSuccess(Context context, ArrayList<Movies> movieList);
    void onFailure(Context context, String errorMessage);
}
