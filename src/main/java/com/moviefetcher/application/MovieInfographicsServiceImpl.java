package com.moviefetcher.application;

import com.moviefetcher.application.api.MovieInfographicsService;
import com.moviefetcher.application.domain.Infographic;
import com.moviefetcher.application.domain.Movie;
import com.moviefetcher.application.infographic_creator.InfographicCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieInfographicsServiceImpl implements MovieInfographicsService {

    private final InfographicRepository infographicRepository;
    private final MovieRepository movieRepository;
    private final InfographicCreator creator;

    @Autowired
    public MovieInfographicsServiceImpl(InfographicRepository infographicRepository, MovieRepository movieRepository, InfographicCreator creator) {
        this.infographicRepository = infographicRepository;
        this.movieRepository = movieRepository;
        this.creator = creator;
    }

    @Override
    public List<Infographic> listInfographics() {
        return infographicRepository.getInfographics();
    }

    @Override
    public List<Movie> listByInfographicId(Long infographicId, int page, int size) {
        return movieRepository.listByInfographicId(infographicId, page, size);
    }

    @Override
    public void createInfographic() {
        creator.createInfographic();
    }
}
