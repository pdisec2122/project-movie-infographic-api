package com.moviefetcher.infrastructure.persistence;

import com.moviefetcher.application.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieJpaRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByInfographic_IdOrderByVoteAverageDesc(Long infographicId, Pageable pageable);

}
