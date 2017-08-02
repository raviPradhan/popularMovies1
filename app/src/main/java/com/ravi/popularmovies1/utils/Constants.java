package com.ravi.popularmovies1.utils;

public class Constants {

    static final int TIMEOUT_CONNECTION = 30000;
    static final int TIMEOUT_SOCKET = 30000;

    private static final String BASE_URL = "http://api.themoviedb.org/3/movie/";
    public static final String POPULAR_URL = BASE_URL + "popular?";
    public static final String TOP_RATED_URL = BASE_URL + "top_rated?";
    public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185";
}
