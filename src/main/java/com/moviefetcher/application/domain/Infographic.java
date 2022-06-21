package com.moviefetcher.application.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "INFOGRAPHIC")
public class Infographic {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "INFOGRAPHIC_ID")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Movie> movies = new ArrayList<>();

    @Column(name = "CREATION_DATE", columnDefinition = "TIMESTAMP(6)")
    private LocalDate creationDate;

    private Infographic() {

    }

    private Infographic(List<Movie> movies, LocalDate creationDate) {
        this.movies = movies;
        this.creationDate = creationDate;

        this.movies.stream().forEach(movie -> movie.setInfographic(this));
    }

    public static Infographic fromNow(List<Movie> movies) {
        return new Infographic(movies, LocalDate.now());
    }

    public Long getId() {
        return id;
    }

    public List<Movie> getMovies() {
        return Collections.unmodifiableList(movies);
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
