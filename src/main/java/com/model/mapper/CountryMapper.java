package com.model.mapper;

import com.dto.CountryDto;
import com.entity.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    List<CountryDto> mapToCountryDto(List<Country> country);
}
