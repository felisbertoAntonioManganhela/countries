package com.soft2ibi.countries.service;

import com.soft2ibi.countries.model.CountryEntity;
import com.soft2ibi.countries.model.dto.CountryDTO;

public interface ICountryService {
    CountryEntity createCountry(CountryDTO country);
}
