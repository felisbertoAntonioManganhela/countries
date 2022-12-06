package com.soft2ibi.countries.repository;

import com.soft2ibi.countries.model.CountryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {
    CountryEntity findByName(String name);
    Page<CountryEntity> findAll(Pageable pageable);
}
