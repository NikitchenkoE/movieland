package com.model.impl;

import com.repository.MovieRepository;
import com.dto.MovieDto;
import com.model.MovieService;
import com.model.mapper.MovieMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieDao;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> getAllMovies() {
        return movieDao.getAllMovies().stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<MovieDto> getRandomMovies(int count) {
        return movieDao.getRandomMovies(count).stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
