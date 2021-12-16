package com.model.impl;

import com.dto.GenreDto;
import com.model.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CachedGenreServiceImpl implements GenreService {
    private final GenreService genreServiceImpl;
    private List<GenreDto> genreCache = new ArrayList<>();

    public List<GenreDto> getAllGenreDto() {
        log.info("get cached list of GenreDto");
        return new ArrayList<>(genreCache);
    }

    @Scheduled(fixedDelay = 4 * 60 * 60 * 1000)
    public void updateGenreCache() {
        genreCache.clear();
        loadCache();
        log.info("genre cache cleared");
    }

    @PostConstruct
    public void loadCache(){
        genreCache = genreServiceImpl.getAllGenreDto();
    }
}
