package com.soft2ibi.countries.repository;

import com.soft2ibi.countries.model.CountryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {
    CountryEntity findByName(String name);
}
