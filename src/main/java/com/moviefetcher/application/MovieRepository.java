package com.moviefetcher.application;

import com.moviefetcher.application.domain.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> listByInfographicId(Long infographicId, int page, int size);
}
