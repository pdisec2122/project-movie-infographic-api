package com.moviefetcher.application.infographic_creator;

import com.moviefetcher.application.InfographicRepository;
import com.moviefetcher.application.MovieFetcher;
import com.moviefetcher.application.domain.Infographic;
import com.moviefetcher.application.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class InfographicCreator {

    private final MovieFetcher fetcher;
    private final InfographicRepository repository;

    @Autowired
    public InfographicCreator(MovieFetcher fetcher, InfographicRepository repository) {
        this.fetcher = fetcher;
        this.repository = repository;
    }

    @Scheduled(fixedRate = 3600000)
    public void createInfographic() {

        System.out.println("Initiating schedule job:");

        var todayInfographicsAlreadyExists = repository.existsByCreationDate(LocalDate.now());

        if (todayInfographicsAlreadyExists) {
            System.out.println("Skipping Infographic creation, already exists one today.");

        } else {
            System.out.println("Creating today's Infographic");

            List<Movie> movies = fetcher.fetchMovies();

            var infographic = Infographic.fromNow(movies);

            repository.save(infographic);
        }
    }
}
