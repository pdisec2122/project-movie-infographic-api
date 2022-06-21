package com.moviefetcher.application.api;

import com.moviefetcher.application.domain.Infographic;
import com.moviefetcher.application.domain.Movie;

import java.util.List;

public interface MovieInfographicsService {

    List<Infographic> listInfographics();

    List<Movie> listByInfographicId(Long infographicId, int page, int size);

    void createInfographic();
}
