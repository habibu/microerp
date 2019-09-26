package com.habibu.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.City;

/**
 * = CityRepositoryImpl
 *
 * Implementation of CityRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = CityRepositoryCustom.class)
public class CityRepositoryImpl extends QueryDslRepositorySupportExt<City> implements CityRepositoryCustom{

    /**
     * Default constructor
     */
    CityRepositoryImpl() {
        super(City.class);
    }
}