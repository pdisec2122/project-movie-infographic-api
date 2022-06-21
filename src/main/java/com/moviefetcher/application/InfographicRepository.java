package com.moviefetcher.application;

import com.moviefetcher.application.domain.Infographic;

import java.time.LocalDate;
import java.util.List;

public interface InfographicRepository {

    List<Infographic> getInfographics();

    Infographic save(Infographic entity);

    boolean existsByCreationDate(LocalDate creationDate);
}
