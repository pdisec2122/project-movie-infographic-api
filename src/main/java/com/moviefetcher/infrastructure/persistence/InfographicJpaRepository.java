package com.moviefetcher.infrastructure.persistence;

import com.moviefetcher.application.domain.Infographic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InfographicJpaRepository extends JpaRepository<Infographic, Long> {

    boolean existsByCreationDate(LocalDate creationDate);
}
