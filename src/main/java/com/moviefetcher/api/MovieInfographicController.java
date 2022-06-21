package com.moviefetcher.api;

import com.moviefetcher.api.json.InfographicJson;
import com.moviefetcher.api.json.MovieJson;
import com.moviefetcher.application.api.MovieInfographicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/infographics")
public class MovieInfographicController extends ErrorController {

    private final MovieInfographicsService service;

    @Autowired
    public MovieInfographicController(MovieInfographicsService service) {
        this.service = service;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InfographicJson> getInfographics() {
        return service.listInfographics().stream().map(JsonMapper::toJson).collect(Collectors.toList());
    }

    @GetMapping("/{infographicId}/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieJson> getTrendingByWeek(@PathVariable("infographicId") Long infographicId,
                                             @RequestParam("page") int page,
                                             @RequestParam("size") int size) {

        validatePageAndSize(page, size);

        return service.listByInfographicId(infographicId, page, size).stream().map(JsonMapper::toJson).collect(Collectors.toList());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create() {
        service.createInfographic();
    }

    private void validatePageAndSize(int page, int size) {
        if (page > 5 || page < 1) {
            throw new IllegalArgumentException("Page is invalid");
        }

        if (size > 100 || size < 1) {
            throw new IllegalArgumentException("Size is invalid");
        }
    }

}
