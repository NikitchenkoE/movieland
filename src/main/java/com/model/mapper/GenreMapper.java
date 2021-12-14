package com.model.mapper;

import com.dto.GenreDto;
import com.entity.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    List<GenreDto> mapListGenreToGenreDto(List<Genre> genreList);
}
