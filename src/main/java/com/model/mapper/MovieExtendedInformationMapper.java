package com.model.mapper;

import com.dto.MovieExtendedInformationDto;
import com.entity.MovieExtendedInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieExtendedInformationMapper {
    MovieExtendedInformationDto mapToMovieExtendedInformationDto(MovieExtendedInformation movieExtendedInformation);
}
