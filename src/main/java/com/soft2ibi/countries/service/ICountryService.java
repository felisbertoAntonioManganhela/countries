package com.soft2ibi.countries.service;

import com.soft2ibi.countries.model.CountryEntity;
import com.soft2ibi.countries.model.dto.CountryDTO;

import java.util.List;

public interface ICountryService {
    CountryEntity createCountry(CountryDTO country);
    List<CountryEntity> getCountries();
    CountryEntity updateCountry(Long id, CountryDTO country);
}
