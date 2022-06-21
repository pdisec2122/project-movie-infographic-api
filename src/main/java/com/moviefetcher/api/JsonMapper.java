package com.moviefetcher.api;

import com.moviefetcher.api.json.InfographicJson;
import com.moviefetcher.api.json.MovieJson;
import com.moviefetcher.application.domain.Infographic;
import com.moviefetcher.application.domain.Movie;

public class JsonMapper {

    public static InfographicJson toJson(Infographic infographic) {

        return InfographicJson.from(infographic.getId(), infographic.getCreationDate());

    }

    public static MovieJson toJson(Movie movie) {

        var builder = MovieJson.Builder.with();

        builder.id(movie.getMovieId());
        builder.backDropPath(movie.getBackDropPath());
        builder.posterPath(movie.getPosterPath());
        builder.overview(movie.getOverview());
        builder.genres(movie.getGenres());
        builder.originalTitle(movie.getOriginalTitle());
        builder.name(movie.getName());
        builder.originalName(movie.getOriginalName());
        builder.title(movie.getTitle());
        builder.voteCount(movie.getVoteCount());
        builder.voteAverage(movie.getVoteAverage());

        return builder.build();

    }

}
