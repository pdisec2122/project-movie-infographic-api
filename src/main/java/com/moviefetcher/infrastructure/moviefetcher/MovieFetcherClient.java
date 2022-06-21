package com.moviefetcher.infrastructure.moviefetcher;

import com.moviefetcher.infrastructure.moviefetcher.json.FetcherMovie;

import java.util.List;

public interface MovieFetcherClient {

    List<FetcherMovie> fetchTrendingByWeek();

}
