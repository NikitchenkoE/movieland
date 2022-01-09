package com.web.controller;

import com.dto.CountryDto;
import com.model.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/country")
    public List<CountryDto> getAllCountries() {
        return countryService.getAllCountries();
    }
}
