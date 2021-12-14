package com.model.impl;

import com.dto.GenreDto;
import com.model.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CachedGenreServiceImpl implements GenreService {
    private final GenreServiceImpl genreService;
    private List<GenreDto> genreCache = new ArrayList<>();

    public List<GenreDto> getAllGenreDto() {
        log.info("get cached list of GenreDto");
        if (genreCache.isEmpty()) {
            genreCache = genreService.getAllGenreDto();
        }
        return genreCache;
    }

    @Scheduled(fixedDelay = 4 * 60 * 60 * 1000)
    public void clearGenreCache() {
        genreCache.clear();
        log.info("genre cache cleared");
    }
}
