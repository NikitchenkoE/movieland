package com.model.impl;

import com.dto.MovieDto;
import com.model.MovieService;
import com.model.mapper.MovieMapper;
import com.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieDao;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> getAllMovies() {
        log.info("Get all movies");
        return movieMapper.mapListMovieToMovieDto(movieDao.getAllMovies());
    }

    public List<MovieDto> getRandomMovies(int count) {
        log.info("Ger {} random movie", count);
        return movieMapper.mapListMovieToMovieDto(movieDao.getRandomMovies(count));
    }

    public List<MovieDto> getMoviesByGenreId(Long id) {
        log.info("Ger movies with genre id {}", id);
        return movieMapper.mapListMovieToMovieDto(movieDao.getMoviesByGenreId(id));
    }
}
