package com.moviefetcher.api.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MovieJson {

    private final Long id;
    @JsonProperty("backdrop_path")
    private final String backDropPath;
    @JsonProperty("poster_path")
    private final String posterPath;
    private final String overview;
    @JsonProperty("genre_ids")
    private final List<Integer> genres = new ArrayList<>();
    @JsonProperty("original_title")
    private final String originalTitle;
    private final String name;
    @JsonProperty("original_name")
    private final String originalName;
    private final String title;
    @JsonProperty("vote_count")
    private final int voteCount;
    @JsonProperty("vote_average")
    private final BigDecimal voteAverage;

    private MovieJson(Builder builder) {
        this.id = builder.id;
        this.backDropPath = builder.backDropPath;
        this.posterPath = builder.posterPath;
        this.overview = builder.overview;
        this.genres.addAll(builder.genres);
        this.originalTitle = builder.originalTitle;
        this.name = builder.name;
        this.title = builder.title;
        this.originalName = builder.originalName;
        this.voteCount = builder.voteCount;
        this.voteAverage = builder.voteAverage;
    }

    public Long getId() {
        return id;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getTitle() {
        return title;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public BigDecimal getVoteAverage() {
        return voteAverage;
    }

    public static final class Builder {
        private Long id;
        private String backDropPath;
        private String posterPath;
        private String overview;
        private List<Integer> genres = new ArrayList<>();
        private String originalTitle;
        private String name;
        private String originalName;
        private String title;
        private int voteCount;
        private BigDecimal voteAverage;

        private Builder() {
        }

        public static Builder with() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder posterPath(String posterPath) {
            this.posterPath = posterPath;
            return this;
        }

        public Builder backDropPath(String backDropPath) {
            this.backDropPath = backDropPath;
            return this;
        }

        public Builder overview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder genres(List<Integer> genres) {
            this.genres = genres;
            return this;
        }

        public Builder originalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
            return this;
        }

        public Builder originalName(String originalName) {
            this.originalName = originalName;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder voteCount(int voteCount) {
            this.voteCount = voteCount;
            return this;
        }

        public Builder voteAverage(BigDecimal voteAverage) {
            this.voteAverage = voteAverage;
            return this;
        }

        public MovieJson build() {
            return new MovieJson(this);
        }
    }
}
