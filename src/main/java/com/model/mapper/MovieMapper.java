package com.model.mapper;

import com.entity.Movie;
import com.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDto mapToDto(Movie movie);
}
