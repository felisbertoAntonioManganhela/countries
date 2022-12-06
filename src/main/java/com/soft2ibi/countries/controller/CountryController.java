package com.soft2ibi.countries.controller;

import com.soft2ibi.countries.model.CountryEntity;
import com.soft2ibi.countries.model.dto.CountryDTO;
import com.soft2ibi.countries.service.ICountryService;
import com.soft2ibi.countries.utils.AppConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getCountries(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int size,
            @RequestParam(value = "sort", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sort
    ) {
        List<CountryEntity> countries = this.countryService.getCountries(page, size, sort);
        List<CountryDTO> countriesDTO = (List<CountryDTO>)countries.stream().map(country -> (CountryDTO)this.modelMapper.map(country, CountryDTO.class)).collect(Collectors.toList());

        return new ResponseEntity(countriesDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable(value = "id") Long id,
                                                    @RequestBody CountryDTO country) {
        CountryEntity countryEntity = this.countryService.updateCountry(id, country);
        CountryDTO countryDTO = (CountryDTO)this.modelMapper.map(countryEntity, CountryDTO.class);
        return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable(value = "id") Long id) {
        this.countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
