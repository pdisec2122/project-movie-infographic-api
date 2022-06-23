package com.moviefetcher.infrastructure.persistence;

import com.moviefetcher.application.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieJpaRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByInfographic_IdOrderByVoteAverageDesc(Long infographicId, Pageable pageable);

    @Modifying
    @Query("delete from Movie movie where movie.infographic.id = :infographicId")
    void deleteAllByInfographic_Id(@Param("infographicId") Long infographicId);
}
