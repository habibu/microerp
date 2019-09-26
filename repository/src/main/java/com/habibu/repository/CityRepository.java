package com.habibu.repository;
import com.habibu.model.City;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = CityRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = City.class)
public interface CityRepository extends ReadOnlyRepository<City, Long>, CityRepositoryCustom {
}
