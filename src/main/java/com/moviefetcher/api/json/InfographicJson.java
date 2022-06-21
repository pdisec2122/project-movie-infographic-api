package com.moviefetcher.api.json;

import java.time.LocalDate;

public class InfographicJson {

    private final Long id;
    private final LocalDate creationDate;

    private InfographicJson(Long id, LocalDate creationDate) {
        this.creationDate = creationDate;
        this.id = id;
    }

    public static InfographicJson from(Long id, LocalDate creationDate) {
        return new InfographicJson(id, creationDate);
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
