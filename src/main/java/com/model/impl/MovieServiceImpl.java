package com.model.impl;

import com.dto.MovieDto;
import com.dto.MovieRequestData;
import com.model.MovieService;
import com.model.mapper.MovieMapper;
import com.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieDao;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> getAllMovies(MovieRequestData movieRequestData) {
        log.info("Get all movies");
        if (Objects.equals(movieRequestData.getRatingRequestInfo(), "desc")) {
            return movieMapper.mapListMovieToMovieDto(movieDao.getAllMoviesSortedByRating());
        } else {
            return movieMapper.mapListMovieToMovieDto(movieDao.getAllMovies());
        }
    }

    public List<MovieDto> getRandomMovies(MovieRequestData movieRequestData) {
        log.info("Ger {} random movie", movieRequestData.getCountOfRandomMovies());
        return movieMapper.mapListMovieToMovieDto(movieDao.getRandomMovies(movieRequestData.getCountOfRandomMovies()));
    }

    public List<MovieDto> getMoviesByGenreId(MovieRequestData movieRequestData) {
        log.info("Ger movies with genre id {}", movieRequestData.getGenreId());
        if (Objects.equals(movieRequestData.getRatingRequestInfo(), "desc")) {
            return movieMapper.mapListMovieToMovieDto(movieDao.getMoviesByGenreIdSortedByRating(movieRequestData.getGenreId()));
        }
        return movieMapper.mapListMovieToMovieDto(movieDao.getMoviesByGenreId(movieRequestData.getGenreId()));
    }
}
