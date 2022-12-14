package com.soft2ibi.countries.service.impl;

import com.soft2ibi.countries.exception.BusinessException;
import com.soft2ibi.countries.model.CountryEntity;
import com.soft2ibi.countries.model.dto.CountryDTO;
import com.soft2ibi.countries.repository.CountryRepository;
import com.soft2ibi.countries.service.ICountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<CountryEntity> getCountries(int page,int size, String sort) {
        Sort sortPage =  Sort.by(sort).ascending();
        Pageable pageable = PageRequest.of(page, size, sortPage);

        Page<CountryEntity> countries = this.countryRepository.findAll(pageable);

        return  countries.getContent();
    }

    @Override
    public CountryEntity updateCountry(Long id, CountryDTO country)  {
        CountryEntity countryEntity = this.countryRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Country doesn't exist"));

        countryEntity.setName(country.getName());
        countryEntity.setCapital(country.getCapital());
        countryEntity.setRegion(country.getRegion());
        countryEntity.setSubregion(country.getSubregion());
        countryEntity.setArea(country.getArea());

        return this.countryRepository.save(countryEntity);
    }

    @Override
    public void deleteCountry(Long id) {
        this.countryRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Country doesn't exist"));

        this.countryRepository.deleteById(id);
    }

}





