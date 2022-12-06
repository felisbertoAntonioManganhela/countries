package com.soft2ibi.countries.controller;

import com.soft2ibi.countries.service.ICountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = {"/v1/country"}, produces = {"application/json"})
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @Autowired
    private ModelMapper modelMapper;

}
