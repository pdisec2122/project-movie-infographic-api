package com.moviefetcher.infrastructure.persistence;

import com.moviefetcher.application.InfographicRepository;
import com.moviefetcher.application.domain.Infographic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class InfographicRepositoryImpl implements InfographicRepository {

    private final InfographicJpaRepository jpaRepository;

    @Autowired
    public InfographicRepositoryImpl(InfographicJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Infographic> getInfographics() {
        return jpaRepository.findAll();
    }

    @Override
    public Infographic save(Infographic entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public boolean existsByCreationDate(LocalDate creationDate) {
        return jpaRepository.existsByCreationDate(creationDate);
    }
}
