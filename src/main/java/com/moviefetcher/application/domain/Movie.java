package com.moviefetcher.application.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "INFOGRAPHIC_ID", nullable = false)
    private Infographic infographic;

    @Column(name = "MOVIE_ID")
    private Long movieId;

    @Column(name = "BACK_DROP_PATH")
    private String backDropPath;

    @Column(name = "POSTER_PATH")
    private String posterPath;

    @Lob
    @Column(name = "OVERVIEW")
    private String overview;

    @ElementCollection
    @CollectionTable(name = "GENRES")
    private List<Integer> genres = new ArrayList<>();

    @Column(name = "ORIGINAL_TITLE")
    private String originalTitle;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ORIGINAL_NAME")
    private String originalName;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "VOTE_COUNT")
    private int voteCount;

    @Column(name = "VOTE_AVERAGE")
    private BigDecimal voteAverage;

    private Movie() {

    }

    private Movie(Builder builder) {
        this.movieId = builder.movieId;
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

    public Infographic getInfographic() {
        return infographic;
    }

    public Long getMovieId() {
        return movieId;
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

    public void setInfographic(Infographic infographic) {
        this.infographic = infographic;
    }

    public static final class Builder {
        private Long movieId;
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

        public Builder movieId(Long movieId) {
            this.movieId = movieId;
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

        public Movie build() {
            return new Movie(this);
        }
    }
}
