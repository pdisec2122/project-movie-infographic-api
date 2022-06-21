package com.moviefetcher.infrastructure.persistence;

import com.moviefetcher.application.MovieRepository;
import com.moviefetcher.application.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieRepositoryImpl implements MovieRepository {

    private final MovieJpaRepository jpaRepository;

    @Autowired
    public MovieRepositoryImpl(MovieJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Movie> listByInfographicId(Long infographicId, int page, int size) {
        return jpaRepository.findAllByInfographic_IdOrderByVoteAverageDesc(infographicId, PageRequest.of(page - 1, size));
    }
}
