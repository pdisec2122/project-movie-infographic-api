package com.moviefetcher.infrastructure;

import com.moviefetcher.application.MovieFetcher;
import com.moviefetcher.application.domain.Movie;
import com.moviefetcher.infrastructure.moviefetcher.MovieFetcherClient;
import com.moviefetcher.infrastructure.moviefetcher.json.FetcherMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieFetcherImpl implements MovieFetcher {

    private final MovieFetcherClient client;

    @Autowired
    public MovieFetcherImpl(MovieFetcherClient tmdbClient) {
        this.client = tmdbClient;
    }

    @Override
    public List<Movie> fetchMovies() {
        return client.fetchTrendingByWeek().stream().map(this::toMovie).collect(Collectors.toList());
    }

    private Movie toMovie(FetcherMovie fetcherMovie) {
        Movie.Builder builder = Movie.Builder.with();

        builder.movieId(fetcherMovie.getId());
        builder.posterPath(fetcherMovie.getPosterPath());
        builder.backDropPath(fetcherMovie.getBackDropPath());
        builder.overview(fetcherMovie.getOverview());
        builder.genres(fetcherMovie.getGenres());
        builder.originalTitle(fetcherMovie.getOriginalTitle());
        builder.name(fetcherMovie.getName());
        builder.title(fetcherMovie.getTitle());
        builder.originalName(fetcherMovie.getOriginalName());
        builder.voteCount(fetcherMovie.getVoteCount());
        builder.voteAverage(fetcherMovie.getVoteAverage());

        return builder.build();
    }
}
