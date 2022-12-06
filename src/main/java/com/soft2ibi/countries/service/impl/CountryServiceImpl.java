package com.soft2ibi.countries.service.impl;

import com.soft2ibi.countries.repository.CountryRepository;
import com.soft2ibi.countries.service.ICountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

}





