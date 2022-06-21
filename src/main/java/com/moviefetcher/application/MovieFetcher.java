package com.moviefetcher.application;

import com.moviefetcher.application.domain.Movie;

import java.util.List;

public interface MovieFetcher {

    List<Movie> fetchMovies();
}
