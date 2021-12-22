package com.model.impl;

import com.dto.MovieDto;
import com.dto.MovieExtendedInformationDto;
import com.dto.MovieRequestData;
import com.entity.Currency;
import com.entity.Movie;
import com.entity.SortMethod;
import com.model.CurrencyService;
import com.model.MovieService;
import com.model.mapper.MovieMapper;
import com.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieDao;
    private final MovieMapper movieMapper;
    private final CurrencyService currencyService;

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
            String ratingRequestInfo = movieRequestData.getRatingRequestInfo();
           result = SortMethod.valueOfIgnoreCase(ratingRequestInfo).getMethod().equalsIgnoreCase("ASC")?
            movieDao.getAllMoviesSorted(Sort.by("rating").ascending()):
            movieDao.getAllMoviesSorted(Sort.by("rating").descending());
        } else if (movieRequestData.getPriceRequestInfo() != null) {
            String priceRequestInfo = movieRequestData.getPriceRequestInfo();
            result = SortMethod.valueOfIgnoreCase(priceRequestInfo).getMethod().equalsIgnoreCase("ASC")?
                    movieDao.getAllMoviesSorted(Sort.by("price").ascending()):
                    movieDao.getAllMoviesSorted(Sort.by("price").descending());
        } else {
            result = movieDao.getAllMovies();
        }
        return result;
    }

    @Override
    public List<MovieDto> getMoviesByGenreId(MovieRequestData movieRequestData) {
        log.info("Ger movies with genre id {}", movieRequestData.getGenreId());
        Long genreId = movieRequestData.getGenreId();
        List<MovieDto> result;
        if (movieRequestData.getRatingRequestInfo() != null) {
            String ratingRequestInfo = movieRequestData.getRatingRequestInfo();
            result = SortMethod.valueOfIgnoreCase(ratingRequestInfo).getMethod().equalsIgnoreCase("ASC")?
                    movieDao.getMoviesByGenreIdSorted(genreId, Sort.by("rating").ascending()):
                    movieDao.getMoviesByGenreIdSorted(genreId, Sort.by("rating").descending());
        } else if (movieRequestData.getPriceRequestInfo() != null) {
            String priceRequestInfo = movieRequestData.getPriceRequestInfo();
            result = SortMethod.valueOfIgnoreCase(priceRequestInfo).getMethod().equalsIgnoreCase("ASC")?
            movieDao.getMoviesByGenreIdSorted(genreId, Sort.by("price").ascending()):
            movieDao.getMoviesByGenreIdSorted(genreId, Sort.by("price").descending());
        } else {
            result = movieDao.getMoviesByGenreId(movieRequestData.getGenreId());
        }
        return result;
    }

    public MovieExtendedInformationDto getMovieById(MovieRequestData movieRequestData) {
        Movie movieById = movieDao.findById(movieRequestData.getMovieId())
                .orElseThrow(()-> new RuntimeException("Film by id not present"));
        if (movieRequestData.getCurrencyInfo() != null) {
            Currency currency = Currency.getCurrencyIgnoreCase(movieRequestData.getCurrencyInfo());
            movieById.setPrice(currencyService.convertFromUah(movieById.getPrice(), currency));
        }
        return movieMapper.mapToMovieExtendedInformationDto(movieById);
    }
}
