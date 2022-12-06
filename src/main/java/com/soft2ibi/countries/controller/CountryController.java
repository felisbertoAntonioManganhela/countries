package com.soft2ibi.countries.controller;

import com.soft2ibi.countries.model.CountryEntity;
import com.soft2ibi.countries.model.dto.CountryDTO;
import com.soft2ibi.countries.service.ICountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = {"/v1/country"}, produces = {"application/json"})
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CountryDTO country) {
        CountryEntity countryEntity = this.countryService.createCountry(country);
        CountryDTO countryDTO = (CountryDTO)this.modelMapper.map(countryEntity, CountryDTO.class);
        return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.CREATED);
    }


}
