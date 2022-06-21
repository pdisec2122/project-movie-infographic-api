package com.moviefetcher.infrastructure.moviefetcher;

import com.moviefetcher.infrastructure.moviefetcher.json.FetcherMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MovieFetcherClientImpl implements MovieFetcherClient {

    private final String baseUrl;
    private final String TRENDING_WEEK_URL = "/trending/movie/day";

    @Autowired
    public MovieFetcherClientImpl(@Value("${movie.fetcher.base.url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }


    @Override
    public List<FetcherMovie> fetchTrendingByWeek() {

        RestTemplate restTemplate = new RestTemplate();

        FetcherMovie[] result = restTemplate.getForEntity(baseUrl + TRENDING_WEEK_URL, FetcherMovie[].class)
                .getBody();

        return Arrays.asList(result);

    }

}
