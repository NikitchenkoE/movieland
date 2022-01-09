package com.model.impl;

import com.dto.CountryDto;
import com.model.CountryService;
import com.model.mapper.CountryMapper;
import com.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryDto> getAllCountries() {
        return countryMapper.mapToCountryDto(countryRepository.findAll());
    }
}
