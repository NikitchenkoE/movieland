package com.model.impl;

import com.dto.MovieDto;
import com.dto.MovieExtendedInformationDto;
import com.dto.MovieRequestData;
import com.model.MovieService;
import com.model.mapper.MovieExtendedInformationMapper;
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
    private final MovieExtendedInformationMapper movieExtendedInformationMapper;

    @Override
    public List<MovieDto> getRandomMovies(MovieRequestData movieRequestData) {
        log.info("Ger {} random movie", movieRequestData.getCountOfRandomMovies());
        return movieMapper.mapListMovieToMovieDto(movieDao.getRandomMovies(movieRequestData.getCountOfRandomMovies()));
    }

    @Override
    public List<MovieDto> getAllMovies(MovieRequestData movieRequestData) {
        log.info("Get all movies");
        List<MovieDto> result;
        if (movieRequestData.getRatingRequestInfo() != null) {
            result = getAllMoviesOrderByRating(movieRequestData.getRatingRequestInfo());
        } else if (movieRequestData.getPriceRequestInfo() != null) {
            result = getAllMoviesOrderByPrice(movieRequestData.getPriceRequestInfo());
        } else {
            result = movieMapper.mapListMovieToMovieDto(movieDao.getAllMovies());
        }
        return result;
    }

    @Override
    public List<MovieDto> getMoviesByGenreId(MovieRequestData movieRequestData) {
        log.info("Ger movies with genre id {}", movieRequestData.getGenreId());
        List<MovieDto> result;
        if (movieRequestData.getRatingRequestInfo() != null) {
            result = getMoviesByGenreIdOrderByRating(movieRequestData.getGenreId(), movieRequestData.getRatingRequestInfo());
        } else if (movieRequestData.getPriceRequestInfo() != null) {
            result = getMoviesByGenreIdOrderByPrice(movieRequestData.getGenreId(), movieRequestData.getPriceRequestInfo());
        } else {
            result = movieMapper.mapListMovieToMovieDto(movieDao.getMoviesByGenreId(movieRequestData.getGenreId()));
        }
        return result;
    }

    public MovieExtendedInformationDto getMovieById(Long id) {
        return movieExtendedInformationMapper.mapToMovieExtendedInformationDto(movieDao.getMovieById(id));
    }

    private List<MovieDto> getAllMoviesOrderByRating(String ratingRequestInfo) {
        if (ratingRequestInfo.equalsIgnoreCase("desc")) {
            return movieMapper.mapListMovieToMovieDto(movieDao.getAllMoviesSortedByRating());
        } else {
            log.error("Bad movie request with rating parameter with value {}", ratingRequestInfo);
            throw new RuntimeException("Bad movie request with rating parameter");
        }
    }

    private List<MovieDto> getAllMoviesOrderByPrice(String priceRequestInfo) {
        if (priceRequestInfo.equalsIgnoreCase("desc")) {
            return movieMapper.mapListMovieToMovieDto(movieDao.getAllMoviesSortedByPriceDESC());
        } else if (priceRequestInfo.equalsIgnoreCase("asc")) {
            return movieMapper.mapListMovieToMovieDto(movieDao.getAllMoviesSortedByPriceASC());
        } else {
            log.error("Bad movie request with price parameter with value {}", priceRequestInfo);
            throw new RuntimeException("Bad movie request with price parameter");
        }
    }

    private List<MovieDto> getMoviesByGenreIdOrderByRating(Long id, String ratingRequestInfo) {
        if (ratingRequestInfo.equalsIgnoreCase("desc")) {
            return movieMapper.mapListMovieToMovieDto(movieDao.getMoviesByGenreIdSortedByRating(id));
        } else {
            log.error("Bad movie request with rating parameter with value {}", ratingRequestInfo);
            throw new RuntimeException("Bad movie request with rating parameter");
        }
    }

    private List<MovieDto> getMoviesByGenreIdOrderByPrice(Long id, String priceRequestInfo) {
        if (priceRequestInfo.equalsIgnoreCase("desc")) {
            return movieMapper.mapListMovieToMovieDto(movieDao.getMoviesByGenreIdSortedByPriceDESC(id));
        } else if (priceRequestInfo.equalsIgnoreCase("asc")) {
            return movieMapper.mapListMovieToMovieDto(movieDao.getMoviesByGenreIdSortedByPriceASC(id));
        } else {
            log.error("Bad movie request with price parameter with value {}", priceRequestInfo);
            throw new RuntimeException("Bad movie request with price parameter");
        }
    }
}
