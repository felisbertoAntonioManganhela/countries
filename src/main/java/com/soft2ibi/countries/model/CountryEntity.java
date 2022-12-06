package com.soft2ibi.countries.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "COUNTRY")
public class CountryEntity extends LifeCycleEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CAPITAL", nullable = false)
    private String capital;

    @Column(name = "REGION", nullable = false)
    private String region;

    @Column(name = "SUB_REGION", nullable = false)
    private String subregion;

    @Column(name = "AREA", nullable = false)
    private double area;

}