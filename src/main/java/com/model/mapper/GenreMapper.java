package com.model.mapper;

import com.dto.GenreDto;
import com.entity.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDto mapToDto(Genre genre);
}
