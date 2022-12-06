package com.soft2ibi.countries.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class CountryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "name is mandatory")
    private String name;

    @NotEmpty(message = "Capital is mandatory")
    private String capital;

    @NotEmpty(message = "Region is mandatory")
    private String region;

    @NotEmpty(message = "Sub-Region is mandatory")
    private String subregion;

    @Min( value = 0 , message =  "Value not allowed")
    private double area;
}
