package com.model.impl;

import com.dto.MovieDto;
import com.model.MovieService;
import com.model.mapper.MovieMapper;
import com.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieDao;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> getAllMovies() {
        log.info("Get all movies");
        return movieDao.getAllMovies().stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<MovieDto> getRandomMovies(int count) {
        log.info("Ger {} random movie", count);
        return movieDao.getRandomMovies(count).stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<MovieDto> getMoviesByGenreId(Long id) {
        log.info("Ger movies with genre id {}", id);
        return movieDao.getMoviesByGenreId(id).stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
