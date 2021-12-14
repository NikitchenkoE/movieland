package com.model.mapper;

import com.dto.MovieDto;
import com.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    List<MovieDto> mapListMovieToMovieDto(List<Movie> movieList);
}
