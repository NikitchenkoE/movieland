package com.model.impl;

import com.dto.GenreDto;
import com.model.GenreService;
import com.model.mapper.GenreMapper;
import com.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAllGenreDto() {
        return genreRepository.getAllGenres().stream()
                .map(genreMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
