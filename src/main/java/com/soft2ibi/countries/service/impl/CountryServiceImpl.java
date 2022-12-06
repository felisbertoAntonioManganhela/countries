package com.soft2ibi.countries.service.impl;

import com.soft2ibi.countries.exception.BusinessException;
import com.soft2ibi.countries.model.CountryEntity;
import com.soft2ibi.countries.model.dto.CountryDTO;
import com.soft2ibi.countries.repository.CountryRepository;
import com.soft2ibi.countries.service.ICountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CountryEntity createCountry(CountryDTO country) {

        if(this.countryRepository.findByName(country.getName()) != null){
            throw new BusinessException("Country with this name already exists");
        }

        CountryEntity countryEntity = modelMapper.map(country, CountryEntity.class);
        return this.countryRepository.save(countryEntity);
    }

    @Override
    public List<CountryEntity> getCountries() {
        return (List<CountryEntity>)this.countryRepository.findAll();
    }

}





