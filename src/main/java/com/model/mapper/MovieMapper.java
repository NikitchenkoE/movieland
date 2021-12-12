package com.model.mapper;

import com.dto.MovieDto;
import com.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDto mapToDto(Movie movie);
}
